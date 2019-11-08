package com.kaicom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaicom.dao.BikeDeviceMapper;
import com.kaicom.dao.BikeLocationMapper;
import com.kaicom.dao.BikeVendorMapper;
import com.kaicom.dao.BikeVersionMapper;
import com.kaicom.model.BikeDevice;
import com.kaicom.model.BikeDeviceExample;
import com.kaicom.model.BikeLocation;
import com.kaicom.model.BikeLocationExample;
import com.kaicom.model.BikeVersion;
import com.kaicom.model.BikeVersionExample;
@Transactional
@Service
public class BikeDeviceService {
	@Autowired
	private BikeDeviceMapper bikeDeviceMapper;
	@Autowired
	private BikeLocationMapper bikeLocationMapper;
	@Autowired
	private BikeVendorMapper bikeVendorMapper;
	@Autowired
	private BikeVersionMapper bikeVersion;

	public BikeDevice getBikeFromTel(String tel) {
		BikeDeviceExample example = new BikeDeviceExample();
		BikeDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andTelEqualTo(tel);
		example.setOrderByClause("reg_time desc");

		List<BikeDevice> bike = bikeDeviceMapper.selectByExample(example);
		if (bike != null &&bike.size()>0 )
			return bike.get(0);
		else
			return null;
	}

	public boolean hasBike(String tel) {
		BikeDeviceExample example = new BikeDeviceExample();
		BikeDeviceExample.Criteria criteria = example.createCriteria();
		criteria.andTelEqualTo(tel);

		long i = bikeDeviceMapper.countByExample(example);
		if (i > 0)
			return true;
		else
			return false;
	}

	public boolean update(BikeDevice dev) {
		BikeDeviceExample example = new BikeDeviceExample();
		BikeDeviceExample.Criteria criteria = example.createCriteria();
		//criteria.andIdEqualTo(dev.getId());
		criteria.andTelEqualTo(dev.getTel());
		//criteria.andConfigChangedEqualTo((byte) 0);
		int i = bikeDeviceMapper.updateByExample(dev, example);

		if (i > 0)
			return true;
		else
			return false;
	}

	public boolean save(BikeDevice dev) {
		// BikeDeviceExample example = new BikeDeviceExample();
		// BikeDeviceExample.Criteria criteria = example.createCriteria();

		int i = bikeDeviceMapper.insert(dev);

		if (i > 0)
			return true;
		else
			return false;
	}

	public boolean save(BikeLocation dev) {
		BikeLocationExample example = new BikeLocationExample();
		BikeLocationExample.Criteria criteria = example.createCriteria();

		int i = bikeLocationMapper.insert(dev);

		if (i > 0)
			return true;
		else
			return false;
	}

	public BikeVersion getBikeVersionBy(String vendor, String product) {
		BikeVersionExample bike = new BikeVersionExample();
		BikeVersionExample.Criteria criteria = bike.createCriteria();
		criteria.andVendorIdEqualTo(vendor);
		criteria.andProductIdEqualTo(product);

		bike.setOrderByClause("create_time desc");
		List<BikeVersion> list = bikeVersion.selectByExample(bike);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} 
		return null;
	}

}
