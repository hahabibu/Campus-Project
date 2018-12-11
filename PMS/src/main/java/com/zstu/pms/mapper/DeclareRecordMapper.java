package com.zstu.pms.mapper;

import com.zstu.pms.model.DeclareRecord;
import com.zstu.pms.model.DeclareRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeclareRecordMapper {
    int countByExample(DeclareRecordExample example);

    int deleteByExample(DeclareRecordExample example);

    int deleteByPrimaryKey(String declareId);

    int insert(DeclareRecord record);

    int insertSelective(DeclareRecord record);

    List<DeclareRecord> selectByExample(DeclareRecordExample example);

    DeclareRecord selectByPrimaryKey(String declareId);

    int updateByExampleSelective(@Param("record") DeclareRecord record, @Param("example") DeclareRecordExample example);

    int updateByExample(@Param("record") DeclareRecord record, @Param("example") DeclareRecordExample example);

    int updateByPrimaryKeySelective(DeclareRecord record);

    int updateByPrimaryKey(DeclareRecord record);
}