package com.trip.dto;

public class Sido {

	private String sido_code;
	private String sido_name;
	
	// 생성자
	public Sido() {}
	public Sido(String sido_code, String sido_name) {
		this.sido_code = sido_code;
		this.sido_name = sido_name;
	}
	
	// getter & setter
	public String getSido_code() {
		return sido_code;
	}
	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
}
