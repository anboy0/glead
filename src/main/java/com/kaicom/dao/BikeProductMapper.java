package com.kaicom.dao;

import com.kaicom.model.BikeProduct;
import com.kaicom.model.BikeProductExample;
import com.kaicom.model.BikeProductKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeProductMapper {
    long countByExample(BikeProductExample example);

    int deleteByExample(BikeProductExample example);

    int deleteByPrimaryKey(BikeProductKey key);

    int insert(BikeProduct record);

    int insertSelective(BikeProduct record);

    List<BikeProduct> selectByExample(BikeProductExample example);

    BikeProduct selectByPrimaryKey(BikeProductKey key);

    int updateByExampleSelective(@Param("record") BikeProduct record, @Param("example") BikeProductExample example);

    int updateByExample(@Param("record") BikeProduct record, @Param("example") BikeProductExample example);

    int updateByPrimaryKeySelective(BikeProduct record);

    int updateByPrimaryKey(BikeProduct record);
}