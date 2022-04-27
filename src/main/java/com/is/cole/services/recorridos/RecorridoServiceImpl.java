package com.is.cole.services.recorridos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.is.cole.daos.IParadaDao;
import com.is.cole.daos.IPuntoDeRecorridoDao;
import com.is.cole.daos.IRecorridoDao;
import com.is.cole.dtos.PosicionDto;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.recorridos.PuntoDeRecorridoDto;
import com.is.cole.dtos.recorridos.RecorridoDto;
import com.is.cole.entities.PuntoDeRecorrido;
import com.is.cole.entities.Recorrido;

@Service
public class RecorridoServiceImpl implements IRecorridoService {

	@Autowired
	private IParadaDao paradaDao;
	@Autowired
	private IPuntoDeRecorridoDao puntoRecorridoDao;
	@Autowired
	private IRecorridoDao recorridoDao;

	@Override
	@Transactional
	public void saveRecorrido(RecorridoDto dto) {
	
		if (dto.getId() != null) {
			Recorrido recorridoBeanAntiguo = recorridoDao.getById(dto.getId());
			deletePuntosDeRecorrido(recorridoBeanAntiguo.getPunto_inicial());
		}
		Recorrido recorridoBean = parseDtoToBeanRecorrido(dto);
		List<PuntoDeRecorrido> beansSaved = saveListPuntoDeRecorridoDto(dto.getPuntos());
		

		if (!beansSaved.isEmpty()) {
			recorridoBean.setPunto_inicial(beansSaved.get(0));
		} else {
			recorridoBean.setPunto_inicial(null);
		}

		recorridoDao.save(recorridoBean);

	}

	@Override
	@Transactional
	public RecorridoDto getRecorrido(Integer id) {
		Recorrido recorridoBeanObtenido = recorridoDao.getById(id);
		List<PuntoDeRecorrido> puntosRecorridoRecuperado = recuperarPuntosDeRecorrido(
				recorridoBeanObtenido.getPunto_inicial());

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

		recorridoDao.findAll().stream().map(recorridoBean -> dtosObtenidos.add(getRecorrido(recorridoBean.getId())))
				.collect(Collectors.toList());

		dtos.setResult(dtosObtenidos);

		return dtos;
	}

	// Metodos Auxiliares

	// Guardar lista de puntos de recorridos
	private List<PuntoDeRecorrido> saveListPuntoDeRecorridoDto(List<PuntoDeRecorridoDto> dtos) {
		List<PuntoDeRecorrido> beans = new ArrayList<>();

		PuntoDeRecorrido beanPrevious = null;

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

	// Recuperar puntos de recorrido
	private List<PuntoDeRecorrido> recuperarPuntosDeRecorrido(PuntoDeRecorrido cabeza) {

		List<PuntoDeRecorrido> beansObtenido = new ArrayList<PuntoDeRecorrido>();
		PuntoDeRecorrido current = cabeza;

		while (current != null) {
			beansObtenido.add(current);
			current = current.getSig_punto();
		}
		return beansObtenido;
	}
	// Borrar puntos de recorridos

	private void deletePuntosDeRecorrido(PuntoDeRecorrido cabeza) {
		List<PuntoDeRecorrido> beansPuntos = recuperarPuntosDeRecorrido(cabeza);
		puntoRecorridoDao.deleteAll(beansPuntos);
	}

	// Parses Lista de puntos de Recorrido de beans a dtos

	private List<PuntoDeRecorridoDto> parseBeansToDtosPuntosDeRecorrido(List<PuntoDeRecorrido> beans) {

		List<PuntoDeRecorridoDto> dtos = new ArrayList<PuntoDeRecorridoDto>();
		beans.stream().map(bean -> dtos.add(parseBeanToDtoPuntoRecorrido(bean))).collect(Collectors.toList());

		return dtos;
	}

	// Parses Puntos de recorrido de dto to bean

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

	// Parses Recorrido

	private Recorrido parseDtoToBeanRecorrido(RecorridoDto dto) {
		Recorrido bean = new Recorrido();
		bean.setDescripcion(dto.getDescripcion());
		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		return bean;
	}

	private RecorridoDto parseBeanToDtoRecorrido(Recorrido bean) {
		RecorridoDto dto = new RecorridoDto();
		dto.setDescripcion(bean.getDescripcion());
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		return dto;
	}

}
