package cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.date.BaseDateUitls;
import cn.kgc.tangcco.tcbd1016.lihaozhe.common.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.common.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.FlightDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.FlightService;

public class FlightServiceImpl implements FlightService {
	// FlightDao flightDao = new FlightDaoImpl();
	private static FlightDao flightDao = null;
	static {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"spring/ApplicationContext-dao.xml");
		try {
			flightDao = (FlightDao) classPathXmlApplicationContext.getBean(FlightDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> queryFlights(Map<String, Object> map) throws SQLException {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("code", 0);
		info.put("msg", "");
		info.put("status", "failed");
		if (map != null && map.containsKey("departureCity") && map.containsKey("arrivalCity")
				&& map.get("departureCity").toString().equals(map.get("arrivalCity").toString())) {
			return info;
		}
		List<Flight> selectFlights = flightDao.selectFlights(map);
		if (selectFlights != null && selectFlights.size() > 0) {
			info.put("data", selectFlights);
			info.put("status", "success");
		}
		return info;
	}

	@Override
	public Map<String, Object> addFlight(Flight flight) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		if (flight.getDepartureTime().after(flight.getArrivalTime())) {
			System.out.println("错误的到达时间：" + BaseDateUitls.getDateString(flight.getArrivalTime()));
			return map;
		}
		try {
			BaseDBUtils.startTransaction();
			int i = flightDao.insertFlight(flight);
			if (i > 0) {
				BaseDBUtils.closeAndCommit();
				map.put("status", "success");
				return map;
			}
		} catch (Exception e) {
			BaseDBUtils.closeAndRollback();
			e.printStackTrace();
			return map;
		}
		return map;
	}
}
