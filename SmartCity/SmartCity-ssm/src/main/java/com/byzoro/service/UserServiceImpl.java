package com.byzoro.service;

import com.byzoro.mapper.PersonMapper;
import com.byzoro.pojo.Person;

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
//    	return null;
        return personMapper.selectByExample(null);
    }
}