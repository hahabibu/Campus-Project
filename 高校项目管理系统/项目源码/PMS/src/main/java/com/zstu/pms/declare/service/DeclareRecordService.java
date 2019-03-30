package com.zstu.pms.declare.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.ItemInfo;

public interface DeclareRecordService {

	// 添加项目信息（提交项目信息的同时添加申报记录）
	public boolean addItemInfo(ItemInfo itemInfo,DeclareRecord declareRecord);

	// 修改项目信息（已提交的项目信息不能够更新）
	public boolean updateItemInfo(ItemInfo itemInfo,DeclareRecord declareRecord);

	// 获取所有的列表信息
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord);

	// 根据申报记录id获取记录详情
	public DeclareRecord getDeclareRecord(String declareId);

	// 根据Model获取DTO（数据传输对象）
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord);

	// 上传文件
	public void uploadFile(HttpServletRequest request);
	
}
