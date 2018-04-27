package com.guotou.springmvc.service;

import com.guotou.springmvc.mapper.PersonMapper;
import com.guotou.springmvc.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public List<Person> findAll() {
        return personMapper.selectByExample(null);
    }
}