package com.is.cole.services.viajes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IColectivoDao;
import com.is.cole.daos.IRecorridoDao;
import com.is.cole.daos.IUserDao;
import com.is.cole.daos.IViajeDao;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.Viajes.ViajeDto;
import com.is.cole.entities.Viaje;

@Service
public class ViajesServiceImpl implements IViajesService {

	@Autowired
	private IViajeDao viajeDao;
	@Autowired
	private IUserDao usuarioDao;
	@Autowired
	private IColectivoDao colectivoDao;
	@Autowired
	private IRecorridoDao recorridoDao;
	
	/********************** Normal CRUDs **********************/

	@Override
	@Transactional
	public ViajeDto saveViaje(ViajeDto dto) {
		Viaje beanGuardado= viajeDao.save(parseDtoToBeanViaje(dto));
		return parseBeanToDtoViaje(beanGuardado);
	}

	@Override
	@Transactional
	public void deleteViaje(Integer id) {
		viajeDao.deleteById(id);
	}

	@Override
	@Transactional
	public ViajeDto getViaje(Integer id) {
		Viaje beanObtenido= viajeDao.getById(id);
		return parseBeanToDtoViaje(beanObtenido);
	}

	@Override
	@Transactional
	public Result<ViajeDto> getAllViaje() {
		Result<ViajeDto> resultViaje= new Result<>();
		
		List<ViajeDto> dtosObtenido = (viajeDao.findAll()
				.stream().map( bean-> parseBeanToDtoViaje(bean)).collect(Collectors.toList()));
		resultViaje.setResult(dtosObtenido);
		
		return resultViaje;
	}

	/********************** Special functions **********************/

	@Override
	@Transactional
	public ViajeDto getByChoferIdViaje(Integer id) {
		Viaje beanObtenido = viajeDao.findByUsuarioId(id);
		return parseBeanToDtoViaje(beanObtenido);
	}
	/********************** Parses **********************/

	//No esta seteado el state todavia
	
	private ViajeDto parseBeanToDtoViaje(Viaje bean) {
		ViajeDto dto = new ViajeDto();
		dto.setId(bean.getId());
		dto.setChofer_id(bean.getUsuario().getId());
		dto.setColectivo_id(bean.getColectivo().getId());
		dto.setDestino(bean.getDestino());
		dto.setRecorrido_id(bean.getRecorrido().getId());
		return dto;
	}
	
	private Viaje parseDtoToBeanViaje(ViajeDto dto) {
		Viaje bean = new Viaje();
		bean.setColectivo(colectivoDao.getById(dto.getColectivo_id()));
		bean.setDestino(dto.getDestino());
		bean.setId(dto.getId());
		bean.setRecorrido(recorridoDao.getById(dto.getRecorrido_id()));
		bean.setUsuario(usuarioDao.getById(dto.getChofer_id()));
		return bean;	
	}

}
