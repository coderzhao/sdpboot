package com.anytec.sdproperty.jedis;

import com.anytec.sdproperty.data.model.TbDoorLock;
import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbGuestRole;
import com.anytec.sdproperty.data.model.TbIpc;

public interface NecessaryDataService {

    TbIpc getCamera(String mac);

    TbGuest getTbGuest(String sdkId);

    TbGuestRole getTbGuestRole(Integer guestRoleId);

    TbDoorLock getTbOpenLock(Integer doorId);

    TbDoorLock getTbDangerLock(Integer doorId);


}
