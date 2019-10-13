package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;

public interface FlightDao {
	/**
	 * 按条件动态查询航班信息
	 * @param map			查询条件
	 * @return				航班信息
	 * @throws SQLException	SQL异常
	 */
	public abstract List<Flight> selectFlights(Map<String, Object> map) throws SQLException;
	/**
	 * 按条件动态查询航班信息
	 * @param flight		新增航班
	 * @return				新增状态
	 * @throws SQLException	SQL异常
	 */
	public abstract int insertFlight(Flight flight) throws SQLException;
}
