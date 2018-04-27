package com.byzoro;

import java.io.IOException;

import com.byzoro.dao.impl.hdfsDaoImpl;

public class test {
	public static void main(String[] args) throws IOException {
		hdfsDaoImpl hdfsDao = new hdfsDaoImpl();
		hdfsDao.uploadFile();
	}
}
