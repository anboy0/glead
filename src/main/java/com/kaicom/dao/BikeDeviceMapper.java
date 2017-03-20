package com.kaicom.dao;

import com.kaicom.model.BikeDevice;
import com.kaicom.model.BikeDeviceExample;
import com.kaicom.model.BikeDeviceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeDeviceMapper {
    long countByExample(BikeDeviceExample example);

    int deleteByExample(BikeDeviceExample example);

    int deleteByPrimaryKey(BikeDeviceKey key);

    int insert(BikeDevice record);

    int insertSelective(BikeDevice record);

    List<BikeDevice> selectByExample(BikeDeviceExample example);

    BikeDevice selectByPrimaryKey(BikeDeviceKey key);

    int updateByExampleSelective(@Param("record") BikeDevice record, @Param("example") BikeDeviceExample example);

    int updateByExample(@Param("record") BikeDevice record, @Param("example") BikeDeviceExample example);

    int updateByPrimaryKeySelective(BikeDevice record);

    int updateByPrimaryKey(BikeDevice record);
}