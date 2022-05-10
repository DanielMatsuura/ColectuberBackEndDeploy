package com.is.cole.services.paradas;

import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IParadaDao;
import com.is.cole.daos.IZonaDao;
import com.is.cole.dtos.PosicionDto;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.paradas.ParadaDto;
import com.is.cole.entities.Parada;
import java.util.List;

@Service
public class ParadaServiceImpl implements IParadaService {

	@Override
	@Transactional
	public ParadaDto saveParada(ParadaDto dto) {
		Parada bean = parseDtotoBean(dto);
		Parada beanGuardado = paradaDao.save(bean);
		return parseBeanToDto(beanGuardado);
	}

	@Override
	@Transactional
	public Result<ParadaDto> getAllParadas() {
		Result<ParadaDto> result = new Result<>();
		List<ParadaDto> list = paradaDao.findAll().stream().map((bean) -> {
			return parseBeanToDto(bean);
		}).collect(Collectors.toList());
		result.setResult(list);
		return result;
	}

	@Override
	@Transactional
	public ParadaDto getParadaById(Integer id) {
		Parada beanObtenido = paradaDao.getById(id);
		return parseBeanToDto(beanObtenido);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		paradaDao.deleteById(id);
	}

	/**
	 * Convierte un Bean a Dto de la entidad Parada
	 * 
	 * @param bean
	 * @return
	 */
	private ParadaDto parseBeanToDto(Parada bean) {
		ParadaDto dto = new ParadaDto();

		PosicionDto posDto = new PosicionDto();
		posDto.setLatitud(bean.getLatitud());
		posDto.setLongitud(bean.getLongitud());

		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		dto.setDescripcion(bean.getDescripcion());
		dto.setImage(bean.getImagen());
		dto.setPosicion(posDto);
		
		if(bean.getZona() != null) {
			dto.setZona(bean.getZona().getNombre());
		}else {
			dto.setZona("");
		}
	
		return dto;
	}

	/**
	 * Converte un Dto a Bean de la entidad Parada
	 * 
	 * @param dto
	 * @return
	 */
	private Parada parseDtotoBean(ParadaDto dto) {
		Parada bean = new Parada();

		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		bean.setDescripcion(dto.getDescripcion());
		bean.setImagen(dto.getImage());
		bean.setLongitud(dto.getPosicion().getLongitud());
		bean.setLatitud(dto.getPosicion().getLatitud());
		bean.setZona(zonaDao.findByNombre(dto.getZona()));

		return bean;
	}

	@Autowired
	private IParadaDao paradaDao;
	@Autowired
	private IZonaDao zonaDao;
}
