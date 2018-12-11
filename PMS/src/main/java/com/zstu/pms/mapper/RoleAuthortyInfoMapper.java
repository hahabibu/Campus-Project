package com.zstu.pms.mapper;

import com.zstu.pms.model.RoleAuthortyInfo;
import com.zstu.pms.model.RoleAuthortyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthortyInfoMapper {
    int countByExample(RoleAuthortyInfoExample example);

    int deleteByExample(RoleAuthortyInfoExample example);

    int deleteByPrimaryKey(String roleAuthortyId);

    int insert(RoleAuthortyInfo record);

    int insertSelective(RoleAuthortyInfo record);

    List<RoleAuthortyInfo> selectByExample(RoleAuthortyInfoExample example);

    RoleAuthortyInfo selectByPrimaryKey(String roleAuthortyId);

    int updateByExampleSelective(@Param("record") RoleAuthortyInfo record, @Param("example") RoleAuthortyInfoExample example);

    int updateByExample(@Param("record") RoleAuthortyInfo record, @Param("example") RoleAuthortyInfoExample example);

    int updateByPrimaryKeySelective(RoleAuthortyInfo record);

    int updateByPrimaryKey(RoleAuthortyInfo record);
}