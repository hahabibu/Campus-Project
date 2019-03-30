package com.zstu.pms.audit.service;

import java.util.List;

import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

public interface EndCheckService {
	
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord);

	public boolean passEndCheck(String declareId,String result);

	public boolean unPassEndCheck(String declareId,String result);

	public DeclareRecord getDeclareRecord(String declareId);
	
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord);
	
}
