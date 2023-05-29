package com.yjh.team.service;
/**
 * 自定义异常类
 * @Description
 * @author yjh  Email:1600063206@qq.com
 * @version
 * @date 2022年10月28日上午11:29:38
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -338752343124229948L;
	
	public TeamException() {
		super();
	}
	public TeamException(String msg) {
		super(msg);
	}
}
