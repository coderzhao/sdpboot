package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbDoor;
import com.anytec.sdproperty.data.model.TbDoorExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TbDoorMapper {
    int countByExample(TbDoorExample example);

    int deleteByExample(TbDoorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDoor record);

    int insertSelective(TbDoor record);

    Page<TbDoor> selectByExample(TbDoorExample example);

    TbDoor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDoor record, @Param("example") TbDoorExample example);

    int updateByExample(@Param("record") TbDoor record, @Param("example") TbDoorExample example);

    int updateByPrimaryKeySelective(TbDoor record);

    int updateByPrimaryKey(TbDoor record);
}