package cn.kgc.tangcco.tcbd1016.lihaozhe.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cn.kgc.tangcco.tcbd1016.lihaozhe.common.date.BaseDateUitls;
import cn.kgc.tangcco.tcbd1016.lihaozhe.common.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1016.lihaozhe.pojo.Flight;
import cn.kgc.tangcco.tcbd1016.lihaozhe.service.FlightService;

public class FlightAction {
	private static FlightService flightService = null;
	static {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"spring/ApplicationContext-service.xml");
		try {
			flightService = (FlightService) classPathXmlApplicationContext.getBean(FlightService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FlightAction() {
		print();
	}

	Scanner sc = new Scanner(System.in);

	public void print() {
		System.out.println("1、显示所有航班信息");
		System.out.println("2、查询航班");
		System.out.println("3、显示所有航班信息");
		System.out.println("4、显示所有航班信息");
		System.out.println("0、推出");
		option();
	}

	public void option() {
		System.out.print("请输入>>>");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			try {
				queryFlights(null);
				print();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				System.out.print("请输入起飞城市>>>");
				String departureCity = sc.next().trim();
				System.out.print("请输入抵达城市>>>");
				String arrivalCity = sc.next().trim();
				Flight flight = new Flight(departureCity, arrivalCity);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("flight", flight);
				queryFlights(map);
				print();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			addFlight();
			print();
			break;

		default:
			break;
		}
	}

	public void queryFlights(Map<String, Object> map) throws SQLException {
		Map<String, Object> queryFlights = flightService.queryFlights(map);
		switch (queryFlights.get("status").toString()) {
		case "success":
			List<Flight> list = (List<Flight>) queryFlights.get("data");
			System.out.println(list);
			Iterator<Flight> it = list.listIterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			break;

		default:
			System.out.println("没有查询到符合条件的航班信息");
			break;
		}
	}

	public void addFlight() {
		try {
			System.out.print("请输入航班编号：");
			String flightno = sc.next().trim();
			System.out.print("起飞城市：");
			String departureCity = sc.next().trim();
			System.out.print("起飞时间（ 格式为：2019-06-06 20:30:00 ）：");
			String dDay = sc.next();
			String dtime = dDay + sc.nextLine();
			Date departureTime = BaseDateUitls.parse(dtime);
			System.out.print("到达城市：");
			String arrivalCity = sc.next().trim();
			System.out.print("到达时间（ 格式为：2019-06-06 21:00:00 ）：");
			String aDay = sc.next();
			String atime = aDay + sc.nextLine();
			Date arrivalTime = BaseDateUitls.parse(atime);
			Map<String, Object> map = flightService.addFlight(new Flight(flightno, departureCity, arrivalCity, departureTime, arrivalTime));
			switch (map.get("status").toString()) {
			case "success":
				System.out.println("添加成功");
				break;
			case "failed":
				System.out.println("添加失败");
				break;

			default:
				break;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
