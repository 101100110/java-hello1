package com.yjh.team.domain;

public class PC implements Equipment {

	private String model;//机器型号
	private String display;//显式器名称
	
	public PC() {
		super();
	}

	public PC(String model,String display) {
		
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {
		return model +"("+display+")";
	}

}
