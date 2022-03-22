package com.is.cole.services.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.cole.daos.IColectivoDao;
import com.is.cole.daos.IEmpresaDeColectivosDao;
import com.is.cole.daos.ILineaDao;
import com.is.cole.entities.Colectivo;
import com.is.cole.entities.EmpresaDeColectivos;
import com.is.cole.entities.Linea;

@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	private IEmpresaDeColectivosDao empresaColectivoDao;
	
	@Autowired
	private ILineaDao lineaDao;
	
	@Autowired
	private IColectivoDao colectivoDao;
	
	
	@Override
	public void insertEmpresas() {
		EmpresaDeColectivos empresaColectivo = new EmpresaDeColectivos();
		empresaColectivo.setId(1);
		empresaColectivo.setNombre("La yuteña");
		empresaColectivo.setDireccion("Tajy/Mburucuya");
		empresaColectivo.setCorreo("yuteña.encarnacion@gmail.com");
		empresaColectivo.setNum_telefono("0985635898");
		empresaColectivoDao.save(empresaColectivo);
		
	}
	
	
	@Override
	public void insertLineas() {

		Linea linea = new Linea();
		linea.setId(2);
		linea.setNumero("12");
		lineaDao.save(linea);
	}

	@Override
	public void insertColectivos() {
		Colectivo colectivo = new Colectivo();
		colectivo.setId(3);
		colectivo.setEmpresaColectivo(empresaColectivoDao.getById(1));
		colectivo.setLineaColectivo(lineaDao.getById(2));
		colectivo.setNumeroColectivo("12");
		colectivoDao.save(colectivo);
		
	}


	@Override
	public void insertValues() {
		insertEmpresas();
		insertLineas();
		insertColectivos();
	}
	
	

}
