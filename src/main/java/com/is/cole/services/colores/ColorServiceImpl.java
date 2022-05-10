package com.is.cole.services.colores;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.daos.IColorDao;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.colores.ColorDto;
import com.is.cole.entities.Color;

@Service
public class ColorServiceImpl implements IColorService {

	@Override
	@Transactional
	public ColorDto saveColor(ColorDto dto) {
		Color bean = parseDtoToBean(dto);
		Color beanGuardado = colorDao.save(bean);
		return parseBeanToDto(beanGuardado);
	}

	@Override
	@Transactional
	public Result<ColorDto> getAllColors() {
		Result<ColorDto> result = new Result<>();
		List<ColorDto> list = colorDao.findAll().stream().map((bean) -> {
			return parseBeanToDto(bean);
		}).collect(Collectors.toList());

		result.setResult(list);
		return result;
	}

	@Override
	@Transactional
	public ColorDto getColorById(Integer id) {
		Color beanObtenido = colorDao.getById(id);
		return parseBeanToDto(beanObtenido);
	}

	@Override
	@Transactional
	public ColorDto getByNombre(String nombre) {
		Color beanObtenido = colorDao.findByNombre(nombre);
		return parseBeanToDto(beanObtenido);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		colorDao.deleteById(id);
	}

	// Parses

	/**
	 * Convierte de bean a dto la entidad color
	 * 
	 * @param bean
	 * @return
	 */
	private ColorDto parseBeanToDto(Color bean) {
		ColorDto dto = new ColorDto();

		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());

		return dto;
	}

	/**
	 * Convierte de Dto a Bean la entidad ColorDto
	 * 
	 * @param dto
	 * @return
	 */
	private Color parseDtoToBean(ColorDto dto) {
		Color bean = new Color();

		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());

		return bean;
	}

	@Autowired
	private IColorDao colorDao;
}
