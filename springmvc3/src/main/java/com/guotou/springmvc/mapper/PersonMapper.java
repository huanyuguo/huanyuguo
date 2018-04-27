package com.guotou.springmvc.mapper;

import com.guotou.springmvc.pojo.Person;
import com.guotou.springmvc.pojo.PersonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    int countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);
}