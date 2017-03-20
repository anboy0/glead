package com.kaicom.dao;

import com.kaicom.model.BikeVendor;
import com.kaicom.model.BikeVendorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeVendorMapper {
    long countByExample(BikeVendorExample example);

    int deleteByExample(BikeVendorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BikeVendor record);

    int insertSelective(BikeVendor record);

    List<BikeVendor> selectByExample(BikeVendorExample example);

    BikeVendor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BikeVendor record, @Param("example") BikeVendorExample example);

    int updateByExample(@Param("record") BikeVendor record, @Param("example") BikeVendorExample example);

    int updateByPrimaryKeySelective(BikeVendor record);

    int updateByPrimaryKey(BikeVendor record);
}