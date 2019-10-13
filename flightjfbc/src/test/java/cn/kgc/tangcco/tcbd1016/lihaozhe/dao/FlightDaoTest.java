package cn.kgc.tangcco.tcbd1016.lihaozhe.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl.FlightDaoImpl;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;

public class FlightDaoTest {
	FlightDao flightDao = new FlightDaoImpl();
	@Test
	public void selectFlights() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flight", new Flight("北京", "上海"));
			List<Flight> selectFlights = flightDao.selectFlights(map);
			ListIterator<Flight> it = selectFlights.listIterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
