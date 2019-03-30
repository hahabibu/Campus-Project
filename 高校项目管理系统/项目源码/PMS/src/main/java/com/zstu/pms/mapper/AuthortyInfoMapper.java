package com.zstu.pms.mapper;

import com.zstu.pms.model.AuthortyInfo;
import com.zstu.pms.model.AuthortyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthortyInfoMapper {
    int countByExample(AuthortyInfoExample example);

    int deleteByExample(AuthortyInfoExample example);

    int deleteByPrimaryKey(String authortyId);

    int insert(AuthortyInfo record);

    int insertSelective(AuthortyInfo record);

    List<AuthortyInfo> selectByExample(AuthortyInfoExample example);

    AuthortyInfo selectByPrimaryKey(String authortyId);

    int updateByExampleSelective(@Param("record") AuthortyInfo record, @Param("example") AuthortyInfoExample example);

    int updateByExample(@Param("record") AuthortyInfo record, @Param("example") AuthortyInfoExample example);

    int updateByPrimaryKeySelective(AuthortyInfo record);

    int updateByPrimaryKey(AuthortyInfo record);
}