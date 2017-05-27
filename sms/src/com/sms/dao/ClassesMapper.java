package com.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sms.entity.Classes;
import com.sms.utils.Pager;

public interface ClassesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(String id);
    
    List<Classes> selectAll(@Param("classes")Classes classes,@Param("pager")Pager pager);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    int getCount(@Param("classes")Classes classes);
}