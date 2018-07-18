package com.anytec.sdproperty.service.impl;

import com.anytec.sdproperty.dao.TbSnapshotFaceMapper;
import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbSnapshotFace;
import com.anytec.sdproperty.data.model.TbSnapshotFaceExample;
import com.anytec.sdproperty.data.vo.OutputSnapshotFaceVo;
import com.anytec.sdproperty.service.GuestService;
import com.anytec.sdproperty.service.SnapshotFaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("SnapshotFaceService")
public class SnapshotFaceServiceImpl implements SnapshotFaceService {
	private static final Logger logger = LoggerFactory.getLogger(SnapshotFaceServiceImpl.class);

	@Autowired
	TbSnapshotFaceMapper tbSnapshotFaceMapper;
	@Autowired
	private TbSnapshotFaceMapper mTbSnapshotMapperFaceMapper;

	@Autowired
	private GuestService mGuestService;

	@Override
	public int insert(TbSnapshotFace tbSnapshotFace) {
		return tbSnapshotFaceMapper.insert(tbSnapshotFace);
	}

	@Override
	public List<OutputSnapshotFaceVo> queryListBySnapshotId(int snapshotId){
		List<OutputSnapshotFaceVo> listVo = new ArrayList<OutputSnapshotFaceVo>();

		TbSnapshotFaceExample example = new TbSnapshotFaceExample();
		TbSnapshotFaceExample.Criteria c = example.createCriteria();
		c.andSnapshotIdEqualTo(snapshotId);
		List<TbSnapshotFace> listData = mTbSnapshotMapperFaceMapper.selectByExample(example);
		if(listData != null && listData.size() > 0){
			for(TbSnapshotFace face : listData){
				OutputSnapshotFaceVo vo = new OutputSnapshotFaceVo();
				vo.setFace(face);
				TbGuest guest = mGuestService.getByCode(face.getGuestCode());
				if(guest != null){
					vo.setGuest(guest);
				}
				listVo.add(vo);
			}
		}

		return listVo;
	}

	public OutputSnapshotFaceVo queryOutputSnapshotFaceVoBySnapshotId(int snapshotId){
		List<OutputSnapshotFaceVo> listVo = queryListBySnapshotId(snapshotId);
		if(listVo != null && listVo.size() > 0){
			return listVo.get(0);
		}
		return null;
	}
}
