package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbInitSession;
import com.anytec.sdproperty.data.model.TbInitSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbInitSessionMapper {
    int countByExample(TbInitSessionExample example);

    int deleteByExample(TbInitSessionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbInitSession record);

    int insertSelective(TbInitSession record);

    List<TbInitSession> selectByExample(TbInitSessionExample example);

    TbInitSession selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbInitSession record, @Param("example") TbInitSessionExample example);

    int updateByExample(@Param("record") TbInitSession record, @Param("example") TbInitSessionExample example);

    int updateByPrimaryKeySelective(TbInitSession record);

    int updateByPrimaryKey(TbInitSession record);
}