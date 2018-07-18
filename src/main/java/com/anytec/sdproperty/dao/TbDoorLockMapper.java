package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbDoorLock;
import com.anytec.sdproperty.data.model.TbDoorLockExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TbDoorLockMapper {
    int countByExample(TbDoorLockExample example);

    int deleteByExample(TbDoorLockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDoorLock record);

    int insertSelective(TbDoorLock record);

    Page<TbDoorLock> selectByExample(TbDoorLockExample example);

    TbDoorLock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDoorLock record, @Param("example") TbDoorLockExample example);

    int updateByExample(@Param("record") TbDoorLock record, @Param("example") TbDoorLockExample example);

    int updateByPrimaryKeySelective(TbDoorLock record);

    int updateByPrimaryKey(TbDoorLock record);
}