package com.yjh.team.service;
/**
 * 
 * @Description 表示员工的状态
 * @author yjh  Email:1600063206@qq.com
 * @version
 * @date 2022年10月27日下午2:54:25
 */
//public class Status {
//
//	private final String NAME;
//	private Status(String name) {
//		this.NAME=name;
//	}
//
//	public static final Status FREE=new Status("FREE");
//	public static final Status BUSY=new Status("BUSY");
//	public static final Status VOCATION=new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	public String toString() {
//		return NAME;
//	}
//}
public enum Status{
	FREE,BUSY,VOCATION;
}
