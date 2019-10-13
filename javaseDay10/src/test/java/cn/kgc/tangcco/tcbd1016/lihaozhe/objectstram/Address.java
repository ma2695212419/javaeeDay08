package cn.kgc.tangcco.tcbd1016.lihaozhe.objectstram;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 7511480081500788290L;
	private String province;
	private String city;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
