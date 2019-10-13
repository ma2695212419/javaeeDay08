package cn.kfgc.tangcco.lihaozhe.action.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
	/**
	 * lng经度
	 * lat纬度
	 */
	private double lng,lat;
}
