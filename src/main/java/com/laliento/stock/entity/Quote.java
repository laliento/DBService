package com.laliento.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Eduardo Cruz Zamorano
 *
 */
@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Table(name = "ENT_QUOTE")
public class Quote {

	@Id
	@Column(name="ID_QUOTE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuote;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name ="QUOTE")
	private String quote;
	
	public Quote(String userName, String quote) {
		this.userName = userName;
		this.quote = quote;
	}
}
