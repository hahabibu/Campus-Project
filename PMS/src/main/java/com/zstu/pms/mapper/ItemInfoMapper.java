package com.zstu.pms.mapper;

import com.zstu.pms.model.ItemInfo;
import com.zstu.pms.model.ItemInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemInfoMapper {
    int countByExample(ItemInfoExample example);

    int deleteByExample(ItemInfoExample example);

    int deleteByPrimaryKey(String itemId);

    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

    List<ItemInfo> selectByExample(ItemInfoExample example);

    ItemInfo selectByPrimaryKey(String itemId);

    int updateByExampleSelective(@Param("record") ItemInfo record, @Param("example") ItemInfoExample example);

    int updateByExample(@Param("record") ItemInfo record, @Param("example") ItemInfoExample example);

    int updateByPrimaryKeySelective(ItemInfo record);

    int updateByPrimaryKey(ItemInfo record);
}