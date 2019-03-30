package com.zstu.pms.audit.service;

import java.util.List;

import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

public interface ApprovalService {
	
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord);

	public boolean setUpProject(String declareId,String result);

	public boolean unSetUpProject(String declareId,String result);

	public DeclareRecord getDeclareRecord(String declareId);
	
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord);
	
}
