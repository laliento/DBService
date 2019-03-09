package com.laliento.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laliento.stock.entity.Quote;
import com.laliento.stock.repository.QuoteRepository;

/**
 * @author Eduardo Cruz Zamorano
 *
 */
@Service
@Transactional
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	/**
	 * @param userName
	 */
	public List<Quote> findByUserName(String userName) {
		return quoteRepository.findByUserName(userName);
	}
	/**
	 * @param quote
	 * @return Quote
	 */
	public Quote save(Quote quote) {
		return quoteRepository.save(quote);
	}
	/**
	 * @param userName
	 * @return
	 */
	public boolean delete(String userName) {
		List<Quote> quotes = findByUserName(userName);
		quotes
		.stream()
		.forEach(quote -> quoteRepository.delete(quote));
		return true;
	}

}
