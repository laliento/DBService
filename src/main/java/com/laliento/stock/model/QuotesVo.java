package com.laliento.stock.model;

import java.util.List;

import lombok.Data;

/**
 * @author Eduardo Cruz Zamorano
 *
 */
@Data
@lombok.AllArgsConstructor
public class QuotesVo {

	private String userName;
	private List<String> quotes; 
}
