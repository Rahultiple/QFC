package com.techprimers.stock.dto;

public class AuditDTO {

    private final String symbol;
    private String name;
    private String currency;
    private String stockExchange;
    
   
    public AuditDTO(String symbol) {
        this.symbol = symbol;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getStockExchange() {
		return stockExchange;
	}


	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}


	public String getSymbol() {
		return symbol;
	}
    
    
}
