package com.byzoro.service;import java.util.HashMap;/** * @author huanyuguo * @date 2018/5/10 11:40 */public interface InsertService {    public String addIndex(String index, String type, HashMap<String, Object> hashMap);    public void addAllIndex(String index, String type, HashMap<String, Object> hashMap);}