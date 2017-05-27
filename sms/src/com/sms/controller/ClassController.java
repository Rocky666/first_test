package com.sms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sms.entity.Classes;
import com.sms.service.IClassesService;
import com.sms.utils.Pager;

@Controller
@RequestMapping("class")
public class ClassController {

	@Autowired
	IClassesService classesService;

	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> list(Classes classes,Pager pager, Integer page, Integer rows) {
		// 设置起始位置，结束位置
		pager.setStart((page - 1) * rows);
		pager.setEnd(rows);
		//计算总记录数
		System.out.println("------------"+classes.getId()+classes.getText()+"``````````````");
			int totalCount = classesService.getCount(classes);
			HashMap<String, Object> result = new HashMap<String, Object>();
			result.put("total", totalCount);
			result.put("rows", classesService.list(classes,pager));
			return result;
	}
}
