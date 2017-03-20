package com.kaicom.dao;

import com.kaicom.model.BikeVersion;
import com.kaicom.model.BikeVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeVersionMapper {
    long countByExample(BikeVersionExample example);

    int deleteByExample(BikeVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BikeVersion record);

    int insertSelective(BikeVersion record);

    List<BikeVersion> selectByExample(BikeVersionExample example);

    BikeVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BikeVersion record, @Param("example") BikeVersionExample example);

    int updateByExample(@Param("record") BikeVersion record, @Param("example") BikeVersionExample example);

    int updateByPrimaryKeySelective(BikeVersion record);

    int updateByPrimaryKey(BikeVersion record);
}