package com.is.cole.services.empresaColectivos;

import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IEmpresaDeColectivosDao;
import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectivos.EmpresaDeColectivosDto;
import com.is.cole.entities.EmpresaDeColectivos;

@Service
public class EmpresaColectivosImpl implements IEmpresaColectivosService{

	
	@Autowired
	private IEmpresaDeColectivosDao empresaDao;
	
	
	//Metodos
	
	@Override
	@Transactional
	public EmpresaDeColectivosDto saveEmpresaColectivo(EmpresaDeColectivosDto dto) {
		EmpresaDeColectivos bean = parseDtoToBeanEmpresaColectivo(dto);
		return parseBeanToDtoEmpresaColectivo(empresaDao.save(bean));
	}

	@Override
	@Transactional
	public EmpresaDeColectivosDto getEmpresaColectivo(Integer empresaId) {
		EmpresaDeColectivos beanObtenido= empresaDao.getById(empresaId);
		return parseBeanToDtoEmpresaColectivo(beanObtenido);
	}

	@Override
	@Transactional
	public void deleteEmpresaColectivo(Integer empresaId) {
		empresaDao.deleteById(empresaId);
		
	}

	@Override
	@Transactional
	public Result<EmpresaDeColectivosDto> getAllEmpresaColectivo() {
		Result<EmpresaDeColectivosDto> dtos = new Result<>();
		
		dtos.setResult(
			empresaDao.findAll().stream()
			.map(ec -> parseBeanToDtoEmpresaColectivo(ec))
			.collect(Collectors.toList())
		);
		return dtos;
	}
	
	//Parses
	
	private EmpresaDeColectivosDto parseBeanToDtoEmpresaColectivo(EmpresaDeColectivos bean) {
		EmpresaDeColectivosDto dto = new EmpresaDeColectivosDto();
		dto.setCorreo_electronico(bean.getCorreo());
		dto.setDireccion(bean.getDireccion());
		dto.setNombre(bean.getNombre());
		dto.setNumero_telefono(bean.getNum_telefono());
		dto.setId(bean.getId());
		
		return dto;
	}
	
	private EmpresaDeColectivos parseDtoToBeanEmpresaColectivo(EmpresaDeColectivosDto dto) {
		EmpresaDeColectivos bean = new EmpresaDeColectivos();
		bean.setId(dto.getId());
		bean.setCorreo(dto.getCorreo_electronico());
		bean.setDireccion(dto.getDireccion());
		bean.setNombre(dto.getNombre());
		bean.setNum_telefono(dto.getNumero_telefono());
		
		return bean;
	}
}
