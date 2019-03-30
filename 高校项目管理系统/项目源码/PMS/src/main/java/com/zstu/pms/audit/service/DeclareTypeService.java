package com.zstu.pms.audit.service;

import java.util.List;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.model.DeclareType;

public interface DeclareTypeService {

	public boolean saveDeclareType(DeclareType declareType);

	public boolean updateDeclareType(DeclareType declareType);

	public boolean deleteDeclareType(String typeId);

	public DeclareTypeDTO getDeclareType(String typeId);

	public List<DeclareTypeDTO> listDeclareType(DeclareTypeDTO declareTypeDTO);

	public DeclareTypeDTO getDTOByModel(DeclareType declareType);

}
