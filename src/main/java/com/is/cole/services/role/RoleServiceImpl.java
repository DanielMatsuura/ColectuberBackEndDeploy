package com.is.cole.services.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.is.cole.daos.IRoleDao;
import com.is.cole.daos.IRolesUsuarioDao;
import com.is.cole.daos.IUserDao;
import com.is.cole.dtos.role.RoleDto;
import com.is.cole.dtos.role.RoleUsuarioDto;
import com.is.cole.entities.RoleUsuario;
import com.is.cole.entities.Roles;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IRolesUsuarioDao roleUserDao;
	@Autowired
	private IUserDao userDao;
	
	@Override
	public RoleDto saveRole(RoleDto dto) {
		Roles role = parseDtoToBean(dto);
		Roles guardarRole = roleDao.save(role);
		return parseBeanToDto(guardarRole);
	}

	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteById(id);
	}
	
	@Override
	public RoleUsuarioDto agregarRoleAUsuario(RoleUsuarioDto dto) {
		RoleUsuario roleUsersNuevo = roleUserDao.save(parseDtoToBeanRoleUsuario(dto));
		return parseBeanToDtoRoleUsuario(roleUsersNuevo);
	}

	@Override
	public void quitarRoleAUsuario(Integer roleUserId) {
		roleUserDao.deleteById(roleUserId);
	}
	
	
	protected RoleDto parseBeanToDto(Roles bean) {
		RoleDto dto = new RoleDto();
		
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		dto.setDescripcion(bean.getDescription());
	
		return dto;
	}
	
	
	protected Roles parseDtoToBean(RoleDto dto) {
		Roles bean = new Roles();
		
		bean.setId(dto.getId());
		bean.setNombre(dto.getNombre());
		bean.setDescription(dto.getDescripcion());
		
		return bean;
	}
	
	protected RoleUsuarioDto parseBeanToDtoRoleUsuario(RoleUsuario bean) {
		RoleUsuarioDto dto = new RoleUsuarioDto();
		dto.setId(bean.getId());
		dto.setRoleId(bean.getRoles().getId());
		dto.setUsuarioId(bean.getUsuarios().getId());
		return dto;
	}
	
	protected RoleUsuario parseDtoToBeanRoleUsuario(RoleUsuarioDto dto ) {
		RoleUsuario bean = new RoleUsuario();
		bean.setId(dto.getId());
		bean.setRoles(roleDao.getById(dto.getRoleId()));
		bean.setUsuarios(userDao.getById(dto.getUsuarioId()));
		return bean;
	}
}
	

	

