package com.globalin.ioc.Injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

// 컬렉션을 멤버 변수로 가지고 올 빈 클래스
public class CollectionBean {
	
	
	/* properties
	 * private Properties addressList;
	 * 
	 * public Properties getAddressList() { return addressList; }
	 * 
	 * public void setAddressList(Properties addressList) { this.addressList =
	 * addressList; }
	 */
	
	
	// Map의 메서드
	private Map<String, String> addressList;

	public Map<String, String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	
	
	/*	set의 메서드
	private Set<String> addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
	*/
	
	
	//private List<String> addressList;
	/*
	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	*/
	
	
}