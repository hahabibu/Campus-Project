package com.zstu.pms.system.service;

import java.util.List;

import com.zstu.pms.model.AuthortyInfo;

public interface AuthortyInfoService {

	public boolean addAuthortyInfo(AuthortyInfo authortyInfo);
	
	public boolean updateAuthortyInfo(AuthortyInfo authortyInfo);
	
	public boolean deleteAuthortyInfo(String authortyId);
	
	public List<AuthortyInfo> getAuthotryInfoList(AuthortyInfo authortyInfo);
	
	public AuthortyInfo getAuthortyInfo(String authortyId);
	
//	public StaffInfo getStaffInfoByAuthorty(int authortyId);
}


