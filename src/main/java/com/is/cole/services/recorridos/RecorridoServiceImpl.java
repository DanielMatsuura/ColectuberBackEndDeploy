package com.is.cole.services.recorridos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.is.cole.daos.IColorDao;
import com.is.cole.daos.IParadaDao;
import com.is.cole.daos.IPuntoDeRecorridoDao;
import com.is.cole.daos.IRecorridoDao;
import com.is.cole.dtos.PosicionDto;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.recorridos.PuntoDeRecorridoDto;
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.entities.PuntoDeRecorrido;
import com.is.cole.entities.Recorrido;

/**
 * Servicio para la manipulacion de los recorridos de un viaje
 * @author Colectuber
 */
@Service
public class RecorridoServiceImpl implements IRecorridoService {
	
	/********************** Cruds de Recorrido **********************/
	@Override
	@Transactional
	public RecorridoDto saveRecorrido(RecorridoDto dto) {
	
		//Si es update se obtiene el recorrido antiguo y se elimina los puntos de ese recorrido
		if (dto.getId() != null) {
			Recorrido recorridoBeanAntiguo = recorridoDao.getById(dto.getId());
			deletePuntosDeRecorrido(recorridoBeanAntiguo.getPunto_inicial());
		}
		//Se guarda los puntos del recorrido
		Recorrido recorridoBean = parseDtoToBeanRecorrido(dto);
		List<PuntoDeRecorrido> beansSaved = saveListPuntoDeRecorridoDto(dto.getPuntos());
		
		//Se setea el punto inicial del recorrido
		if (!beansSaved.isEmpty()) {
			recorridoBean.setPunto_inicial(beansSaved.get(0));
		} else {
			recorridoBean.setPunto_inicial(null);
		}
		
		//Se guarda el recorrido
		Recorrido beanGuardado=recorridoDao.save(recorridoBean);
		return parseBeanToDtoRecorrido(beanGuardado);

	}

	@Override
	@Transactional
	public RecorridoDto getRecorrido(Integer id) {
		//Se obtiene el recorrido por id
		Recorrido recorridoBeanObtenido = recorridoDao.getById(id);
		List<PuntoDeRecorrido> puntosRecorridoRecuperado = recuperarPuntosDeRecorrido(
				recorridoBeanObtenido.getPunto_inicial());
		
		//Se parsea el recorrido de bean a dto y se devuelve
		RecorridoDto dtoObtenido = parseBeanToDtoRecorrido(recorridoBeanObtenido);
		dtoObtenido.setPuntos(parseBeansToDtosPuntosDeRecorrido(puntosRecorridoRecuperado));
		return dtoObtenido;
	}

	@Override
	@Transactional
	public void deleteRecorrido(Integer id) {
		Recorrido beanRecorrido = recorridoDao.getById(id);
		recorridoDao.deleteById(id);

		deletePuntosDeRecorrido(beanRecorrido.getPunto_inicial());
	}

	@Override
	@Transactional
	public Result<RecorridoDto> getAllRecorrido() {
		Result<RecorridoDto> dtos = new Result<>();
		List<RecorridoDto> dtosObtenidos = new ArrayList<>();
		
		//Se obtiene todos los recorridos 
		recorridoDao.findAll().stream().map(recorridoBean -> dtosObtenidos.add(getRecorrido(recorridoBean.getId())))
				.collect(Collectors.toList());

		dtos.setResult(dtosObtenidos);

		return dtos;
	}

	/********************** Cruds de Puntos de Recorrido **********************/

	/**
	 * Se guarda la lista de puntos de un recorrido
	 * @param dtos
	 * @return
	 */
	private List<PuntoDeRecorrido> saveListPuntoDeRecorridoDto(List<PuntoDeRecorridoDto> dtos) {
		List<PuntoDeRecorrido> beans = new ArrayList<>();

		PuntoDeRecorrido beanPrevious = null;

		// Se obtiene el penultimo elemento y se relaciona con el ultimo elemento y asi sucesivamente
		// y se guarda el penultimo elemento ya relacionado
		for (int i = dtos.size() - 1; i >= 0; i--) {

			PuntoDeRecorrido bean = parseDtoToBeanPuntoRecorrido(dtos.get(i));
			bean.setSig_punto(beanPrevious);

			PuntoDeRecorrido beanSaved = puntoRecorridoDao.save(bean);
			beans.add(beanSaved);

			beanPrevious = beanSaved;

		}
		Collections.reverse(beans);
		return beans;
	}

	/**
	 * Se obtiene los puntos de recorrido a partir del primer elemento por que estan relacionados
	 * @param cabeza
	 * @return
	 */
	private List<PuntoDeRecorrido> recuperarPuntosDeRecorrido(PuntoDeRecorrido cabeza) {

		List<PuntoDeRecorrido> beansObtenido = new ArrayList<PuntoDeRecorrido>();
		PuntoDeRecorrido current = cabeza;

		while (current != null) {
			beansObtenido.add(current);
			current = current.getSig_punto();
		}
		return beansObtenido;
	}
	
	/**
	 * Se borran todos los puntos de recorrido
	 * @param cabeza
	 */
	private void deletePuntosDeRecorrido(PuntoDeRecorrido cabeza) {
		List<PuntoDeRecorrido> beansPuntos = recuperarPuntosDeRecorrido(cabeza);
		puntoRecorridoDao.deleteAll(beansPuntos);
	}

	
	/********************** Parses **********************/

	/**
	 * Parses Lista de puntos de Recorrido de beans a dtos
	 * @param beans
	 * @return
	 */
	private List<PuntoDeRecorridoDto> parseBeansToDtosPuntosDeRecorrido(List<PuntoDeRecorrido> beans) {

		List<PuntoDeRecorridoDto> dtos = new ArrayList<PuntoDeRecorridoDto>();
		beans.stream().map(bean -> dtos.add(parseBeanToDtoPuntoRecorrido(bean))).collect(Collectors.toList());

		return dtos;
	}

	/**
	 * Parse Puntos de recorrido de dto a bean
	 * @param dto
	 * @return
	 */
	private PuntoDeRecorrido parseDtoToBeanPuntoRecorrido(PuntoDeRecorridoDto dto) {
		if (dto == null) {
			return null;
		}
		PuntoDeRecorrido bean = new PuntoDeRecorrido();
		bean.setId(dto.getId());
		bean.setLatitud(dto.getPuntoPosicion().getLatitud());
		bean.setLongitud(dto.getPuntoPosicion().getLongitud());

		if (dto.getParadaId() != null) {
			bean.setParada(paradaDao.getById(dto.getParadaId()));
		} else {
			bean.setParada(null);
		}

		return bean;
	}
	
	/**
	 * Parse Puntos de recorrido de dto a bean
	 * @param bean
	 * @return
	 */
	private PuntoDeRecorridoDto parseBeanToDtoPuntoRecorrido(PuntoDeRecorrido bean) {
		if (bean == null) {
			return null;
		}
		PuntoDeRecorridoDto dto = new PuntoDeRecorridoDto();
		dto.setId(bean.getId());

		PosicionDto puntoDto = new PosicionDto();
		puntoDto.setLatitud(bean.getLatitud());
		puntoDto.setLongitud(bean.getLongitud());
		dto.setPuntoPosicion(puntoDto);

		if (bean.getParada() != null) {
			dto.setParadaId(bean.getParada().getId());
		} else {
			dto.setParadaId(null);
		}

		return dto;
	}

	private Recorrido parseDtoToBeanRecorrido(RecorridoDto dto) {
		Recorrido bean = new Recorrido();
		bean.setDescripcion(dto.getDescripcion());
		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		bean.setColor(colorDao.findByNombre(dto.getColor()));
		return bean;
	}

	private RecorridoDto parseBeanToDtoRecorrido(Recorrido bean) {
		RecorridoDto dto = new RecorridoDto();
		dto.setDescripcion(bean.getDescripcion());
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		dto.setColor(bean.getColor().getNombre());
		return dto;
	}
	
	/********************** Variables Privadas **********************/
	@Autowired
	private IParadaDao paradaDao;
	@Autowired
	private IPuntoDeRecorridoDao puntoRecorridoDao;
	@Autowired
	private IRecorridoDao recorridoDao;
	@Autowired
	private IColorDao colorDao;

}
