package com.kaicom.dao;

import com.kaicom.model.BikeLocation;
import com.kaicom.model.BikeLocationExample;
import com.kaicom.model.BikeLocationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeLocationMapper {
    long countByExample(BikeLocationExample example);

    int deleteByExample(BikeLocationExample example);

    int deleteByPrimaryKey(BikeLocationKey key);

    int insert(BikeLocation record);

    int insertSelective(BikeLocation record);

    List<BikeLocation> selectByExample(BikeLocationExample example);

    BikeLocation selectByPrimaryKey(BikeLocationKey key);

    int updateByExampleSelective(@Param("record") BikeLocation record, @Param("example") BikeLocationExample example);

    int updateByExample(@Param("record") BikeLocation record, @Param("example") BikeLocationExample example);

    int updateByPrimaryKeySelective(BikeLocation record);

    int updateByPrimaryKey(BikeLocation record);
}