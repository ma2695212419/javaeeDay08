package cn.kgc.tangcco.tcbd1016.lihaozhe.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1016.lihaozhe.dao.FlightDao;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;

public class FlightDaoImpl implements FlightDao {
	QueryRunner qr = new QueryRunner(BaseDBUtils.getDataSource());
	QueryRunner runner = new QueryRunner();
	@Override
	public List<Flight> selectFlights(Map<String, Object> map) throws SQLException {
		List list = new ArrayList();
		StringBuilder sql = new StringBuilder("SELECT flightno,departureCity,arrivalCity,departureTime,arrivalTime FROM flight");
		sql.append(" WHERE 1 = 1 ");
		if (map != null && map.size() > 0) {
			if (map.containsKey("flight") && !StringUtils.isEmpty(((Flight)map.get("flight")).getDepartureCity())) {
				sql.append(" AND departureCity = ? ");
				list.add(((Flight)map.get("flight")).getDepartureCity());
			}
			if (map.containsKey("flight") && !StringUtils.isEmpty(((Flight)map.get("flight")).getArrivalCity())) {
				sql.append(" AND arrivalCity = ? ");
				list.add(((Flight)map.get("flight")).getArrivalCity());
			}
			sql.append(" ORDER BY departureTime ");
			System.out.println(sql.toString());
			Object[] params = list.toArray();
			return qr.query(sql.toString(), params, new BeanListHandler<Flight>(Flight.class));
		}else {
			sql.append(" ORDER BY departureTime ");
			System.out.println(sql.toString());
			return qr.query(sql.toString(), new BeanListHandler<Flight>(Flight.class));
		}
	}

	@Override
	public int insertFlight(Flight flight) throws SQLException {
		StringBuilder sql = new StringBuilder("INSERT INTO flight");
		sql.append(" SELECT ?,?,?,?,? ");
		sql.append(" WHERE NOT EXISTS ");
		sql.append(" (SELECT flightno FROM flight WHERE flightno = ?) ");
		Object[] params = {flight.getFlightno(),flight.getDepartureCity(),flight.getArrivalCity(),flight.getDepartureTime(),flight.getArrivalTime(),flight.getFlightno()};
		return runner.update(BaseDBUtils.getConnection(), sql.toString(), params);
	}

}
