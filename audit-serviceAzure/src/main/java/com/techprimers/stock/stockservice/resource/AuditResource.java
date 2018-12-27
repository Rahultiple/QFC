package com.techprimers.stock.stockservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techprimers.stock.dto.AuditDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/audit")
public class AuditResource {

	@Autowired
    RestTemplate restTemplate;

    @GetMapping("/{username}")
    public List<AuditDTO> getStock(@PathVariable("username") final String userName) {

     /*   ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:8300/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });*/
    	   ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
                   null, new ParameterizedTypeReference<List<String>>() {
                   });

        List<String> quotes = quoteResponse.getBody();
        return quotes
                .stream()
                .map(this::getStockPrice)
                .collect(Collectors.toList());
    }
    @GetMapping("/hello")
    public List<AuditDTO> sayHello() {
    	List<AuditDTO> listquotes = new ArrayList<AuditDTO>(5);
        listquotes.add(new AuditDTO("Suhas"));
        listquotes.add(new AuditDTO("Sony"));
        listquotes.add(new AuditDTO("Kamal"));
        listquotes.add(new AuditDTO("Venkat"));
        return listquotes;
    }
    
    private AuditDTO getStockPrice(String quote) {
        try {
            //return YahooFinance.get(quote);
        	AuditDTO stock= new AuditDTO(quote+"->Symbol");
        	 return stock;
        } catch (Exception e) {
            e.printStackTrace();
            return new AuditDTO(quote);
        }
    }
    
}
