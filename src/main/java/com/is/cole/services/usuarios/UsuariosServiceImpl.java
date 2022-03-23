package com.is.cole.services.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.daos.IUserDao;
import com.is.cole.dtos.Usuarios.UsuarioDto;
import com.is.cole.entities.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	private IUserDao usuarioDao;
	
	@Override
	public UsuarioDto saveUsuario(UsuarioDto dto) {
		Usuarios bean = parseDtoToBeanUsuario(dto);
		Usuarios beanGuardado= usuarioDao.save(bean);
		return parseBeanToDtoUsuario(beanGuardado);
	}

	@Override
	public void deleteUsuario(Integer id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public UsuarioDto getUsuario(Integer id) {
		Usuarios beanObtenido = usuarioDao.getById(id);
		return parseBeanToDtoUsuario(beanObtenido);
	}
	
	
	private Usuarios parseDtoToBeanUsuario(UsuarioDto dto) {
		Usuarios bean = new Usuarios();
		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		bean.setApellido(dto.getApellido());
		bean.setCorreo(dto.getCorreo_electronico());
		bean.setPassword(dto.getPassword());
		return bean;
	}
	
	private UsuarioDto parseBeanToDtoUsuario(Usuarios bean) {
		UsuarioDto dto = new UsuarioDto();
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		dto.setApellido(bean.getApellido());
		dto.setCorreo_electronico(bean.getCorreo());
		dto.setPassword(bean.getPassword());
		return dto;
	}
	
	
	
}
