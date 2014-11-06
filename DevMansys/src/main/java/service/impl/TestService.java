package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import service.TestServiceI;
import dao.TestDaoI;

@Service
@ComponentScan("dao")
@EnableAutoConfiguration
public class TestService implements TestServiceI {
	
	@Autowired(required=true)
	public TestDaoI testDao;
	
	public String test() {
		// TODO Auto-generated method stub
		return testDao.test();
	}

}
