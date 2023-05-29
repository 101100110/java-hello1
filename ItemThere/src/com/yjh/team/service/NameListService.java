package com.yjh.team.service;

import com.yjh.team.domain.Architect;
import com.yjh.team.domain.Designer;
import com.yjh.team.domain.Employee;
import com.yjh.team.domain.Equipment;
import com.yjh.team.domain.NoteBook;
import com.yjh.team.domain.PC;
import com.yjh.team.domain.Programmer;
import com.yjh.team.domain.Printer;

import static com.yjh.team.service.Data.*;

/**
 * 
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author yjh  Email:1600063206@qq.com
 * @version
 * @date 2022年10月27日下午4:29:15
 */
public class NameListService {
		
	private Employee[] employees;
	
	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
		//根据项目提供的Data类构建相应大小的employees数组
		employees =new Employee[EMPLOYEES.length];
		
		for(int i=0;i<employees.length;i++) {
			//获取员工的类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			//获取Employee的4个基本信息
			int id=Integer.parseInt(EMPLOYEES[i][1]);
			String name=EMPLOYEES[i][2];
			int age=Integer.parseInt(EMPLOYEES[i][3]);
			double salary=Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i]=new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
				equipment =creatEquipment(i);
				employees[i]=new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = creatEquipment(i);
				bonus =Double.parseDouble(EMPLOYEES[i][5]);
				employees[i]=new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment =creatEquipment(i);
				bonus =Double.parseDouble(EMPLOYEES[i][5]);
				stock=Integer.parseInt(EMPLOYEES[i][6]);
				employees[i]=new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	/**
	 * 
	 * @Description 获取指定Index上的员工的设备
	 * @author yjh
	 * @date 2022年10月27日下午5:00:19
	 * @return
	 */
	private Equipment creatEquipment(int index) {
		
		int key = Integer.parseInt(EQIPMENTS[index][0]);
		
		String modelOrName=EQIPMENTS[index][1];
		switch(key) {
		case PC://21
			String display=EQIPMENTS[index][2];
			return new PC(modelOrName,display);
		case NOTEBOOK://22
			double price =Double.parseDouble(EQIPMENTS[index][2]);
			return new NoteBook(modelOrName,price);
		case PRINTER://23
			String type=EQIPMENTS[index][2];
			return new Printer(modelOrName,type);
		}
		
		return null;
	}
	
	/**
	 * 获取当前的所有员工
	 * @Description 
	 * @author yjh
	 * @date 2022年10月28日上午11:25:48
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	 * @Description 获取指定ID的员工对象
	 * @author yjh
	 * @date 2022年10月28日上午11:26:37
	 * @param id
	 * @return
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		
		throw new TeamException("找不到指定员工");
	}
}
