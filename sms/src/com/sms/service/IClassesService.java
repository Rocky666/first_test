package com.sms.service;

import java.util.List;

import com.sms.entity.Classes;
import com.sms.utils.Pager;

public interface IClassesService {
	
	public List<Classes> list(Classes classes,Pager pager);
	public int getCount(Classes classes);
}
