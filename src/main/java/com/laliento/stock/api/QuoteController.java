package com.laliento.stock.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laliento.stock.entity.Quote;
import com.laliento.stock.model.QuotesVo;
import com.laliento.stock.service.QuoteService;

/**
 * @author Eduardo Cruz Zamorano
 *
 */
@RestController
@RequestMapping("/rest/db")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String userName ){
		return getQuotesByUserName(userName);
	}

	/**
	 * @param userName
	 * @return
	 */
	private List<String> getQuotesByUserName(final String userName) {
		return getQuoteByUserName(userName)
				.stream()
				.map(Quote::getQuote)
				.collect(Collectors.toList());
	}

	/**
	 * @param userName
	 * @return
	 */
	private List<Quote> getQuoteByUserName(final String userName) {
		return quoteService.findByUserName(userName);
	}
	
	@PostMapping("/add")
	public List<String> addQuote(@RequestBody final QuotesVo quotes){
//		quotes.getQuotes()
//		.stream()
//		.forEach(quote ->{
//			quoteService.save(new Quote(quotes.getUserName(),quote));
//		});
		quotes.getQuotes()
		.stream()
		.map(quote -> new Quote(quotes.getUserName(),quote))
		.forEach(quote -> quoteService.save(quote));
		
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@PostMapping("/delete/{userName}")
	public boolean deleteQuote(@PathVariable("userName") final String userName) {
		return quoteService.delete(userName);
	}
}
