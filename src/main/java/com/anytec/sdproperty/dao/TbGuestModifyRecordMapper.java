package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbGuestModifyRecord;
import com.anytec.sdproperty.data.model.TbGuestModifyRecordExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TbGuestModifyRecordMapper {
    int countByExample(TbGuestModifyRecordExample example);

    int deleteByExample(TbGuestModifyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGuestModifyRecord record);

    int insertSelective(TbGuestModifyRecord record);

    Page<TbGuestModifyRecord> selectByExample(TbGuestModifyRecordExample example);

    TbGuestModifyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbGuestModifyRecord record, @Param("example") TbGuestModifyRecordExample example);

    int updateByExample(@Param("record") TbGuestModifyRecord record, @Param("example") TbGuestModifyRecordExample example);

    int updateByPrimaryKeySelective(TbGuestModifyRecord record);

    int updateByPrimaryKey(TbGuestModifyRecord record);
}