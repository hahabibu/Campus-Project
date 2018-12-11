package com.zstu.pms.system.service;

import com.zstu.pms.model.DataDictionary;

import java.util.List;


public interface DataDictionaryService {

	public boolean saveDataDictionary(DataDictionary dataDictionary);
	
	public boolean updateDataDictionary(DataDictionary dataDictionary);
	
	public boolean deleteDataDictionary(String dataId);
	
	public List<DataDictionary> listDataDictionary(DataDictionary dataDictionary);
	
	public DataDictionary getDataDictionary(String dataId);

	public List<DataDictionary> getDataDictionaryByType(String dataType);
}
