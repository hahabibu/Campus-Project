package com.zstu.pms.audit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zstu.pms.audit.dto.DeclareTypeDTO;
import com.zstu.pms.audit.service.DeclareTypeService;
import com.zstu.pms.mapper.DeclareTypeMapper;
import com.zstu.pms.model.DeclareType;
import com.zstu.pms.model.DeclareTypeExample;
import com.zstu.pms.model.DeclareTypeExample.Criteria;
import com.zstu.pms.utils.ConstantUtils;

@Service("declareTypeServiceImpl")
@Transactional
public class DeclareTypeServiceImpl implements DeclareTypeService{
	
	@Resource(name="declareTypeMapper")
	private DeclareTypeMapper declareTypeMapper;

	@Override
	public boolean saveDeclareType(DeclareType declareType) {
		int i = declareTypeMapper.insert(declareType);
		return i>0;
	}

	@Override
	public boolean updateDeclareType(DeclareType declareType) {
		int i = declareTypeMapper.updateByPrimaryKey(declareType);
		return i>0;
	}

	@Override
	public boolean deleteDeclareType(String typeId) {
		int i = declareTypeMapper.deleteByPrimaryKey(typeId);
		return i>0;
	}

	@Override
	public DeclareTypeDTO getDeclareType(String typeId) {
		return getDTOByModel(declareTypeMapper.selectByPrimaryKey(typeId));
	}

	@Override
	public List<DeclareTypeDTO> listDeclareType(DeclareTypeDTO declareTypeDTO) {
		DeclareTypeExample declareTypeExample = new DeclareTypeExample();
		Criteria criteria = declareTypeExample.createCriteria();
		if(declareTypeDTO!=null) {
			if(!StringUtils.isEmpty(declareTypeDTO.getStartStatus())) {
				if(!ConstantUtils.DEFAULT_CHECK_CONDITION.equals(declareTypeDTO.getStartStatus())) {
					criteria.andStartStatusEqualTo(declareTypeDTO.getStartStatus());
				}
			}
			if(!StringUtils.isEmpty(declareTypeDTO.getTypeName())) {
				criteria.andTypeNameLike("%"+declareTypeDTO.getTypeName()+"%");
			}
			if(declareTypeDTO.getMiddleTime()!=null) {
				criteria.andMiddleTimeGreaterThanOrEqualTo(declareTypeDTO.getMiddleTime());
			}
			if(declareTypeDTO.getMiddleTimeLimit()!=null) {
				criteria.andMiddleTimeLessThanOrEqualTo(declareTypeDTO.getMiddleTimeLimit());
			}
			if(declareTypeDTO.getEndTime()!=null) {
				criteria.andEndTimeGreaterThanOrEqualTo(declareTypeDTO.getEndTime());
			}
			if(declareTypeDTO.getEndTimeLimit()!=null) {
				criteria.andEndTimeLessThanOrEqualTo(declareTypeDTO.getEndTimeLimit());
			}
		}
		criteria.andDelTagEqualTo(ConstantUtils.DEL_TAG_SAVE);
		List<DeclareType> declareTypeList = declareTypeMapper.selectByExample(declareTypeExample);
		List<DeclareTypeDTO> declareTypeDTOList = new ArrayList<>(declareTypeList.size());
		for(DeclareType dt : declareTypeList) {
			declareTypeDTOList.add(getDTOByModel(dt));
		}
		return declareTypeDTOList;
	}

	@Override
    public DeclareTypeDTO getDTOByModel(DeclareType declareType){
        DeclareTypeDTO declareTypeDTO = new DeclareTypeDTO();
        BeanUtils.copyProperties(declareType,declareTypeDTO);
        // 根据相应的内容封装属性
        String startStatus = declareType.getStartStatus();
        if(!StringUtils.isEmpty(startStatus)) {
        	if(startStatus.equals(ConstantUtils.START_STATUS_OPEN)){
        		declareTypeDTO.setStartStatusContext(ConstantUtils.START_STATUS_OPEN_CONTEXT);
        	}else if(startStatus.equals(ConstantUtils.START_STATUS_CLOSE)){
        		declareTypeDTO.setStartStatusContext(ConstantUtils.START_STATUS_CLOSE_CONTEXT);
        	}else if(startStatus.equals(ConstantUtils.START_STATUS_OVERDUE)){
        		declareTypeDTO.setStartStatusContext(ConstantUtils.START_STATUS_OVERDUE_CONTEXT);
        	}
        }
        return declareTypeDTO;
    }
}
