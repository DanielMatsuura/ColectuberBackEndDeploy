package com.is.cole.services.colectuber;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IColectivoDao;
import com.is.cole.daos.IColectivoUbicacionDao;
import com.is.cole.daos.IRecorridoDao;
import com.is.cole.dtos.PosicionDto;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.Usuarios.UsuarioDto;
import com.is.cole.dtos.Viajes.ViajeDto;
import com.is.cole.dtos.colectivos.ColectivoDto;
import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.ColectuberColectivoDto;
import com.is.cole.dtos.colectuber.InitialDataDto;
import com.is.cole.dtos.colectuber.UsuarioChoferDto;
import com.is.cole.dtos.colectuber.InitialViajeDto;
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.entities.ColectivoUbicacion;
import com.is.cole.services.colectivos.IColectivoService;
import com.is.cole.services.empresaColectivos.IEmpresaColectivosService;
import com.is.cole.services.lineas.ILineaColectivosService;
import com.is.cole.services.paradas.IParadaService;
import com.is.cole.services.recorridos.IRecorridoService;
import com.is.cole.services.usuarios.IUsuariosService;
import com.is.cole.services.viajes.IViajesService;

/**
 * Servicios principales de la aplicacion para devolver y obtener los datos principales a la web y 
 * a la app 
 * @author Colectuber
 */
@Service
public class ColectuberServiceImpl implements IColectuberService {
	
	/**
	 * Se obtiene los datos iniciales: colectivos, colectivos ubicacion, paradas
	 * y recorridos y se devuelve en un dto
	 */
	@Override
	@Transactional
	public InitialDataDto getInitialData() {

		InitialDataDto dto = new InitialDataDto();

		//Se obtiene todos los colectivos
		dto.setColectivos(colectivoService.getAllColectivo().getResult().stream()
				.map(c -> parseColectivoDtoToDtoColectuberDto(c)).collect(Collectors.toList()));

		//Se obtiene todas las paradas
		dto.setParadas(paradaService.getAllParadas().getResult());

		//Se obtiene todos los recorridos
		dto.setRecorridos(recorridoService.getAllRecorrido().getResult());
		
		//Se obtiene todas las ubicaciones de los colectivo
		dto.setColectivoUbicacion(getColectivosUbicacion().getResult());

		return dto;
	}
	
	/**
	 * Se guarda un colectivo ubicacion, por medio del username del chofer
	 */
	@Override
	@Transactional
	public void postColectivoUbicacion(ColectivoUbicacionDto dto,String username) {
		
		//Se obtiene el viaje correspondiente al chofer
		UsuarioDto user= usuarioService.getUsuarioByCorreo(username);
		ViajeDto viaje = viajeService.getByChoferIdViaje(user.getId());
	
		//Se obtiene el indice y porcentaje actual del colectivo con respecto al recorrido
		double indicePorcentaje = getIndicePorcentajeFromPoint(recorridoService.getRecorrido(viaje.getRecorrido_id()), dto.getPosicionColectivo());
		
		//Se crea y almacena la ubicacion
		ColectivoUbicacionDto dtoNuevo= new ColectivoUbicacionDto();
		dtoNuevo.setColectivoId(viaje.getColectivo_id());
		dtoNuevo.setChofer_id(user.getId());
		dtoNuevo.setIndicePorcentaje(indicePorcentaje);
		dtoNuevo.setPosicionColectivo(dto.getPosicionColectivo());
		dtoNuevo.setRecorrido_id(viaje.getRecorrido_id());
		dtoNuevo.setDestino(viaje.getDestino());
		
		ColectivoUbicacion ubi = parseDtoToBeanColectivoUbicacion(dtoNuevo);
		colectivoUbicacionDao.save(ubi);
	}

	/**
	 * Se obtiene todos las ubicaciones de los colectivos
	 */
	@Override
	@Transactional
	public Result<ColectivoUbicacionDto> getColectivosUbicacion() {
		Result<ColectivoUbicacionDto> dtos = new Result<>();

		List<ColectivoUbicacionDto> listaDtos = colectivoUbicacionDao.findAll().stream()
				.map(colectivoUbicacion -> parseBeanToDtoColectivoUbicacion(colectivoUbicacion))
				.collect(Collectors.toList());

		dtos.setResult(listaDtos);

		return dtos;
	}
	
	/**
	 * Se obtiene un chofer por medio del username
	 */
	@Override
	@Transactional
	public UsuarioChoferDto getChofer(String choferUsername) {
		UsuarioDto userDto = usuarioService.getUsuarioByCorreo(choferUsername);
		UsuarioChoferDto dto = new UsuarioChoferDto();

		dto.setId(userDto.getId());
		dto.setNombre(userDto.getNombre());
		dto.setApellido(userDto.getApellido());
		dto.setCorreo_electronico(userDto.getCorreo_electronico());

		return dto;
	}
	
	/**
	 * Se obtiene el viaje por medio el username del chofer
	 */
	@Override
	@Transactional
	public InitialViajeDto getViaje(String choferUsername) {
		UsuarioDto userDto = usuarioService.getUsuarioByCorreo(choferUsername);

		InitialViajeDto dto = new InitialViajeDto();

		ViajeDto viajeDto = viajeService.getByChoferIdViaje(userDto.getId());
		dto.setColectivo(colectivoService.getColectivo(viajeDto.getColectivo_id()));
		dto.setRecorrido(recorridoService.getRecorrido(viajeDto.getRecorrido_id()));
		
		return dto;
	}

	/****************************** Special Functions *************************************/
	
	/**
	 * Se obtiene en una variable el indice y porcentaje actual de un punto de posicion en un recorrido
	 * @param recorrido
	 * @param punto
	 * @return
	 */
	private Double getIndicePorcentajeFromPoint(RecorridoDto recorrido, PosicionDto punto) {

		// Calcula la linea mas cercana al punto
		Integer indice = null;
		PosicionDto puntoR = null;

		for (int i = 0; i < recorrido.getPuntos().size() - 1; i++) {
			PosicionDto posActual = recorrido.getPuntos().get(i).getPuntoPosicion();
			PosicionDto posSig = recorrido.getPuntos().get(i + 1).getPuntoPosicion();

			PosicionDto posInter = intersectionPointToLine(punto, posActual, posSig);

			if (indice == null) {
				indice = i;
				puntoR = posInter;
			} else {
				double distanceRP = distancePointToPoint(punto, puntoR);
				double distanceIP = distancePointToPoint(punto, posInter);

				if (distanceIP < distanceRP) {
					indice = i;
					puntoR = posInter;
				}
			}
		}

		// Pasa a indice porcentaje

		PosicionDto posIndice = recorrido.getPuntos().get(indice).getPuntoPosicion();
		PosicionDto posIndiceSig = recorrido.getPuntos().get(indice + 1).getPuntoPosicion();

		double distanceIR = distancePointToPoint(posIndice, puntoR);
		double distanceIS = distancePointToPoint(posIndice, posIndiceSig);

		double porcentaje = distanceIR / distanceIS;

		double indicePorcentaje = indice + porcentaje;

		return indicePorcentaje;
	}

	/**
	 * Se calcula la distancia de un punto a otro punto
	 * @param punto1
	 * @param punto2
	 * @return
	 */
	private Double distancePointToPoint(PosicionDto punto1, PosicionDto punto2) {
		double resultado;
		double x1, y1, x2, y2;

		x1 = punto1.getLongitud();
		y1 = punto1.getLatitud();

		x2 = punto2.getLongitud();
		y2 = punto2.getLatitud();

		double dx = x2 - x1;
		double dy = y2 - y1;

		resultado = Math.sqrt(dx * dx + dy * dy);
		return resultado;
	}

	/**
	 * Interseccion de un punto con una linea 
	 * Quitamos la formula de este post
	 * https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment
	 * @param punto
	 * @param rectaPunto1
	 * @param rectaPunto2
	 * @return
	 */
	private PosicionDto intersectionPointToLine(PosicionDto punto, PosicionDto rectaPunto1, PosicionDto rectaPunto2) {

		double x, y, x1, y1, x2, y2;
		x = punto.getLongitud();
		y = punto.getLatitud();
		x1 = rectaPunto1.getLongitud();
		y1 = rectaPunto1.getLatitud();
		x2 = rectaPunto2.getLongitud();
		y2 = rectaPunto2.getLatitud();

		double A = x - x1;
		double B = y - y1;
		double C = x2 - x1;
		double D = y2 - y1;

		double dot = A * C + B * D;
		double len_sq = C * C + D * D;
		double param = -1;

		if (len_sq != 0) {
			param = dot / len_sq;
		}

		double xx, yy;

		if (param < 0) {
			xx = x1;
			yy = y1;
		} else if (param > 1) {
			xx = x2;
			yy = y2;
		} else {
			xx = x1 + param * C;
			yy = y1 + param * D;
		}

		PosicionDto resultado = new PosicionDto();
		resultado.setLongitud(xx);
		resultado.setLatitud(yy);
		return resultado;
	}

	
	/********************************Parses**************************************************/
  
	private ColectivoUbicacion parseDtoToBeanColectivoUbicacion(ColectivoUbicacionDto dto) {
		ColectivoUbicacion ubi = new ColectivoUbicacion();
		ubi.setId(dto.getColectivoId());
		ubi.setColectivo(colectivoDao.getById(dto.getColectivoId()));
		ubi.setLat(dto.getPosicionColectivo().getLatitud());
		ubi.setLng(dto.getPosicionColectivo().getLongitud());
		ubi.setTime(System.currentTimeMillis());
		ubi.setDestino(dto.getDestino());
		
		ubi.setRecorrido(recorridoDao.getById(dto.getRecorrido_id()));
		ubi.setIndicePorcentaje(dto.getIndicePorcentaje());
		return ubi;
	}

	private ColectivoUbicacionDto parseBeanToDtoColectivoUbicacion(ColectivoUbicacion bean) {

		ColectivoUbicacionDto dto = new ColectivoUbicacionDto();

		PosicionDto posDto = new PosicionDto();
		posDto.setLatitud(bean.getLat());
		posDto.setLongitud(bean.getLng());

		dto.setColectivoId(bean.getColectivo().getId());
		dto.setPosicionColectivo(posDto);
		dto.setDestino(bean.getDestino());
		
		dto.setIndicePorcentaje(bean.getIndicePorcentaje());
		dto.setRecorrido_id(bean.getRecorrido().getId());
		return dto;
	}

	private ColectuberColectivoDto parseColectivoDtoToDtoColectuberDto(ColectivoDto dto) {

		ColectuberColectivoDto newDto = new ColectuberColectivoDto();

		newDto.setId(dto.getId());
		newDto.setEmpresa(empresaService.getEmpresaColectivo(dto.getEmpresaId()).getNombre());
		newDto.setLinea(lineaService.getLineaColectivo(dto.getLineaId()).getNumero());
		newDto.setNumero(dto.getNumero());

		return newDto;

	}

	/******************************** Variable Privadas **************************************************/
	@Autowired
	private IColectivoUbicacionDao colectivoUbicacionDao;
	@Autowired
	private IColectivoDao colectivoDao;
	@Autowired
	private IColectivoService colectivoService;
	@Autowired
	private IParadaService paradaService;
	@Autowired
	private IRecorridoService recorridoService;
	@Autowired
	private IRecorridoDao recorridoDao;
	@Autowired
	private IViajesService viajeService;
	@Autowired
	private IEmpresaColectivosService empresaService;
	@Autowired
	private ILineaColectivosService lineaService;
	@Autowired
	private IUsuariosService usuarioService;

}
