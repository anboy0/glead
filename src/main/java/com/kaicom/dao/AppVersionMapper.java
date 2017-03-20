package com.kaicom.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.kaicom.pojo.AppVersion;
import com.kaicom.pojo.AppVersionExample;


public interface AppVersionMapper {
    int countByExample(AppVersionExample example);

    int deleteByExample(AppVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppVersion record, @Param("example") AppVersionExample example);

    int updateByExample(@Param("record") AppVersion record, @Param("example") AppVersionExample example);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

	/**
	 * @return
	 */
	List<AppVersion> selectAllApp();
}