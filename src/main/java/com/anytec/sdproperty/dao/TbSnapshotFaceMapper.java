package com.anytec.sdproperty.dao;

import com.anytec.sdproperty.data.model.TbSnapshotFace;
import com.anytec.sdproperty.data.model.TbSnapshotFaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSnapshotFaceMapper {
    int countByExample(TbSnapshotFaceExample example);

    int deleteByExample(TbSnapshotFaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSnapshotFace record);

    int insertSelective(TbSnapshotFace record);

    List<TbSnapshotFace> selectByExample(TbSnapshotFaceExample example);

    TbSnapshotFace selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSnapshotFace record, @Param("example") TbSnapshotFaceExample example);

    int updateByExample(@Param("record") TbSnapshotFace record, @Param("example") TbSnapshotFaceExample example);

    int updateByPrimaryKeySelective(TbSnapshotFace record);

    int updateByPrimaryKey(TbSnapshotFace record);
}