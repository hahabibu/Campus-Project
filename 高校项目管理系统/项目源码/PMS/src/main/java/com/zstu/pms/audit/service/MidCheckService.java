package com.zstu.pms.audit.service;

import java.util.List;

import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;

public interface MidCheckService {
	
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord);

	public boolean PassMidCheck(String declareId,String result);

	public boolean unPassMidCheck(String declareId,String result);

	public DeclareRecord getDeclareRecord(String declareId);
	
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord);
	
}
