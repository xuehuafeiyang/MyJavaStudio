package com.xjj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjj.dao.PersonDao;
import com.xjj.entity.Person;
import com.xjj.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	@Override
	@Transactional
	public boolean addPerson(Person person) {
		boolean result = personDao.insertPerson(person)>0 ? true : false;
		return result;
	}

	@Override
	//@Transactional
	public boolean updatePersonByPhoneNo(Person person) {
		boolean result = personDao.updatePersonByPhoneNo(person)>0 ? true : false;
		addPerson(person); //测试同一个类中@Transactional是否其作用
		return result;
	}
}
