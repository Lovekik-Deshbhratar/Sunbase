package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao ld;

}
