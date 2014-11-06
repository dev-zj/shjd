package dao.impl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

import dao.TestDaoI;
import entity.Student;
@Service
@ComponentScan
@EnableAutoConfiguration
public class TestDao extends SqlMapClientDaoSupport implements TestDaoI {

	@Override
	public String test() {
		// TODO Auto-generated method stub
		Student  stu = (Student)getSqlMapClientTemplate().queryForObject("selectStudent");
		if(stu != null){
			System.out.println(stu.getEmail());
		}
		return "zhangjun1";
	}

}
