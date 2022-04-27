package com.is.cole.services.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.dtos.PosicionDto;
import com.is.cole.dtos.Usuarios.RoleDto;
import com.is.cole.dtos.Usuarios.UsuarioDto;
import com.is.cole.dtos.Viajes.ViajeDto;
import com.is.cole.dtos.colectivos.ColectivoDto;
import com.is.cole.dtos.colectivos.EmpresaDeColectivosDto;
import com.is.cole.dtos.colectivos.LineaDeColectivosDto;
import com.is.cole.dtos.paradas.ParadaDto;
import com.is.cole.dtos.recorridos.PuntoDeRecorridoDto;
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.services.colectivos.IColectivoService;
import com.is.cole.services.empresaColectivos.IEmpresaColectivosService;
import com.is.cole.services.lineas.ILineaColectivosService;
import com.is.cole.services.paradas.IParadaService;
import com.is.cole.services.recorridos.IRecorridoService;
import com.is.cole.services.usuarios.IUsuariosService;
import com.is.cole.services.viajes.IViajesService;

@Service
public class TestServiceImpl implements ITestService {
	
	@Autowired
	private IColectivoService colectivoService;
	
	@Autowired
	private IEmpresaColectivosService empresaService;
	
	@Autowired
	private ILineaColectivosService lineaService;

	@Autowired
	private IParadaService paradaService;
	
	@Autowired
	private IUsuariosService usuarioService;
	
	@Autowired
	private IRecorridoService recorridoService;
	
	@Autowired
	private IViajesService viajeService;
	@Override
	@Transactional
	public void insertTestValues() {
		
		LineaDeColectivosDto dtoLinea = new LineaDeColectivosDto();
		
		dtoLinea.setNumero("Linea 1");
		
		dtoLinea = lineaService.saveLineaColectivo(dtoLinea);
		
		
		EmpresaDeColectivosDto dtoEmpresa = new EmpresaDeColectivosDto();
		
		dtoEmpresa.setNombre("Urbano");
		dtoEmpresa.setCorreo_electronico("urbano@gmail.com");
		dtoEmpresa.setDireccion("Ruta 6");
		dtoEmpresa.setNumero_telefono("098756485");
		
		dtoEmpresa = empresaService.saveEmpresaColectivo(dtoEmpresa);
		
		ColectivoDto dtoColectivo = new ColectivoDto();
		
		dtoColectivo.setLineaId(dtoLinea.getId());
		dtoColectivo.setEmpresaId(dtoEmpresa.getId());
		dtoColectivo.setNumero("23");
		
		dtoColectivo= colectivoService.saveColectivo(dtoColectivo);
		
		ParadaDto dtoParada = new ParadaDto();
		
		dtoParada.setNombre("Zona UNI");
		dtoParada.setDescripcion("Es la parada de zona uni");
		
		dtoParada.setPosicion(new PosicionDto());
		dtoParada.getPosicion().setLatitud(-27.339012150883054);
		dtoParada.getPosicion().setLongitud(-55.86876702613541);

		dtoParada.setImage(null);
		
		
		paradaService.saveParada(dtoParada);
		
		UsuarioDto dtoUsuario = new UsuarioDto();
		RoleDto dtoRole = new RoleDto();
		
		dtoUsuario.setNombre("Admin");
		dtoUsuario.setApellido("Master");
		dtoUsuario.setCorreo_electronico("admin");
		dtoUsuario.setPassword("muysecreto");
		
		dtoRole.setNombre("ROLE_ADMIN");
		dtoRole.setDescripcion("Es admin");
		
		dtoRole = usuarioService.saveRole(dtoRole);
		dtoUsuario = usuarioService.saveUsuario(dtoUsuario);
		usuarioService.agregarRoleAUsuario(dtoUsuario.getId(), dtoRole.getId());
		
		
		RecorridoDto dtoRecorrido = new RecorridoDto();
		dtoRecorrido.setDescripcion("Recorrido principal ");
		dtoRecorrido.setNombre("Principal A");
		
		List<PuntoDeRecorridoDto> puntos = new ArrayList<>();
		
		PuntoDeRecorridoDto punto1 = new PuntoDeRecorridoDto();
		punto1.setPuntoPosicion(new PosicionDto());
		punto1.getPuntoPosicion().setLatitud(-27.32553598706966);
		punto1.getPuntoPosicion().setLongitud(-55.87323965294769);
		
		PuntoDeRecorridoDto punto2 = new PuntoDeRecorridoDto();
		punto2.setPuntoPosicion(new PosicionDto());
		punto2.getPuntoPosicion().setLatitud(-27.32681193023178);
		punto2.getPuntoPosicion().setLongitud(-55.873084804357816);
		
		PuntoDeRecorridoDto punto3 = new PuntoDeRecorridoDto();
		punto3.setPuntoPosicion(new PosicionDto());
		punto3.getPuntoPosicion().setLatitud(-27.326738698790326);
		punto3.getPuntoPosicion().setLongitud(-55.87183201109447);
		
		PuntoDeRecorridoDto punto4 = new PuntoDeRecorridoDto();
		punto4.setPuntoPosicion(new PosicionDto());
		punto4.getPuntoPosicion().setLatitud(-27.326706638662156);
		punto4.getPuntoPosicion().setLongitud(-55.87157488864356);
		
		PuntoDeRecorridoDto punto5 = new PuntoDeRecorridoDto();
		punto5.setPuntoPosicion(new PosicionDto());
		punto5.getPuntoPosicion().setLatitud(-27.32811194846384);
		punto5.getPuntoPosicion().setLongitud(-55.87149364827277);
		
		PuntoDeRecorridoDto punto6 = new PuntoDeRecorridoDto();
		punto6.setPuntoPosicion(new PosicionDto());
		punto6.getPuntoPosicion().setLatitud(-27.329523170657676);
		punto6.getPuntoPosicion().setLongitud(-55.87135405356195);
		
		PuntoDeRecorridoDto punto7 = new PuntoDeRecorridoDto();
		punto7.setPuntoPosicion(new PosicionDto());
		punto7.getPuntoPosicion().setLatitud(-27.329393815116873);
		punto7.getPuntoPosicion().setLongitud(-55.869855702624186);
		
		PuntoDeRecorridoDto punto8 = new PuntoDeRecorridoDto();
		punto8.setPuntoPosicion(new PosicionDto());
		punto8.getPuntoPosicion().setLatitud(-27.329256116154863);
		punto8.getPuntoPosicion().setLongitud(-55.868354647830834);
		
		PuntoDeRecorridoDto punto9 = new PuntoDeRecorridoDto();
		punto9.setPuntoPosicion(new PosicionDto());
		punto9.getPuntoPosicion().setLatitud(-27.330586227003);
		punto9.getPuntoPosicion().setLongitud(-55.86822514830496);
		
		puntos.add(punto1);
		puntos.add(punto2);
		puntos.add(punto3);
		puntos.add(punto4);
		puntos.add(punto5);
		puntos.add(punto6);
		puntos.add(punto7);
		puntos.add(punto8);
		puntos.add(punto9);
		
		dtoRecorrido.setPuntos(puntos);
		
		recorridoService.saveRecorrido(dtoRecorrido);
		
		//Para agregar un viaje
		
		//Primero un chofer y su rol
		
		UsuarioDto dtoUsuarioAntonio = new UsuarioDto();
		RoleDto dtoRoleChofer = new RoleDto();
		
		dtoUsuarioAntonio.setNombre("Antonio");
		dtoUsuarioAntonio.setApellido("Villas");
		dtoUsuarioAntonio.setCorreo_electronico("antonio@gmail.com");
		dtoUsuarioAntonio.setPassword("muysecreto");
		
		dtoRoleChofer.setNombre("ROLE_CHOFER");
		dtoRoleChofer.setDescripcion("Maneja los colectivos");
		
		dtoRoleChofer = usuarioService.saveRole(dtoRoleChofer);
		dtoUsuarioAntonio= usuarioService.saveUsuario(dtoUsuarioAntonio);
		usuarioService.agregarRoleAUsuario(dtoUsuarioAntonio.getId(), dtoRoleChofer.getId());
		
		//Agregamos el viaje 
		
		ViajeDto viaje = new ViajeDto();
		viaje.setChofer_id(dtoUsuarioAntonio.getId());
		viaje.setColectivo_id(dtoColectivo.getId());
		viaje.setDestino("Circuito");
		viaje.setRecorrido_id(recorridoService.getAllRecorrido().getResult().get(0).getId());
		viajeService.saveViaje(viaje);
		
		//Agregamos el recorrido Zona centro a UNI
		
		RecorridoDto dtoRecorridoUni = new RecorridoDto();
		dtoRecorrido.setDescripcion("Recorrido Zona Centro a UNI ");
		dtoRecorrido.setNombre("Principal UNI");
		
		List<PuntoDeRecorridoDto> puntosUni = new ArrayList<>();
		
		PuntoDeRecorridoDto puntoUni1 = new PuntoDeRecorridoDto();
		puntoUni1.setPuntoPosicion(new PosicionDto());
		puntoUni1.getPuntoPosicion().setLatitud(-27.309675906048817);
		puntoUni1.getPuntoPosicion().setLongitud(-55.8866588781164);
		
		PuntoDeRecorridoDto puntoUni2 = new PuntoDeRecorridoDto();
		puntoUni2.setPuntoPosicion(new PosicionDto());
		puntoUni2.getPuntoPosicion().setLatitud(-27.30855247497118);
		puntoUni2.getPuntoPosicion().setLongitud(-55.88844384308095);
		
		PuntoDeRecorridoDto puntoUni3 = new PuntoDeRecorridoDto();
		puntoUni3.setPuntoPosicion(new PosicionDto());
		puntoUni3.getPuntoPosicion().setLatitud(-27.307803514569393);
		puntoUni3.getPuntoPosicion().setLongitud(-55.88771250328124);
		
		PuntoDeRecorridoDto puntoUni4 = new PuntoDeRecorridoDto();
		puntoUni4.setPuntoPosicion(new PosicionDto());
		puntoUni4.getPuntoPosicion().setLatitud(-27.306602964630766);
		puntoUni4.getPuntoPosicion().setLongitud(-55.88678283402331);
		
		PuntoDeRecorridoDto puntoUni5 = new PuntoDeRecorridoDto();
		puntoUni5.setPuntoPosicion(new PosicionDto());
		puntoUni5.getPuntoPosicion().setLatitud(-27.30583196240876);
		puntoUni5.getPuntoPosicion().setLongitud(-55.88615065892791);
		
		PuntoDeRecorridoDto puntoUni6 = new PuntoDeRecorridoDto();
		puntoUni6.setPuntoPosicion(new PosicionDto());
		puntoUni6.getPuntoPosicion().setLatitud(-27.30519312793853);
		puntoUni6.getPuntoPosicion().setLongitud(-55.887452195889026);
		
		puntosUni.add(puntoUni1);
		puntosUni.add(puntoUni2);
		puntosUni.add(puntoUni3);
		puntosUni.add(puntoUni4);
		puntosUni.add(puntoUni5);
		puntosUni.add(puntoUni6);
		
		dtoRecorridoUni.setPuntos(puntosUni);
		
		recorridoService.saveRecorrido(dtoRecorridoUni);
		
		//Un update del viaje del chofer Antonio
		viaje.setRecorrido_id(recorridoService.getAllRecorrido().getResult().get(1).getId());
		viajeService.saveViaje(viaje);
		
	}
}
