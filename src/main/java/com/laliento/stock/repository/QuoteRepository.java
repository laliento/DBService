package com.laliento.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laliento.stock.entity.Quote;

/**
 * @author Eduardo Cruz Zamorano
 *
 */
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>{

	/**
	 * @param userName
	 */
	List<Quote> findByUserName(String userName);

}
