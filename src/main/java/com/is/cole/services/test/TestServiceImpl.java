package com.is.cole.services.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.is.cole.dtos.colores.ColorDto;
import com.is.cole.dtos.paradas.ParadaDto;
import com.is.cole.dtos.recorridos.PuntoDeRecorridoDto;
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.dtos.zonas.ZonaDto;
import com.is.cole.services.colectivos.IColectivoService;
import com.is.cole.services.colores.IColorService;
import com.is.cole.services.empresaColectivos.IEmpresaColectivosService;
import com.is.cole.services.lineas.ILineaColectivosService;
import com.is.cole.services.paradas.IParadaService;
import com.is.cole.services.recorridos.IRecorridoService;
import com.is.cole.services.usuarios.IUsuariosService;
import com.is.cole.services.viajes.IViajesService;
import com.is.cole.services.zonas.IZonaService;

@Service
/**
 * Servicio para añadir datos iniciales de prueba
 * 
 * @author Colectuber
 */
public class TestServiceImpl implements ITestService {

	@Override
	@Transactional
	public void insertTestValues() {
		insertViaje(insertRecorrido(insertParadas(insertZona()), insertColor()),
				insertColectivo(insertEmpresaColectivo(), insertLinea()), insertUsuarios(insertRoles()));

	}

	private Map<String, ViajeDto> insertViaje(Map<String, RecorridoDto> recorridoMap,
			Map<String, ColectivoDto> colectivoMap, Map<String, UsuarioDto> usuarioMap) {
		Map<String, ViajeDto> viajeMap = new HashMap<>();

		ViajeDto viajeCircuito = new ViajeDto();
		viajeCircuito.setDestino("Circuito");
		viajeCircuito.setRecorrido_id(recorridoMap.get("Recorrido Circuito").getId());
		viajeCircuito.setChofer_id(usuarioMap.get("antonio").getId());
		viajeCircuito.setColectivo_id(colectivoMap.get("Colectivo23").getId());

		viajeCircuito = viajeService.saveViaje(viajeCircuito);

		viajeMap.put("Viaje Circuito", viajeCircuito);

		ViajeDto viajeRuta6 = new ViajeDto();
		viajeRuta6.setDestino("Capitan Miranda");
		viajeRuta6.setRecorrido_id(recorridoMap.get("Recorrido Ruta 6").getId());
		viajeRuta6.setChofer_id(usuarioMap.get("mariano").getId());
		viajeRuta6.setColectivo_id(colectivoMap.get("Colectivo11").getId());

		viajeRuta6 = viajeService.saveViaje(viajeRuta6);

		viajeMap.put("Viaje Capitan Miranda", viajeRuta6);

		return viajeMap;
	}

	private Map<String, RecorridoDto> insertRecorrido(Map<String, ParadaDto> paradaMap,
			Map<String, ColorDto> colorMap) {

		Map<String, RecorridoDto> map = new HashMap<>();

		RecorridoDto dtoRecorridoCircuito = new RecorridoDto();
		dtoRecorridoCircuito.setDescripcion("Recorrido Ruta 1, San Juan del Paraná a Circuito");
		dtoRecorridoCircuito.setNombre("Principal Ruta 1 Circuito");
		dtoRecorridoCircuito.setColor(colorMap.get("red").getNombre());

		List<PuntoDeRecorridoDto> puntosCircuito = new ArrayList<>();

		PuntoDeRecorridoDto puntoCircuito1 = new PuntoDeRecorridoDto();
		puntoCircuito1.setPuntoPosicion(new PosicionDto());
		puntoCircuito1.getPuntoPosicion().setLatitud(-27.255055213899475);
		puntoCircuito1.getPuntoPosicion().setLongitud(-55.98523242207336);

		puntosCircuito.add(puntoCircuito1);

		PuntoDeRecorridoDto puntoCircuito2 = new PuntoDeRecorridoDto();
		puntoCircuito2.setPuntoPosicion(new PosicionDto());
		puntoCircuito2.getPuntoPosicion().setLatitud(-27.26003377430376);
		puntoCircuito2.getPuntoPosicion().setLongitud(-55.97991091936177);

		puntosCircuito.add(puntoCircuito2);

		PuntoDeRecorridoDto puntoCircuito3 = new PuntoDeRecorridoDto();
		puntoCircuito3.setPuntoPosicion(new PosicionDto());
		puntoCircuito3.getPuntoPosicion().setLatitud(-27.26039618953818);
		puntoCircuito3.getPuntoPosicion().setLongitud(-55.978666374372764);

		puntosCircuito.add(puntoCircuito3);

		PuntoDeRecorridoDto puntoCircuito4 = new PuntoDeRecorridoDto();
		puntoCircuito4.setPuntoPosicion(new PosicionDto());
		puntoCircuito4.getPuntoPosicion().setLatitud(-27.26039618953818);
		puntoCircuito4.getPuntoPosicion().setLongitud(-55.978666374372764);

		puntosCircuito.add(puntoCircuito4);

		PuntoDeRecorridoDto puntoCircuito5 = new PuntoDeRecorridoDto();
		puntoCircuito5.setPuntoPosicion(new PosicionDto());
		puntoCircuito5.getPuntoPosicion().setLatitud(-27.26031449215873);
		puntoCircuito5.getPuntoPosicion().setLongitud(-55.97690938024482);

		puntosCircuito.add(puntoCircuito5);

		PuntoDeRecorridoDto puntoCircuito6 = new PuntoDeRecorridoDto();
		puntoCircuito6.setPuntoPosicion(new PosicionDto());
		puntoCircuito6.getPuntoPosicion().setLatitud(-27.260201074629936);
		puntoCircuito6.getPuntoPosicion().setLongitud(-55.976411786723446);

		puntosCircuito.add(puntoCircuito6);

		PuntoDeRecorridoDto puntoCircuito7 = new PuntoDeRecorridoDto();
		puntoCircuito7.setPuntoPosicion(new PosicionDto());
		puntoCircuito7.getPuntoPosicion().setLatitud(-27.25801209367452);
		puntoCircuito7.getPuntoPosicion().setLongitud(-55.970453423293115);

		puntosCircuito.add(puntoCircuito7);

		PuntoDeRecorridoDto puntoCircuito8 = new PuntoDeRecorridoDto();
		puntoCircuito8.setPuntoPosicion(new PosicionDto());
		puntoCircuito8.getPuntoPosicion().setLatitud(-27.257944041762155);
		puntoCircuito8.getPuntoPosicion().setLongitud(-55.969751688839914);

		puntosCircuito.add(puntoCircuito8);

		PuntoDeRecorridoDto puntoCircuito9 = new PuntoDeRecorridoDto();
		puntoCircuito9.setPuntoPosicion(new PosicionDto());
		puntoCircuito9.getPuntoPosicion().setLatitud(-27.257966725725538);
		puntoCircuito9.getPuntoPosicion().setLongitud(-55.969292371771616);

		puntosCircuito.add(puntoCircuito9);

		PuntoDeRecorridoDto puntoCircuito10 = new PuntoDeRecorridoDto();
		puntoCircuito10.setPuntoPosicion(new PosicionDto());
		puntoCircuito10.getPuntoPosicion().setLatitud(-27.25859053324217);
		puntoCircuito10.getPuntoPosicion().setLongitud(-55.96760820909109);

		puntosCircuito.add(puntoCircuito10);

		PuntoDeRecorridoDto puntoCircuito11 = new PuntoDeRecorridoDto();
		puntoCircuito11.setPuntoPosicion(new PosicionDto());
		puntoCircuito11.getPuntoPosicion().setLatitud(-27.29211732521895);
		puntoCircuito11.getPuntoPosicion().setLongitud(-55.93365369426801);

		puntosCircuito.add(puntoCircuito11);

		PuntoDeRecorridoDto puntoCircuito12 = new PuntoDeRecorridoDto();
		puntoCircuito12.setPuntoPosicion(new PosicionDto());
		puntoCircuito12.getPuntoPosicion().setLatitud(-27.293007303588755);
		puntoCircuito12.getPuntoPosicion().setLongitud(-55.93158866664654);

		puntosCircuito.add(puntoCircuito12);

		PuntoDeRecorridoDto puntoCircuito13 = new PuntoDeRecorridoDto();
		puntoCircuito13.setPuntoPosicion(new PosicionDto());
		puntoCircuito13.getPuntoPosicion().setLatitud(-27.291596199144017);
		puntoCircuito13.getPuntoPosicion().setLongitud(-55.91641809238406);

		puntosCircuito.add(puntoCircuito13);

		// Puente Ruta 1 Quiteria
		PuntoDeRecorridoDto puntoCircuito14 = new PuntoDeRecorridoDto();
		puntoCircuito14.setPuntoPosicion(new PosicionDto());
		puntoCircuito14.getPuntoPosicion().setLatitud(-27.29197758048552);
		puntoCircuito14.getPuntoPosicion().setLongitud(-55.91429378287496);

		puntosCircuito.add(puntoCircuito14);

		PuntoDeRecorridoDto puntoCircuito15 = new PuntoDeRecorridoDto();
		puntoCircuito15.setPuntoPosicion(new PosicionDto());
		puntoCircuito15.getPuntoPosicion().setLatitud(-27.296690944851655);
		puntoCircuito15.getPuntoPosicion().setLongitud(-55.90573004662675);

		puntosCircuito.add(puntoCircuito15);

		PuntoDeRecorridoDto puntoCircuito16 = new PuntoDeRecorridoDto();
		puntoCircuito16.setPuntoPosicion(new PosicionDto());
		puntoCircuito16.getPuntoPosicion().setLatitud(-27.30208712147181);
		puntoCircuito16.getPuntoPosicion().setLongitud(-55.89740446981006);

		puntosCircuito.add(puntoCircuito16);

		PuntoDeRecorridoDto puntoCircuito17 = new PuntoDeRecorridoDto();
		puntoCircuito17.setPuntoPosicion(new PosicionDto());
		puntoCircuito17.getPuntoPosicion().setLatitud(-27.30490390675379);
		puntoCircuito17.getPuntoPosicion().setLongitud(-55.894311124265414);

		puntosCircuito.add(puntoCircuito17);

		PuntoDeRecorridoDto puntoParadaRuta1_1 = new PuntoDeRecorridoDto();
		ParadaDto paradaDto = paradaMap.get("Parada Petrobras");
		puntoParadaRuta1_1.setParadaId(paradaDto.getId());
		puntoParadaRuta1_1.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_1);

		PuntoDeRecorridoDto puntoParadaRuta1_2 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Hotel City");
		puntoParadaRuta1_2.setParadaId(paradaDto.getId());
		puntoParadaRuta1_2.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_2);

		PuntoDeRecorridoDto puntoParadaRuta1_3 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Zona Uni");
		puntoParadaRuta1_3.setParadaId(paradaDto.getId());
		puntoParadaRuta1_3.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_3);

		PuntoDeRecorridoDto puntoParadaRuta1_4 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Supermercado La Familia");
		puntoParadaRuta1_4.setParadaId(paradaDto.getId());
		puntoParadaRuta1_4.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_4);

		PuntoDeRecorridoDto puntoParadaRuta1_5 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Colegio Kennedy");
		puntoParadaRuta1_5.setParadaId(paradaDto.getId());
		puntoParadaRuta1_5.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_5);

		PuntoDeRecorridoDto puntoCircuito18 = new PuntoDeRecorridoDto();
		puntoCircuito18.setPuntoPosicion(new PosicionDto());
		puntoCircuito18.getPuntoPosicion().setLatitud(-27.31366580260424);
		puntoCircuito18.getPuntoPosicion().setLongitud(-55.87762052625255);

		puntosCircuito.add(puntoCircuito18);

		PuntoDeRecorridoDto puntoCircuito19 = new PuntoDeRecorridoDto();
		puntoCircuito19.setPuntoPosicion(new PosicionDto());
		puntoCircuito19.getPuntoPosicion().setLatitud(-27.314833422390926);
		puntoCircuito19.getPuntoPosicion().setLongitud(-55.87607447616899);

		puntosCircuito.add(puntoCircuito19);

		// Puente Costanera
		PuntoDeRecorridoDto puntoCircuito20 = new PuntoDeRecorridoDto();
		puntoCircuito20.setPuntoPosicion(new PosicionDto());
		puntoCircuito20.getPuntoPosicion().setLatitud(-27.316187453488972);
		puntoCircuito20.getPuntoPosicion().setLongitud(-55.87528488630374);

		puntosCircuito.add(puntoCircuito20);

		PuntoDeRecorridoDto puntoCircuito21 = new PuntoDeRecorridoDto();
		puntoCircuito21.setPuntoPosicion(new PosicionDto());
		puntoCircuito21.getPuntoPosicion().setLatitud(-27.321210960696177);
		puntoCircuito21.getPuntoPosicion().setLongitud(-55.87404252463375);

		puntosCircuito.add(puntoCircuito21);

		// Rotonda
		PuntoDeRecorridoDto puntoCircuito22 = new PuntoDeRecorridoDto();
		puntoCircuito22.setPuntoPosicion(new PosicionDto());
		puntoCircuito22.getPuntoPosicion().setLatitud(-27.32161322388676);
		puntoCircuito22.getPuntoPosicion().setLongitud(-55.87420817285771);

		puntosCircuito.add(puntoCircuito22);

		PuntoDeRecorridoDto puntoCircuito23 = new PuntoDeRecorridoDto();
		puntoCircuito23.setPuntoPosicion(new PosicionDto());
		puntoCircuito23.getPuntoPosicion().setLatitud(-27.322143031734818);
		puntoCircuito23.getPuntoPosicion().setLongitud(-55.87388791962573);

		puntosCircuito.add(puntoCircuito23);

		PuntoDeRecorridoDto puntoParadaRuta1_6 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Super 6 Costanera");
		puntoParadaRuta1_6.setParadaId(paradaDto.getId());
		puntoParadaRuta1_6.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaRuta1_6);

		PuntoDeRecorridoDto puntoCircuito24 = new PuntoDeRecorridoDto();
		puntoCircuito24.setPuntoPosicion(new PosicionDto());
		puntoCircuito24.getPuntoPosicion().setLatitud(-27.326914443343984);
		puntoCircuito24.getPuntoPosicion().setLongitud(-55.873217270546064);

		puntosCircuito.add(puntoCircuito24);

		PuntoDeRecorridoDto puntoParadaAvCaballero_1 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Hotel Real");
		puntoParadaAvCaballero_1.setParadaId(paradaDto.getId());
		puntoParadaAvCaballero_1.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaAvCaballero_1);

		PuntoDeRecorridoDto puntoCircuito25 = new PuntoDeRecorridoDto();
		puntoCircuito25.setPuntoPosicion(new PosicionDto());
		puntoCircuito25.getPuntoPosicion().setLatitud(-27.326640286418417);
		puntoCircuito25.getPuntoPosicion().setLongitud(-55.870054699268124);

		puntosCircuito.add(puntoCircuito25);

		PuntoDeRecorridoDto puntoCircuito26 = new PuntoDeRecorridoDto();
		puntoCircuito26.setPuntoPosicion(new PosicionDto());
		puntoCircuito26.getPuntoPosicion().setLatitud(-27.326691848255166);
		puntoCircuito26.getPuntoPosicion().setLongitud(-55.86946038247785);

		puntosCircuito.add(puntoCircuito26);

		PuntoDeRecorridoDto puntoParadaAvCaballero_2 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Mundo Mania");
		puntoParadaAvCaballero_2.setParadaId(paradaDto.getId());
		puntoParadaAvCaballero_2.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaAvCaballero_2);

		PuntoDeRecorridoDto puntoCircuito27 = new PuntoDeRecorridoDto();
		puntoCircuito27.setPuntoPosicion(new PosicionDto());
		puntoCircuito27.getPuntoPosicion().setLatitud(-27.32651241295923);
		puntoCircuito27.getPuntoPosicion().setLongitud(-55.86694382233417);

		puntosCircuito.add(puntoCircuito27);

		PuntoDeRecorridoDto puntoCircuito28 = new PuntoDeRecorridoDto();
		puntoCircuito28.setPuntoPosicion(new PosicionDto());
		puntoCircuito28.getPuntoPosicion().setLatitud(-27.32630113110705);
		puntoCircuito28.getPuntoPosicion().setLongitud(-55.8653410969685);

		puntosCircuito.add(puntoCircuito28);

		PuntoDeRecorridoDto puntoParadaCarlosAntLopez_1 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Esquina Doña Reina");
		puntoParadaCarlosAntLopez_1.setParadaId(paradaDto.getId());
		puntoParadaCarlosAntLopez_1.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaCarlosAntLopez_1);

		PuntoDeRecorridoDto puntoParadaCarlosAntLopez_2 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Hierro Center");
		puntoParadaCarlosAntLopez_2.setParadaId(paradaDto.getId());
		puntoParadaCarlosAntLopez_2.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaCarlosAntLopez_2);

		PuntoDeRecorridoDto puntoParadaCarlosAntLopez_3 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Banco Atlas");
		puntoParadaCarlosAntLopez_3.setParadaId(paradaDto.getId());
		puntoParadaCarlosAntLopez_3.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaCarlosAntLopez_3);

		PuntoDeRecorridoDto puntoParadaCarlosAntLopez_4 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Colegio Centro");
		puntoParadaCarlosAntLopez_4.setParadaId(paradaDto.getId());
		puntoParadaCarlosAntLopez_4.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaCarlosAntLopez_4);

		PuntoDeRecorridoDto puntoParadaCarlosAntLopez_5 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Terminal");
		puntoParadaCarlosAntLopez_5.setParadaId(paradaDto.getId());
		puntoParadaCarlosAntLopez_5.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaCarlosAntLopez_5);

		PuntoDeRecorridoDto puntoCircuito29 = new PuntoDeRecorridoDto();
		puntoCircuito29.setPuntoPosicion(new PosicionDto());
		puntoCircuito29.getPuntoPosicion().setLatitud(-27.340895094890367);
		puntoCircuito29.getPuntoPosicion().setLongitud(-55.86373487761778);

		puntosCircuito.add(puntoCircuito29);

		PuntoDeRecorridoDto puntoCircuito30 = new PuntoDeRecorridoDto();
		puntoCircuito30.setPuntoPosicion(new PosicionDto());
		puntoCircuito30.getPuntoPosicion().setLatitud(-27.34154946300029);
		puntoCircuito30.getPuntoPosicion().setLongitud(-55.86406703624476);

		puntosCircuito.add(puntoCircuito30);

		PuntoDeRecorridoDto puntoCircuito31 = new PuntoDeRecorridoDto();
		puntoCircuito31.setPuntoPosicion(new PosicionDto());
		puntoCircuito31.getPuntoPosicion().setLatitud(-27.343572046007036);
		puntoCircuito31.getPuntoPosicion().setLongitud(-55.859460480730995);

		puntosCircuito.add(puntoCircuito31);

		PuntoDeRecorridoDto puntoCircuito32 = new PuntoDeRecorridoDto();
		puntoCircuito32.setPuntoPosicion(new PosicionDto());
		puntoCircuito32.getPuntoPosicion().setLatitud(-27.34374657000926);
		puntoCircuito32.getPuntoPosicion().setLongitud(-55.85921048596473);

		puntosCircuito.add(puntoCircuito32);

		PuntoDeRecorridoDto puntoParadaSgtoReverchon = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Gobernacion");
		puntoParadaSgtoReverchon.setParadaId(paradaDto.getId());
		puntoParadaSgtoReverchon.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaSgtoReverchon);

		PuntoDeRecorridoDto puntoCircuito33 = new PuntoDeRecorridoDto();
		puntoCircuito33.setPuntoPosicion(new PosicionDto());
		puntoCircuito33.getPuntoPosicion().setLatitud(-27.344304906492386);
		puntoCircuito33.getPuntoPosicion().setLongitud(-55.85786726061542);

		puntosCircuito.add(puntoCircuito33);

		PuntoDeRecorridoDto puntoCircuito34 = new PuntoDeRecorridoDto();
		puntoCircuito34.setPuntoPosicion(new PosicionDto());
		puntoCircuito34.getPuntoPosicion().setLatitud(-27.347349383456507);
		puntoCircuito34.getPuntoPosicion().setLongitud(-55.85843987998082);

		puntosCircuito.add(puntoCircuito34);

		PuntoDeRecorridoDto puntoCircuito35 = new PuntoDeRecorridoDto();
		puntoCircuito35.setPuntoPosicion(new PosicionDto());
		puntoCircuito35.getPuntoPosicion().setLatitud(-27.347604274815417);
		puntoCircuito35.getPuntoPosicion().setLongitud(-55.85861404143631);

		puntosCircuito.add(puntoCircuito35);

		PuntoDeRecorridoDto puntoCircuito36 = new PuntoDeRecorridoDto();
		puntoCircuito36.setPuntoPosicion(new PosicionDto());
		puntoCircuito36.getPuntoPosicion().setLatitud(-27.348567705161834);
		puntoCircuito36.getPuntoPosicion().setLongitud(-55.858730098715824);

		puntosCircuito.add(puntoCircuito36);

		PuntoDeRecorridoDto puntoCircuito37 = new PuntoDeRecorridoDto();
		puntoCircuito37.setPuntoPosicion(new PosicionDto());
		puntoCircuito37.getPuntoPosicion().setLatitud(-27.348616256695458);
		puntoCircuito37.getPuntoPosicion().setLongitud(-55.85837480140368);

		puntosCircuito.add(puntoCircuito37);

		PuntoDeRecorridoDto puntoParadaZonaCircuito_1 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada La Placita");
		puntoParadaZonaCircuito_1.setParadaId(paradaDto.getId());
		puntoParadaZonaCircuito_1.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaZonaCircuito_1);

		PuntoDeRecorridoDto puntoCircuito38 = new PuntoDeRecorridoDto();
		puntoCircuito38.setPuntoPosicion(new PosicionDto());
		puntoCircuito38.getPuntoPosicion().setLatitud(-27.35068661320478);
		puntoCircuito38.getPuntoPosicion().setLongitud(-55.85550118797898);

		puntosCircuito.add(puntoCircuito38);

		PuntoDeRecorridoDto puntoParadaZonaCircuito_2 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Plaza de la amistad");
		puntoParadaZonaCircuito_2.setParadaId(paradaDto.getId());
		puntoParadaZonaCircuito_2.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaZonaCircuito_2);

		PuntoDeRecorridoDto puntoCircuito39 = new PuntoDeRecorridoDto();
		puntoCircuito39.setPuntoPosicion(new PosicionDto());
		puntoCircuito39.getPuntoPosicion().setLatitud(-27.350745567514448);
		puntoCircuito39.getPuntoPosicion().setLongitud(-55.84906288833752);

		puntosCircuito.add(puntoCircuito39);

		PuntoDeRecorridoDto puntoCircuito40 = new PuntoDeRecorridoDto();
		puntoCircuito40.setPuntoPosicion(new PosicionDto());
		puntoCircuito40.getPuntoPosicion().setLatitud(-27.35369192228204);
		puntoCircuito40.getPuntoPosicion().setLongitud(-55.84913628714226);

		puntosCircuito.add(puntoCircuito40);

		PuntoDeRecorridoDto puntoCircuito41 = new PuntoDeRecorridoDto();
		puntoCircuito41.setPuntoPosicion(new PosicionDto());
		puntoCircuito41.getPuntoPosicion().setLatitud(-27.354091943856798);
		puntoCircuito41.getPuntoPosicion().setLongitud(-55.84897377864633);

		puntosCircuito.add(puntoCircuito41);

		PuntoDeRecorridoDto puntoCircuito42 = new PuntoDeRecorridoDto();
		puntoCircuito42.setPuntoPosicion(new PosicionDto());
		puntoCircuito42.getPuntoPosicion().setLatitud(-27.355160035605508);
		puntoCircuito42.getPuntoPosicion().setLongitud(-55.8477154985702);

		puntosCircuito.add(puntoCircuito42);

		PuntoDeRecorridoDto puntoCircuito43 = new PuntoDeRecorridoDto();
		puntoCircuito43.setPuntoPosicion(new PosicionDto());
		puntoCircuito43.getPuntoPosicion().setLatitud(-27.35548994604027);
		puntoCircuito43.getPuntoPosicion().setLongitud(-55.84749727287559);

		puntosCircuito.add(puntoCircuito43);

		PuntoDeRecorridoDto puntoParadaZonaCircuito_3 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Circuito");
		puntoParadaZonaCircuito_3.setParadaId(paradaDto.getId());
		puntoParadaZonaCircuito_3.setPuntoPosicion(paradaDto.getPosicion());

		puntosCircuito.add(puntoParadaZonaCircuito_3);

		dtoRecorridoCircuito.setPuntos(puntosCircuito);

		dtoRecorridoCircuito = recorridoService.saveRecorrido(dtoRecorridoCircuito);

		map.put("Recorrido Circuito", dtoRecorridoCircuito);

		RecorridoDto dtoRecorridoCapitanMiranda = new RecorridoDto();
		dtoRecorridoCapitanMiranda.setDescripcion("Recorrido desde la terminal hasta capitan miranda");
		dtoRecorridoCapitanMiranda.setNombre("Ruta 6 Capitan Miranda");
		dtoRecorridoCapitanMiranda.setColor(colorMap.get("blue").getNombre());

		List<PuntoDeRecorridoDto> puntosRuta6 = new ArrayList<>();

		PuntoDeRecorridoDto puntoCapitanMiranda_1 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_1.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_1.getPuntoPosicion().setLatitud(-27.34026563342671);
		puntoCapitanMiranda_1.getPuntoPosicion().setLongitud(-55.864703605825);

		puntosRuta6.add(puntoCapitanMiranda_1);

		PuntoDeRecorridoDto puntoCapitanMiranda_2 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_2.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_2.getPuntoPosicion().setLatitud(-27.340840325054867);
		puntoCapitanMiranda_2.getPuntoPosicion().setLongitud(-55.86463981178381);

		puntosRuta6.add(puntoCapitanMiranda_2);

		PuntoDeRecorridoDto puntoCapitanMiranda_3 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_3.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_3.getPuntoPosicion().setLatitud(-27.34118885178881);
		puntoCapitanMiranda_3.getPuntoPosicion().setLongitud(-55.868260240381986);

		puntosRuta6.add(puntoCapitanMiranda_3);

		PuntoDeRecorridoDto puntoCapitanMiranda_4 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_4.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_4.getPuntoPosicion().setLatitud(-27.340973205771377);
		puntoCapitanMiranda_4.getPuntoPosicion().setLongitud(-55.86870025348229);

		puntosRuta6.add(puntoCapitanMiranda_4);

		PuntoDeRecorridoDto puntoCapitanMiranda_5 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_5.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_5.getPuntoPosicion().setLatitud(-27.34069016973115);
		puntoCapitanMiranda_5.getPuntoPosicion().setLongitud(-55.86858266377303);

		puntosRuta6.add(puntoCapitanMiranda_5);

		PuntoDeRecorridoDto puntoCapitanMiranda_6 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_6.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_6.getPuntoPosicion().setLatitud(-27.34069016973115);
		puntoCapitanMiranda_6.getPuntoPosicion().setLongitud(-55.86858266377303);

		puntosRuta6.add(puntoCapitanMiranda_6);

		PuntoDeRecorridoDto puntoParadaGralArtigas_1 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada La Junta");
		puntoParadaGralArtigas_1.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_1.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_1);

		PuntoDeRecorridoDto puntoCapitanMiranda_7 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_7.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_7.getPuntoPosicion().setLatitud(-27.33847986407693);
		puntoCapitanMiranda_7.getPuntoPosicion().setLongitud(-55.868902638987464);

		puntosRuta6.add(puntoCapitanMiranda_7);

		PuntoDeRecorridoDto puntoParadaGralArtigas_2 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Esquina Innovadent");
		puntoParadaGralArtigas_2.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_2.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_2);

		PuntoDeRecorridoDto puntoParadaGralArtigas_3 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Subida Upap Encarnacion");
		puntoParadaGralArtigas_3.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_3.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_3);

		PuntoDeRecorridoDto puntoCapitanMiranda_8 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_8.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_8.getPuntoPosicion().setLatitud(-27.334271218407018);
		puntoCapitanMiranda_8.getPuntoPosicion().setLongitud(-55.869289547057214);

		puntosRuta6.add(puntoCapitanMiranda_8);

		PuntoDeRecorridoDto puntoParadaGralArtigas_4 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Al Natural");
		puntoParadaGralArtigas_4.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_4.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_4);

		PuntoDeRecorridoDto puntoParadaGralArtigas_5 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada BENGELATO");
		puntoParadaGralArtigas_5.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_5.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_5);

		PuntoDeRecorridoDto puntoParadaGralArtigas_6 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Optica Gamon");
		puntoParadaGralArtigas_6.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_6.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_6);

		PuntoDeRecorridoDto puntoCapitanMiranda_9 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_9.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_9.getPuntoPosicion().setLatitud(-27.326636941800903);
		puntoCapitanMiranda_9.getPuntoPosicion().setLongitud(-55.87010770753962);

		puntosRuta6.add(puntoCapitanMiranda_9);

		PuntoDeRecorridoDto puntoCapitanMiranda_10 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_10.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_10.getPuntoPosicion().setLatitud(-27.326698816004);
		puntoCapitanMiranda_10.getPuntoPosicion().setLongitud(-55.869473924399976);

		puntosRuta6.add(puntoCapitanMiranda_10);

		PuntoDeRecorridoDto puntoCapitanMiranda_11 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_11.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_11.getPuntoPosicion().setLatitud(-27.32660736050076);
		puntoCapitanMiranda_11.getPuntoPosicion().setLongitud(-55.86858796598658);

		puntosRuta6.add(puntoCapitanMiranda_11);

		PuntoDeRecorridoDto puntoParadaGralArtigas_7 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Mundo Mania");
		puntoParadaGralArtigas_7.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_7.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_7);

		PuntoDeRecorridoDto puntoCapitanMiranda_12 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_12.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_12.getPuntoPosicion().setLatitud(-27.32651867405479);
		puntoCapitanMiranda_12.getPuntoPosicion().setLongitud(-55.86710217402087);

		puntosRuta6.add(puntoCapitanMiranda_12);

		PuntoDeRecorridoDto puntoParadaGralArtigas_8 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Chiperia Aaron");
		puntoParadaGralArtigas_8.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_8.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_8);

		PuntoDeRecorridoDto puntoParadaGralArtigas_9 = new PuntoDeRecorridoDto();
		paradaDto = paradaMap.get("Parada Carsuplay");
		puntoParadaGralArtigas_9.setParadaId(paradaDto.getId());
		puntoParadaGralArtigas_9.setPuntoPosicion(paradaDto.getPosicion());

		puntosRuta6.add(puntoParadaGralArtigas_9);

		PuntoDeRecorridoDto puntoCapitanMiranda_13 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_13.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_13.getPuntoPosicion().setLatitud(-27.325936481346805);
		puntoCapitanMiranda_13.getPuntoPosicion().setLongitud(-55.86096368657);

		puntosRuta6.add(puntoCapitanMiranda_13);

		PuntoDeRecorridoDto puntoCapitanMiranda_14 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_14.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_14.getPuntoPosicion().setLatitud(-27.325779209833083);
		puntoCapitanMiranda_14.getPuntoPosicion().setLongitud(-55.859343632321426);

		puntosRuta6.add(puntoCapitanMiranda_14);

		PuntoDeRecorridoDto puntoCapitanMiranda_15 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_15.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_15.getPuntoPosicion().setLatitud(-27.323469343234258);
		puntoCapitanMiranda_15.getPuntoPosicion().setLongitud(-55.85701410808214);

		puntosRuta6.add(puntoCapitanMiranda_15);

		PuntoDeRecorridoDto puntoCapitanMiranda_16 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_16.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_16.getPuntoPosicion().setLatitud(-27.320655039980767);
		puntoCapitanMiranda_16.getPuntoPosicion().setLongitud(-55.8554450158088);

		puntosRuta6.add(puntoCapitanMiranda_16);

		PuntoDeRecorridoDto puntoCapitanMiranda_17 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_17.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_17.getPuntoPosicion().setLatitud(-27.320180819286822);
		puntoCapitanMiranda_17.getPuntoPosicion().setLongitud(-55.85513656177058);

		puntosRuta6.add(puntoCapitanMiranda_17);

		PuntoDeRecorridoDto puntoCapitanMiranda_18 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_18.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_18.getPuntoPosicion().setLatitud(-27.315972521738363);
		puntoCapitanMiranda_18.getPuntoPosicion().setLongitud(-55.852780894630186);

		puntosRuta6.add(puntoCapitanMiranda_18);

		PuntoDeRecorridoDto puntoCapitanMiranda_19 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_19.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_19.getPuntoPosicion().setLatitud(-27.31534728691316);
		puntoCapitanMiranda_19.getPuntoPosicion().setLongitud(-55.852126811246);

		puntosRuta6.add(puntoCapitanMiranda_19);

		PuntoDeRecorridoDto puntoCapitanMiranda_20 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_20.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_20.getPuntoPosicion().setLatitud(-27.31502665230044);
		puntoCapitanMiranda_20.getPuntoPosicion().setLongitud(-55.85159903362103);

		puntosRuta6.add(puntoCapitanMiranda_20);

		PuntoDeRecorridoDto puntoCapitanMiranda_21 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_21.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_21.getPuntoPosicion().setLatitud(-27.314148910315634);
		puntoCapitanMiranda_21.getPuntoPosicion().setLongitud(-55.84907291847541);

		puntosRuta6.add(puntoCapitanMiranda_21);

		PuntoDeRecorridoDto puntoCapitanMiranda_22 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_22.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_22.getPuntoPosicion().setLatitud(-27.309875635840218);
		puntoCapitanMiranda_22.getPuntoPosicion().setLongitud(-55.84158874597306);

		puntosRuta6.add(puntoCapitanMiranda_22);

		PuntoDeRecorridoDto puntoCapitanMiranda_23 = new PuntoDeRecorridoDto();
		puntoCapitanMiranda_23.setPuntoPosicion(new PosicionDto());
		puntoCapitanMiranda_23.getPuntoPosicion().setLatitud(-27.30508390281704);
		puntoCapitanMiranda_23.getPuntoPosicion().setLongitud(-55.83723450962046);

		puntosRuta6.add(puntoCapitanMiranda_23);

		dtoRecorridoCapitanMiranda.setPuntos(puntosRuta6);

		dtoRecorridoCapitanMiranda = recorridoService.saveRecorrido(dtoRecorridoCapitanMiranda);

		map.put("Recorrido Ruta 6", dtoRecorridoCapitanMiranda);

		return map;

	}

	private Map<String, RoleDto> insertRoles() {
		Map<String, RoleDto> map = new HashMap<String, RoleDto>();

		RoleDto rolAdmin = new RoleDto();
		rolAdmin.setNombre("ROLE_ADMIN");
		rolAdmin.setDescripcion("El usuario con rol administrador tiene acceso a todo el sistema.");
		map.put("admin", usuarioService.saveRole(rolAdmin));

		RoleDto rolChofer = new RoleDto();
		rolChofer.setNombre("ROLE_CHOFER");
		rolChofer.setDescripcion("El usuario con rol chofer representa la persona que maneja un colectivo");
		map.put("chofer", usuarioService.saveRole(rolChofer));

		return map;
	}

	private Map<String, UsuarioDto> insertUsuarios(Map<String, RoleDto> rolMap) {
		Map<String, UsuarioDto> map = new HashMap<String, UsuarioDto>();

		UsuarioDto admin = new UsuarioDto();
		admin.setNombre("Administrador");
		admin.setApellido("Purete");
		admin.setCorreo_electronico("admin");
		admin.setPassword("muysecreto");
		map.put("admin", usuarioService.saveUsuario(admin));
		usuarioService.agregarRoleAUsuario(map.get("admin").getId(), rolMap.get("admin").getId());

		UsuarioDto chofer = new UsuarioDto();
		chofer.setNombre("Antonio");
		chofer.setApellido("Villas");
		chofer.setCorreo_electronico("antonio@gmail.com");
		chofer.setPassword("muysecreto");
		map.put("antonio", usuarioService.saveUsuario(chofer));
		usuarioService.agregarRoleAUsuario(map.get("antonio").getId(), rolMap.get("chofer").getId());

		UsuarioDto chofer_2 = new UsuarioDto();
		chofer_2.setNombre("Mariano");
		chofer_2.setApellido("Roque Alonso");
		chofer_2.setCorreo_electronico("mariano@gmail.com");
		chofer_2.setPassword("muysecreto");
		map.put("mariano", usuarioService.saveUsuario(chofer_2));
		usuarioService.agregarRoleAUsuario(map.get("mariano").getId(), rolMap.get("chofer").getId());
		return map;
	}

	private Map<String, ParadaDto> insertParadas(Map<String, ZonaDto> zonaMap) {
		Map<String, ParadaDto> map = new HashMap<String, ParadaDto>();

		ParadaDto paradaRuta1_1 = new ParadaDto();
		paradaRuta1_1.setNombre("Parada Petrobras");
		paradaRuta1_1.setDescripcion("Parada ruta 1 frente Av. 4");
		paradaRuta1_1.setPosicion(new PosicionDto());
		paradaRuta1_1.getPosicion().setLatitud(-27.30610661477075);
		paradaRuta1_1.getPosicion().setLongitud(-55.89254610085299);
		paradaRuta1_1.setImage(null);

		map.put("Parada Petrobras", paradaService.saveParada(paradaRuta1_1));

		ParadaDto paradaRuta1_2 = new ParadaDto();
		paradaRuta1_2.setNombre("Parada Hotel City");
		paradaRuta1_2.setDescripcion("Parada ruta 1 frente al hotel City");
		paradaRuta1_2.setPosicion(new PosicionDto());
		paradaRuta1_2.getPosicion().setLatitud(-27.306981212223608);
		paradaRuta1_2.getPosicion().setLongitud(-55.891181000556216);
		paradaRuta1_2.setImage(null);

		map.put("Parada Hotel City", paradaService.saveParada(paradaRuta1_2));

		ParadaDto paradaRuta1_3 = new ParadaDto();
		paradaRuta1_3.setNombre("Parada Zona Uni");
		paradaRuta1_3.setDescripcion("Parada ruta 1 UNI");
		paradaRuta1_3.setPosicion(new PosicionDto());
		paradaRuta1_3.getPosicion().setLatitud(-27.308664364353458);
		paradaRuta1_3.getPosicion().setLongitud(-55.88851370435971);
		paradaRuta1_3.setImage(null);
		paradaRuta1_3.setZona(zonaMap.get("Zona UNI").getNombre());

		map.put("Parada Zona Uni", paradaService.saveParada(paradaRuta1_3));

		ParadaDto paradaRuta1_4 = new ParadaDto();
		paradaRuta1_4.setNombre("Parada Supermercado La Familia");
		paradaRuta1_4.setDescripcion("Parada ruta 1, frente al supermercado la familia");
		paradaRuta1_4.setPosicion(new PosicionDto());
		paradaRuta1_4.getPosicion().setLatitud(-27.3114841856797);
		paradaRuta1_4.getPosicion().setLongitud(-55.88390687216109);
		paradaRuta1_4.setImage(null);

		map.put("Parada Supermercado La Familia", paradaService.saveParada(paradaRuta1_4));

		ParadaDto paradaRuta1_5 = new ParadaDto();
		paradaRuta1_5.setNombre("Parada Colegio Kennedy");
		paradaRuta1_5.setDescripcion("Parada ruta 1, frente al colegio John F. Kennedy");
		paradaRuta1_5.setPosicion(new PosicionDto());
		paradaRuta1_5.getPosicion().setLatitud(-27.312631684828208);
		paradaRuta1_5.getPosicion().setLongitud(-55.88072449336672);
		paradaRuta1_5.setImage(null);

		map.put("Parada Colegio Kennedy", paradaService.saveParada(paradaRuta1_5));

		ParadaDto paradaRuta1_6 = new ParadaDto();
		paradaRuta1_6.setNombre("Parada Super 6 Costanera");
		paradaRuta1_6.setDescripcion("Parada ruta 1, frente super 6 costanera");
		paradaRuta1_6.setPosicion(new PosicionDto());
		paradaRuta1_6.getPosicion().setLatitud(-27.32357055692744);
		paradaRuta1_6.getPosicion().setLongitud(-55.873611839255304);
		paradaRuta1_6.setImage(null);

		map.put("Parada Super 6 Costanera", paradaService.saveParada(paradaRuta1_6));

		ParadaDto paradaAvCaballero_1 = new ParadaDto();
		paradaAvCaballero_1.setNombre("Parada Hotel Real");
		paradaAvCaballero_1.setDescripcion("Parada Avenida Caballero, frente hotel real");
		paradaAvCaballero_1.setPosicion(new PosicionDto());
		paradaAvCaballero_1.getPosicion().setLatitud(-27.32670628556545);
		paradaAvCaballero_1.getPosicion().setLongitud(-55.87047722135734);
		paradaAvCaballero_1.setImage(null);

		map.put("Parada Hotel Real", paradaService.saveParada(paradaAvCaballero_1));

		ParadaDto paradaAvCaballero_2 = new ParadaDto();
		paradaAvCaballero_2.setNombre("Parada Mundo Mania");
		paradaAvCaballero_2.setDescripcion("Parada Avenida Caballero, frente a mundo mania");
		paradaAvCaballero_2.setPosicion(new PosicionDto());
		paradaAvCaballero_2.getPosicion().setLatitud(-27.32654541257507);
		paradaAvCaballero_2.getPosicion().setLongitud(-55.867412775419176);
		paradaAvCaballero_2.setImage(null);

		map.put("Parada Mundo Mania", paradaService.saveParada(paradaAvCaballero_2));

		ParadaDto paradaCarlosAntLopez_1 = new ParadaDto();
		paradaCarlosAntLopez_1.setNombre("Parada Esquina Doña Reina");
		paradaCarlosAntLopez_1.setDescripcion("Parada Carlos A. Lopez, esquina doña reina");
		paradaCarlosAntLopez_1.setPosicion(new PosicionDto());
		paradaCarlosAntLopez_1.getPosicion().setLatitud(-27.32751327416177);
		paradaCarlosAntLopez_1.getPosicion().setLongitud(-55.86524488183438);
		paradaCarlosAntLopez_1.setImage(null);

		map.put("Parada Esquina Doña Reina", paradaService.saveParada(paradaCarlosAntLopez_1));

		ParadaDto paradaCarlosAntLopez_2 = new ParadaDto();
		paradaCarlosAntLopez_2.setNombre("Parada Hierro Center");
		paradaCarlosAntLopez_2.setDescripcion("Parada Carlos A. Lopez, esquina hierro center");
		paradaCarlosAntLopez_2.setPosicion(new PosicionDto());
		paradaCarlosAntLopez_2.getPosicion().setLatitud(-27.328896067206827);
		paradaCarlosAntLopez_2.getPosicion().setLongitud(-55.86509726431732);
		paradaCarlosAntLopez_2.setImage(null);

		map.put("Parada Hierro Center", paradaService.saveParada(paradaCarlosAntLopez_2));

		ParadaDto paradaCarlosAntLopez_3 = new ParadaDto();
		paradaCarlosAntLopez_3.setNombre("Parada Banco Atlas");
		paradaCarlosAntLopez_3.setDescripcion("Parada Carlos A. Lopez, esquina banco atlas");
		paradaCarlosAntLopez_3.setPosicion(new PosicionDto());
		paradaCarlosAntLopez_3.getPosicion().setLatitud(-27.33151247100019);
		paradaCarlosAntLopez_3.getPosicion().setLongitud(-55.86479042955511);
		paradaCarlosAntLopez_3.setImage(null);

		map.put("Parada Banco Atlas", paradaService.saveParada(paradaCarlosAntLopez_3));

		ParadaDto paradaCarlosAntLopez_4 = new ParadaDto();
		paradaCarlosAntLopez_4.setNombre("Parada Colegio Centro");
		paradaCarlosAntLopez_4.setDescripcion("Parada Carlos A. Lopez, esquina stargol");
		paradaCarlosAntLopez_4.setPosicion(new PosicionDto());
		paradaCarlosAntLopez_4.getPosicion().setLatitud(-27.333958604879);
		paradaCarlosAntLopez_4.getPosicion().setLongitud(-55.864521921736795);
		paradaCarlosAntLopez_4.setImage(null);

		map.put("Parada Colegio Centro", paradaService.saveParada(paradaCarlosAntLopez_4));

		ParadaDto paradaCarlosAntLopez_5 = new ParadaDto();
		paradaCarlosAntLopez_5.setNombre("Parada Terminal");
		paradaCarlosAntLopez_5.setDescripcion("Parada Carlos A. Lopez, costado de la terminal de bus");
		paradaCarlosAntLopez_5.setPosicion(new PosicionDto());
		paradaCarlosAntLopez_5.getPosicion().setLatitud(-27.3404180233383);
		paradaCarlosAntLopez_5.getPosicion().setLongitud(-55.86382006960933);
		paradaCarlosAntLopez_5.setImage(null);

		map.put("Parada Terminal", paradaService.saveParada(paradaCarlosAntLopez_5));

		ParadaDto paradaSgtoRevenchon = new ParadaDto();
		paradaSgtoRevenchon.setNombre("Parada Gobernacion");
		paradaSgtoRevenchon.setDescripcion("Parada Sgto.Revenchon, costado de la gobernacion");
		paradaSgtoRevenchon.setPosicion(new PosicionDto());
		paradaSgtoRevenchon.getPosicion().setLatitud(-27.344185592805495);
		paradaSgtoRevenchon.getPosicion().setLongitud(-55.85817132115115);
		paradaSgtoRevenchon.setImage(null);

		map.put("Parada Gobernacion", paradaService.saveParada(paradaSgtoRevenchon));

		ParadaDto paradaZonaCircuito_1 = new ParadaDto();
		paradaZonaCircuito_1.setNombre("Parada La Placita");
		paradaZonaCircuito_1.setDescripcion("Parada La placita, feria municipal");
		paradaZonaCircuito_1.setPosicion(new PosicionDto());
		paradaZonaCircuito_1.getPosicion().setLatitud(-27.349722532412244);
		paradaZonaCircuito_1.getPosicion().setLongitud(-55.856859907370364);
		paradaZonaCircuito_1.setImage(null);

		map.put("Parada La Placita", paradaService.saveParada(paradaZonaCircuito_1));

		ParadaDto paradaZonaCircuito_2 = new ParadaDto();
		paradaZonaCircuito_2.setNombre("Parada Plaza de la amistad");
		paradaZonaCircuito_2.setDescripcion("Parada que queda en la esquina de la plaza de la amistad");
		paradaZonaCircuito_2.setPosicion(new PosicionDto());
		paradaZonaCircuito_2.getPosicion().setLatitud(-27.350697016910487);
		paradaZonaCircuito_2.getPosicion().setLongitud(-55.85243626062093);
		paradaZonaCircuito_2.setImage(null);

		map.put("Parada Plaza de la amistad", paradaService.saveParada(paradaZonaCircuito_2));

		ParadaDto paradaZonaCircuito_3 = new ParadaDto();
		paradaZonaCircuito_3.setNombre("Parada Circuito");
		paradaZonaCircuito_3.setDescripcion("Parada que queda a lado de la rotonda del circuito");
		paradaZonaCircuito_3.setPosicion(new PosicionDto());
		paradaZonaCircuito_3.getPosicion().setLatitud(-27.357819910452204);
		paradaZonaCircuito_3.getPosicion().setLongitud(-55.84988382623049);
		paradaZonaCircuito_3.setImage(null);

		map.put("Parada Circuito", paradaService.saveParada(paradaZonaCircuito_3));

		ParadaDto paradaGralArtigas_1 = new ParadaDto();
		paradaGralArtigas_1.setNombre("Parada La Junta");
		paradaGralArtigas_1.setDescripcion("Parada que queda frente la junta (cancha deportiva)");
		paradaGralArtigas_1.setPosicion(new PosicionDto());
		paradaGralArtigas_1.getPosicion().setLatitud(-27.338968447507323);
		paradaGralArtigas_1.getPosicion().setLongitud(-55.868826774661265);
		paradaGralArtigas_1.setImage(null);

		map.put("Parada La Junta", paradaService.saveParada(paradaGralArtigas_1));

		ParadaDto paradaGralArtigas_2 = new ParadaDto();
		paradaGralArtigas_2.setNombre("Parada Esquina Innovadent");
		paradaGralArtigas_2.setDescripcion("Parada queda enfrente de Innovadent");
		paradaGralArtigas_2.setPosicion(new PosicionDto());
		paradaGralArtigas_2.getPosicion().setLatitud(-27.33724323298178);
		paradaGralArtigas_2.getPosicion().setLongitud(-55.86898229653133);
		paradaGralArtigas_2.setImage(null);

		map.put("Parada Esquina Innovadent", paradaService.saveParada(paradaGralArtigas_2));

		ParadaDto paradaGralArtigas_3 = new ParadaDto();
		paradaGralArtigas_3.setNombre("Parada Subida Upap Encarnacion");
		paradaGralArtigas_3.setDescripcion("Parada queda subiendo la calle Mor. Wiessen");
		paradaGralArtigas_3.setPosicion(new PosicionDto());
		paradaGralArtigas_3.getPosicion().setLatitud(-27.33575386602624);
		paradaGralArtigas_3.getPosicion().setLongitud(-55.869160577699766);
		paradaGralArtigas_3.setImage(null);

		map.put("Parada Subida Upap Encarnacion", paradaService.saveParada(paradaGralArtigas_3));

		ParadaDto paradaGralArtigas_4 = new ParadaDto();
		paradaGralArtigas_4.setNombre("Parada Al Natural");
		paradaGralArtigas_4.setDescripcion("Parada entre 14 de mayo y Gral. Artigas");
		paradaGralArtigas_4.setPosicion(new PosicionDto());
		paradaGralArtigas_4.getPosicion().setLatitud(-27.333292170790983);
		paradaGralArtigas_4.getPosicion().setLongitud(-55.86942069214396);
		paradaGralArtigas_4.setImage(null);

		map.put("Parada Al Natural", paradaService.saveParada(paradaGralArtigas_4));

		ParadaDto paradaGralArtigas_5 = new ParadaDto();
		paradaGralArtigas_5.setNombre("Parada BENGELATO");
		paradaGralArtigas_5.setDescripcion("Parada entre Villarica y Gral. Artigas");
		paradaGralArtigas_5.setPosicion(new PosicionDto());
		paradaGralArtigas_5.getPosicion().setLatitud(-27.331097115425248);
		paradaGralArtigas_5.getPosicion().setLongitud(-55.86966204962195);
		paradaGralArtigas_5.setImage(null);

		map.put("Parada BENGELATO", paradaService.saveParada(paradaGralArtigas_5));

		ParadaDto paradaGralArtigas_6 = new ParadaDto();
		paradaGralArtigas_6.setNombre("Parada Optica Gamon");
		paradaGralArtigas_6.setDescripcion("Parada entre Constitucion Nacional y Gral. Artigas");
		paradaGralArtigas_6.setPosicion(new PosicionDto());
		paradaGralArtigas_6.getPosicion().setLatitud(-27.328156918730016);
		paradaGralArtigas_6.getPosicion().setLongitud(-55.869968126783625);
		paradaGralArtigas_6.setImage(null);

		map.put("Parada Optica Gamon", paradaService.saveParada(paradaGralArtigas_6));

		ParadaDto paradaAvCaballero_3 = new ParadaDto();
		paradaAvCaballero_3.setNombre("Parada Chiperia Aaron");
		paradaAvCaballero_3.setDescripcion("Parada Avenida Caballero, frente Chiperia Aaron");
		paradaAvCaballero_3.setPosicion(new PosicionDto());
		paradaAvCaballero_3.getPosicion().setLatitud(-27.326353393093402);
		paradaAvCaballero_3.getPosicion().setLongitud(-55.86570601749689);
		paradaAvCaballero_3.setImage(null);

		map.put("Parada Chiperia Aaron", paradaService.saveParada(paradaAvCaballero_3));

		ParadaDto paradaAvCaballero_4 = new ParadaDto();
		paradaAvCaballero_4.setNombre("Parada Carsuplay");
		paradaAvCaballero_4.setDescripcion("Parada Avenida Caballero, frente carsuplay");
		paradaAvCaballero_4.setPosicion(new PosicionDto());
		paradaAvCaballero_4.getPosicion().setLatitud(-27.326081838152955);
		paradaAvCaballero_4.getPosicion().setLongitud(-55.862803681953004);
		paradaAvCaballero_4.setImage(null);

		map.put("Parada Carsuplay", paradaService.saveParada(paradaAvCaballero_4));

		return map;
	}

	private Map<String, ColectivoDto> insertColectivo(Map<String, EmpresaDeColectivosDto> empresaMap,
			Map<String, LineaDeColectivosDto> lineaMap) {

		Map<String, ColectivoDto> map = new HashMap<>();

		ColectivoDto dto = new ColectivoDto();
		dto.setEmpresaId(empresaMap.get("urbano").getId());
		dto.setLineaId(lineaMap.get("Linea").getId());
		dto.setNumero("23");

		dto = colectivoService.saveColectivo(dto);
		map.put("Colectivo23", dto);

		ColectivoDto colectivo_2 = new ColectivoDto();
		colectivo_2.setEmpresaId(empresaMap.get("la encarnacena").getId());
		colectivo_2.setLineaId(lineaMap.get("Linea").getId());
		colectivo_2.setNumero("11");

		colectivo_2 = colectivoService.saveColectivo(colectivo_2);
		map.put("Colectivo11", colectivo_2);

		return map;
	}

	private Map<String, LineaDeColectivosDto> insertLinea() {
		Map<String, LineaDeColectivosDto> map = new HashMap<>();

		LineaDeColectivosDto lineaDto = new LineaDeColectivosDto();
		lineaDto.setNumero("16");
		lineaDto = lineaService.saveLineaColectivo(lineaDto);
		map.put("Linea", lineaDto);

		LineaDeColectivosDto lineaDto_2 = new LineaDeColectivosDto();
		lineaDto_2.setNumero("11");
		lineaDto_2 = lineaService.saveLineaColectivo(lineaDto_2);
		map.put("Linea11", lineaDto_2);

		return map;
	}

	private Map<String, EmpresaDeColectivosDto> insertEmpresaColectivo() {
		Map<String, EmpresaDeColectivosDto> map = new HashMap<>();

		EmpresaDeColectivosDto empresaUrbano = new EmpresaDeColectivosDto();
		empresaUrbano.setNombre("Empresa Urbano");
		empresaUrbano.setCorreo_electronico("empresa@gmail.com");
		empresaUrbano.setDireccion("Algun lugar");
		empresaUrbano.setNumero_telefono("0987654321");
		empresaUrbano = empresaService.saveEmpresaColectivo(empresaUrbano);
		map.put("urbano", empresaUrbano);

		EmpresaDeColectivosDto empresaLaEncarnacena = new EmpresaDeColectivosDto();
		empresaLaEncarnacena.setNombre("Empresa La Encarnacena");
		empresaLaEncarnacena.setCorreo_electronico("encarnacena@gmail.com");
		empresaLaEncarnacena.setDireccion("Algun lugar");
		empresaLaEncarnacena.setNumero_telefono("0987689713");
		empresaLaEncarnacena = empresaService.saveEmpresaColectivo(empresaLaEncarnacena);
		map.put("la encarnacena", empresaLaEncarnacena);

		return map;
	}

	private Map<String, ColorDto> insertColor() {

		Map<String, ColorDto> resultMap = new HashMap<>();

		String[] arreglo = { "red", "orange", "yellow", "green", "cyan", "blue", "purple", "gray" };

		for (String nombre : arreglo) {
			ColorDto newDto = new ColorDto();
			newDto.setNombre(nombre);
			newDto = colorService.saveColor(newDto);
			resultMap.put(newDto.getNombre(), newDto);
		}

		return resultMap;

	}

	private Map<String, ZonaDto> insertZona() {
		Map<String, ZonaDto> resultMap = new HashMap<>();

		ZonaDto zonaUni = new ZonaDto();
		zonaUni.setNombre("Zona UNI");
		zonaUni.setDescripcion("Ubicado en la zona de la UNI");
		zonaUni = zonaService.saveZona(zonaUni);

		resultMap.put("Zona UNI", zonaUni);

		return resultMap;

	}

	/********************** Variables Privadas **********************/
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

	@Autowired
	private IColorService colorService;

	@Autowired
	private IZonaService zonaService;
}
