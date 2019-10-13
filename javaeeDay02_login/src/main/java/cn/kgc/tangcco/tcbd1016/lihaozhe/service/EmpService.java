package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Emp;


public interface EmpService {
	public Map<String, Object> loginByAccountAndPassword(Emp emp);
}
