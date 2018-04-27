package com.byzoro.service;

import com.byzoro.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Person> findAll();
}


