package com.haibei.service.impl.lock;

import com.haibei.dao.lock.DeviceMapper;
import com.haibei.pojo.lock.Device;
import com.haibei.pojo.lock.DeviceExample;
import com.haibei.service.lock.DeviceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    public int countByExample(DeviceExample example) {
        int count = this.deviceMapper.countByExample(example);
        return count;
    }

    public Device selectByPrimaryKey(String devId) {
        return this.deviceMapper.selectByPrimaryKey(devId);
    }

    public List<Device> selectByExample(DeviceExample example) {
        return this.deviceMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String devId) {
        return this.deviceMapper.deleteByPrimaryKey(devId);
    }

    public int updateByPrimaryKeySelective(Device record) {
        return this.deviceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Device record) {
        return this.deviceMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(DeviceExample example) {
        return this.deviceMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Device record, DeviceExample example) {
        return this.deviceMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Device record, DeviceExample example) {
        return this.deviceMapper.updateByExample(record, example);
    }

    public int insert(Device record) {
        return this.deviceMapper.insert(record);
    }

    public int insertSelective(Device record) {
        return this.deviceMapper.insertSelective(record);
    }
}