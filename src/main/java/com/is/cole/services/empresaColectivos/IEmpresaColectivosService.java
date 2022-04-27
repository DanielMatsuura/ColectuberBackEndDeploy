package com.is.cole.services.empresaColectivos;

import com.is.cole.dtos.Result;
import com.is.cole.dtos.colectivos.EmpresaDeColectivosDto;

public interface IEmpresaColectivosService {
		public EmpresaDeColectivosDto saveEmpresaColectivo(EmpresaDeColectivosDto dto);
		public EmpresaDeColectivosDto getEmpresaColectivo(Integer empresaId);
		public void deleteEmpresaColectivo(Integer empresaId);
		public Result<EmpresaDeColectivosDto> getAllEmpresaColectivo();
}
