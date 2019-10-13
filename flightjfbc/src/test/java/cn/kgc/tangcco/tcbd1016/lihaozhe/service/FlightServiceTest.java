package cn.kgc.tangcco.tcbd1016.lihaozhe.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.impl.FlightServiceImpl;

public class FlightServiceTest {
	FlightService flightService = new FlightServiceImpl();
	@Test
	public void queryFlights() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("departureCity", "北京");
			map.put("arrivalCity", "上海");
			Map<String, Object> queryFlights = flightService.queryFlights(map);
			switch (queryFlights.get("status").toString()) {
			case "success":
				List<Flight> list = (List<Flight>) queryFlights.get("data");
				Iterator<Flight> it = list.listIterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;

			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
