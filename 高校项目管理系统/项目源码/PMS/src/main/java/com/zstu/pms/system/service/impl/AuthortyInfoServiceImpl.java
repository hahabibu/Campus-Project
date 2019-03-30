package com.zstu.pms.system.service.impl;


import java.util.List;

import javax.annotation.Resource;

import com.zstu.pms.mapper.AuthortyInfoMapper;
import com.zstu.pms.model.AuthortyInfo;
import com.zstu.pms.model.AuthortyInfoExample;
import com.zstu.pms.system.service.AuthortyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authortyInfoServiceImpl")
@Transactional
public class AuthortyInfoServiceImpl implements AuthortyInfoService {

	@Resource(name="authortyInfoMapper")
	private AuthortyInfoMapper authortyInfoMapper;
	
	@Override
	public boolean addAuthortyInfo(AuthortyInfo anthortyInfo) {
		int i=authortyInfoMapper.insertSelective(anthortyInfo);
		return i>0;
	}

	@Override
	public boolean updateAuthortyInfo(AuthortyInfo anthortyInfo) {
		int i=authortyInfoMapper.updateByPrimaryKey(anthortyInfo);
		return i>0;
	}

	@Override
	public boolean deleteAuthortyInfo(String authortyId) {
		int i=authortyInfoMapper.deleteByPrimaryKey(authortyId);
		return i>0;
	}

	@Override
	public List<AuthortyInfo> getAuthotryInfoList(AuthortyInfo anthortyInfo) {
		AuthortyInfoExample authortyInfoExample=new AuthortyInfoExample();
		
		AuthortyInfoExample.Criteria criteria=authortyInfoExample.createCriteria();
		if(anthortyInfo!=null) {
			if(anthortyInfo.getAuthortyId()!=null) {
				criteria.andAuthortyIdEqualTo(anthortyInfo.getAuthortyId());
			}if(anthortyInfo.getAuthortyName()!=null) {
				criteria.andAuthortyNameLike("%"+anthortyInfo.getAuthortyName()+"%");   
			}
			// 根据权限等级进行查找(-1是无效的内容，其作为根目录的父级编号)
//			if(anthortyInfo.getAuthortyClass()!=null) {
//				if(anthortyInfo.getAuthortyClass()!=-1) {
//					criteria.andAuthortyClassEqualTo(anthortyInfo.getAuthortyClass());
//				}
//			}
		}
		
		criteria.andAuthortyIdIsNotNull();
		return authortyInfoMapper.selectByExample(authortyInfoExample);
	}

	@Override
	public AuthortyInfo getAuthortyInfo(String authortyId) {
		
		return authortyInfoMapper.selectByPrimaryKey(authortyId);
	}

	//根据权限id  得到对应的角色id --
//	@Override
//	public StaffInfo getStaffInfoByAuthorty(int authortyId) {
//
//		return null;
//	}

}


