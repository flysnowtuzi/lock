package com.haibei.service.lock;

import com.haibei.pojo.lock.Device;
import com.haibei.pojo.lock.DeviceExample;
import java.util.List;

public interface DeviceService {
    int countByExample(DeviceExample example);

    Device selectByPrimaryKey(String devId);

    List<Device> selectByExample(DeviceExample example);

    int deleteByPrimaryKey(String devId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    int deleteByExample(DeviceExample example);

    int updateByExampleSelective(Device record, DeviceExample example);

    int updateByExample(Device record, DeviceExample example);

    int insert(Device record);

    int insertSelective(Device record);
}