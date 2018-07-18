package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbIpc;
import com.anytec.sdproperty.data.model.TbIpcExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TbIpcMapper {
    int countByExample(TbIpcExample example);

    int deleteByExample(TbIpcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbIpc record);

    int insertSelective(TbIpc record);

    Page<TbIpc> selectByExample(TbIpcExample example);

    TbIpc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbIpc record, @Param("example") TbIpcExample example);

    int updateByExample(@Param("record") TbIpc record, @Param("example") TbIpcExample example);

    int updateByPrimaryKeySelective(TbIpc record);

    int updateByPrimaryKey(TbIpc record);
}