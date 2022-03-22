package com.is.cole.services.colectuber;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.daos.IColectivoDao;
import com.is.cole.daos.IColectivoUbicacionDao;
import com.is.cole.dtos.colectuber.ColectivoUbicacionDto;
import com.is.cole.dtos.colectuber.ColectivoUbicacionResult;
import com.is.cole.dtos.colectuber.PosicionDto;
import com.is.cole.entities.ColectivoUbicacion;

@Service
public class ColectuberServiceImpl implements IColectuberService{
	
	@Autowired
	private IColectivoUbicacionDao colectivoUbicacionDao;
	
	@Autowired
	private IColectivoDao colectivoDao;
	
	@Override
	public void postColectivoUbicacion(ColectivoUbicacionDto dto) {
		ColectivoUbicacion ubi = parseDtoToBeanColectivoUbicacion(dto);
		colectivoUbicacionDao.save(ubi);
	}
	
	@Override
	public ColectivoUbicacionResult getColectivosUbicacion() {
		ColectivoUbicacionResult dtos = new ColectivoUbicacionResult();

		List<ColectivoUbicacionDto> listaDtos= colectivoUbicacionDao.findAll().stream()
		.map(colectivoUbicacion->parseBeanToDtoColectivoUbicacion(colectivoUbicacion))
		.toList();
		
		dtos.setListaColectivoUbicaciones(listaDtos);
		
		return dtos;
	}
	
	
	
	/*Parses*/
	
	private ColectivoUbicacion parseDtoToBeanColectivoUbicacion(ColectivoUbicacionDto dto) {
		ColectivoUbicacion ubi= new ColectivoUbicacion();
		ubi.setId(dto.getColectivoId());
		ubi.setColectivo(colectivoDao.getById(dto.getColectivoId()));
		ubi.setLat(dto.getPosicionColectivo().getLatitud());
		ubi.setLng(dto.getPosicionColectivo().getLongitud());
		ubi.setTime(System.currentTimeMillis());

		return ubi;
		
	}
	
	private ColectivoUbicacionDto parseBeanToDtoColectivoUbicacion(ColectivoUbicacion bean) {
		
		ColectivoUbicacionDto dto = new ColectivoUbicacionDto();
		
		PosicionDto posDto= new PosicionDto();
		posDto.setLatitud(bean.getLat());
		posDto.setLongitud(bean.getLng());
		
		dto.setColectivoId(bean.getColectivo().getId());
		dto.setPosicionColectivo(posDto);
	
		return dto;
		
	}

	

}
