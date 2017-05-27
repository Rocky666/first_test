package com.sms.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dao.ClassesMapper;
import com.sms.entity.Classes;
import com.sms.service.IClassesService;
import com.sms.utils.Pager;

@Service
public class ClassesService implements IClassesService{
	
	@Autowired
	ClassesMapper classesMapper;
	@Override
	public List<Classes> list(Classes classes,Pager pager) {
		// TODO Auto-generated method stub
		return classesMapper.selectAll(classes,pager);
	}
	@Override
	public int getCount(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.getCount(classes);
	}

}
