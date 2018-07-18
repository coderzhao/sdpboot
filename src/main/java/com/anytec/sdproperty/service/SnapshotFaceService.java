package com.anytec.sdproperty.service;


import com.anytec.sdproperty.data.model.TbSnapshotFace;
import com.anytec.sdproperty.data.vo.OutputSnapshotFaceVo;

import java.util.List;

/**
 * 
 * @author SnapshotFace 相关的service
 *
 */
public interface SnapshotFaceService extends BaseService{

    int insert(TbSnapshotFace tbSnapshotFace);
    public List<OutputSnapshotFaceVo> queryListBySnapshotId(int snapshotId);
    public OutputSnapshotFaceVo queryOutputSnapshotFaceVoBySnapshotId(int snapshotId);

}
