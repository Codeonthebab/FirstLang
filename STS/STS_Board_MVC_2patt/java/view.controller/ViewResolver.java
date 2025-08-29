package com.globalin.view.controller;

public class ViewResolver {
	
	public String prefix; // 접두사
	public String suffix; // 접미사
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix+viewName+suffix;
	}
	
}