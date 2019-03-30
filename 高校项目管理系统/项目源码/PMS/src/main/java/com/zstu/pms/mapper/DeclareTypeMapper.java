package com.zstu.pms.mapper;

import com.zstu.pms.model.DeclareType;
import com.zstu.pms.model.DeclareTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeclareTypeMapper {
    int countByExample(DeclareTypeExample example);

    int deleteByExample(DeclareTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(DeclareType record);

    int insertSelective(DeclareType record);

    List<DeclareType> selectByExample(DeclareTypeExample example);

    DeclareType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") DeclareType record, @Param("example") DeclareTypeExample example);

    int updateByExample(@Param("record") DeclareType record, @Param("example") DeclareTypeExample example);

    int updateByPrimaryKeySelective(DeclareType record);

    int updateByPrimaryKey(DeclareType record);
}