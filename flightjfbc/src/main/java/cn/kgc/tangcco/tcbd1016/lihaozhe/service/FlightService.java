package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.sql.SQLException;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;

public interface FlightService {
	/**
	 * 按条件动态查询航班信息
	 * @param map			查询条件
	 * @return				查询状态包括航班信息
	 * @throws SQLException	SQL异常
	 */
	public abstract Map<String,Object> queryFlights(Map<String,Object> map) throws SQLException;

	public abstract Map<String, Object> addFlight(Flight flight) throws SQLException;
}
