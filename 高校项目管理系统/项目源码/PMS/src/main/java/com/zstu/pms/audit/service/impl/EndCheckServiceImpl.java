package com.zstu.pms.audit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zstu.pms.audit.service.EndCheckService;
import com.zstu.pms.declare.dto.DeclareRecordDTO;
import com.zstu.pms.mapper.DeclareRecordMapper;
import com.zstu.pms.mapper.DeclareTypeMapper;
import com.zstu.pms.mapper.ItemInfoMapper;
import com.zstu.pms.mapper.UserInfoMapper;
import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.DeclareRecordExample;
import com.zstu.pms.model.DeclareRecordExample.Criteria;
import com.zstu.pms.utils.ConstantUtils;
import com.zstu.pms.model.DeclareType;
import com.zstu.pms.model.ItemInfo;
import com.zstu.pms.model.UserInfo;

@Service("endCheckServiceImpl")
@Transactional
public class EndCheckServiceImpl implements EndCheckService{

	@Resource(name="declareRecordMapper")
	private DeclareRecordMapper declareRecordMapper;
	
	@Resource(name="itemInfoMapper")
	private ItemInfoMapper itemInfoMapper;
	
	@Resource(name="declareTypeMapper")
	private DeclareTypeMapper declareTypeMapper;
	
	@Resource(name="userInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<DeclareRecordDTO> listDeclareRecord(DeclareRecord declareRecord) {
		DeclareRecordExample declareRecordExample = new DeclareRecordExample();
		Criteria criteria = declareRecordExample.createCriteria();
		if(declareRecord!=null) {
			if(!StringUtils.isEmpty(declareRecord.getTypeId())) {
				if(!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(declareRecord.getTypeId())) {
					criteria.andTypeIdEqualTo(declareRecord.getTypeId());
				}
			}
			if(!StringUtils.isEmpty(declareRecord.getProcessStatus())) {
				if(!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(declareRecord.getProcessStatus())) {
					criteria.andProcessStatusEqualTo(declareRecord.getProcessStatus());
				}
			}
		}else {
			// 初始化只显示已经通过中期检查的记录
			// criteria.andProcessStatusEqualTo(ConstantUtils.PROCESS_STATUS_MIDCHECK_PASS);
		}
		List<DeclareRecord> declareRecordList = declareRecordMapper.selectByExample(declareRecordExample);
		List<DeclareRecordDTO> declareRecordDTOList = null;
		if(declareRecordList!=null) {
			declareRecordDTOList = new ArrayList<>(declareRecordList.size());
			for(DeclareRecord dr : declareRecordList) {
				declareRecordDTOList.add(getDTObyModel(dr));
			}
		}
		return declareRecordDTOList;
	}

	@Override
	public DeclareRecord getDeclareRecord(String declareId) {
		return declareRecordMapper.selectByPrimaryKey(declareId);
	}

	@Override
	public DeclareRecordDTO getDTObyModel(DeclareRecord declareRecord) {
		DeclareRecordDTO declareRecordDTO = new DeclareRecordDTO();
		BeanUtils.copyProperties(declareRecord, declareRecordDTO);
		if(declareRecord!=null) {
			if(!StringUtils.isEmpty(declareRecord.getItemId())) {
				// 查找相关的项目详情
				ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(declareRecord.getItemId());
				declareRecordDTO.setItemInfo(itemInfo);
			}
			if(!StringUtils.isEmpty(declareRecord.getTypeId())) {
				// 查找相关的项目类型详情
				DeclareType declareType = declareTypeMapper.selectByPrimaryKey(declareRecord.getTypeId());
				declareRecordDTO.setDeclareType(declareType);
				
			}
			if(!StringUtils.isEmpty(declareRecord.getUserId())) {
				// 查找相关的用户详情（申报人id）
				UserInfo userInfo = userInfoMapper.selectByPrimaryKey(declareRecord.getUserId());
				declareRecordDTO.setUserInfo(userInfo);
			}
			String processStatus = declareRecord.getProcessStatus();
			String processStatusContext = null;
			if(!StringUtils.isEmpty(processStatus)) {
				if(ConstantUtils.PROCESS_STATUS_DECLARE.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_DECLARE_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_SET.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_SET_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_UNSET.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_UNSET_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_MIDCHECK_PASS.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_MIDCHECK_PASS_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_MIDCHECK_UNPASS.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_MIDCHECK_UNPASS_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_ENDCHECK_PASS.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_ENDCHECK_PASS_CONTEXT;
				}else if(ConstantUtils.PROCESS_STATUS_ENDCHECK_UNPASS.equals(processStatus)){
					processStatusContext = ConstantUtils.PROCESS_STATUS_ENDCHECK_UNPASS_CONTEXT;
				}				
				declareRecordDTO.setProcessStatusContext(processStatusContext);
			}
		}
		return declareRecordDTO;
	}

	@Override
	public boolean passEndCheck(String declareId, String result) {
		DeclareRecord findDeclareRecord = this.getDeclareRecord(declareId);
    	// 设置处理状态
    	findDeclareRecord.setProcessStatus(ConstantUtils.PROCESS_STATUS_ENDCHECK_PASS);
    	findDeclareRecord.setResult(result);
		int i = declareRecordMapper.updateByPrimaryKey(findDeclareRecord);
		return i>0;
	}

	@Override
	public boolean unPassEndCheck(String declareId, String result) {
		DeclareRecord findDeclareRecord = this.getDeclareRecord(declareId);
    	// 设置处理状态
    	findDeclareRecord.setProcessStatus(ConstantUtils.PROCESS_STATUS_ENDCHECK_UNPASS);
    	findDeclareRecord.setResult(result);
    	int i = declareRecordMapper.updateByPrimaryKey(findDeclareRecord);
		return i>0;
	}
}
