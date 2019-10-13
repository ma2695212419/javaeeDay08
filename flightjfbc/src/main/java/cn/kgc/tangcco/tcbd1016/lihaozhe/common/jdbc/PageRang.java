package cn.kgc.tangcco.tcbd1016.lihaozhe.common.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRang {
	private Integer pageNumber;
	private Integer pageSize;
}
