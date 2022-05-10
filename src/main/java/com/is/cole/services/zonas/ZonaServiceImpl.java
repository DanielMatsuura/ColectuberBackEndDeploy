package com.is.cole.services.zonas;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.daos.IZonaDao;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.zonas.ZonaDto;
import com.is.cole.entities.Zona;

@Service
public class ZonaServiceImpl implements IZonaService {

	
	/********************** CRUDS **********************/
	
	/**
	 * Guardar una zona
	 */
	@Override
	public ZonaDto saveZona(ZonaDto dto) {
		Zona beanGuardado = zonaDao.save(parseDtoToBeanZona(dto));
		return parseBeanToDtoZona(beanGuardado);
	}
	
	/**
	 * Obtener una zona por su id
	 */
	@Override
	public ZonaDto getByIdZona(Integer id) {
		Zona beanObtenido = zonaDao.getById(id);
		return parseBeanToDtoZona(beanObtenido);
	}
	
	/**
	 * Obtener todas las zonas
	 */
	@Override
	public Result<ZonaDto> getAllZonas() {
		Result<ZonaDto> dtos = new Result<>();
		
		dtos.setResult(zonaDao.findAll().stream().map(
				zona -> parseBeanToDtoZona(zona)
				).collect(Collectors.toList()));
		return dtos;
	}
	
	/**
	 * Eliminar una zona por su id
	 */
	@Override
	public void deleteZona(Integer id) {
		zonaDao.deleteById(id);
	}
	
	/********************** PARSES **********************/
	
	/**
	 * Convertir una Zona dto a una Zona bean
	 * @param dto
	 * @return
	 */
	private Zona parseDtoToBeanZona(ZonaDto dto) {
		Zona bean = new Zona();
		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		bean.setDescripcion(dto.getDescripcion());
		return bean;
	}
	
	/**
	 * Convertir una zona bean a una zona dto
	 * @param bean
	 * @return
	 */
	private ZonaDto parseBeanToDtoZona(Zona bean) {
		ZonaDto dto = new ZonaDto();
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}
	
	/********************** Variables Privadas **********************/
	
	@Autowired
	private IZonaDao zonaDao;

}
