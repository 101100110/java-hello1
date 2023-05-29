package com.yjh.team.view;

import com.yjh.team.domain.Employee;
import com.yjh.team.domain.Programmer;
import com.yjh.team.service.NameListService;
import com.yjh.team.service.TeamException;
import com.yjh.team.service.TeamService;

public class TeamView {

	private NameListService listSvc=new NameListService();
	private TeamService teamSvc=new TeamService();
	
	public void enterMainMenu() {
		boolean loopFlag=true;
		char menu=0;
		while(loopFlag) {
			if(menu !='1') {
				listAllEmployee();
			}
			
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）");
			menu=TSUtility.readMenuSelection();
			switch(menu) {
			case'1':
				getTeam();
				break;
			case'2':
				addMenter();
				break;
			case'3':
				deleteMember();
				break;
			case'4':
				System.out.println("确认是否退出（Y/N）：");
				char isExit=TSUtility.readConfirmSelection();
				if(isExit =='Y') {
					loopFlag=false;
				}
				break;
			}
		}
	}
	private void listAllEmployee() {
		System.out.println("------------------------------------开发团队调度软件---------------------------------------");
        System.out.println("ID\t姓名\t\t年龄\t工资\t\t\t职位\t\t状态\t\t\t奖金\t\t\t\t股票\t\t\t领用设备");
        //显示员工详细信息
        for (int i = 0; i < listSvc.getAllEmployees().length; i++) {
            System.out.println(listSvc.getAllEmployees()[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

	private void getTeam() {
		System.out.println("---------------------团队成员列表--------------------------\n");
		
		Programmer[] team=teamSvc.getTeam();
		if(team == null || team.length ==0) {
			System.out.println("开发团队目前没有成员!");
		}else{
			System.out.println("TID/ID\t姓名\t 年龄\t 工资\t 职位\t 奖金\t 股票\n");
			for(int i=0;i<team.length;i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		
		System.out.println("---------------------------------------------------------------");
	}
	private void addMenter() {
		System.out.println("---------------------添加成员--------------------------\n");
		System.out.println("请输入要添加的员工ID：");
		int id=TSUtility.readInt();
		
		try {
			Employee emp=listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("添加成功！");
		} catch (TeamException e) {
			System.out.println("添加失败，原因："+e.getMessage());
		}
		//按回车键继续
		TSUtility.readReturn();
	}
	private void deleteMember() {
		System.out.println("---------------------删除成员--------------------------\n");
		System.out.print("请输入要删除员工的TID：");
		int memberId = TSUtility.readInt();
		
		System.out.print("确认是否删除（Y/N）:");
		char isDelete =TSUtility.readConfirmSelection();
		if(isDelete =='N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因："+e.getMessage());
		}
		//按回车键继续
		TSUtility.readReturn();
	}
	
	public static void main(String[] args) {
		TeamView view =new TeamView();
		view.enterMainMenu();
	} 
}
