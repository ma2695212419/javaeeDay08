package cn.kgc.tangcco.tcbd1016.lihaozhe.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	private String flightno;
	private String departureCity;
	private String arrivalCity;
	private Date departureTime;
	private Date arrivalTime;
	public Flight(String departureCity, String arrivalCity) {
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}
	
}
