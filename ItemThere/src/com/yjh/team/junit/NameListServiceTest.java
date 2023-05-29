package com.yjh.team.junit;

import org.junit.Test;

import com.yjh.team.domain.Employee;
import com.yjh.team.service.NameListService;
import com.yjh.team.service.TeamException;

/**
 * 对NameListServiceTest类的测试
 * @Description
 * @author yjh  Email:1600063206@qq.com
 * @version
 * @date 2022年10月28日下午3:07:30
 */
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService service =new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i=0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service =new NameListService();
		int id=101;
		
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
