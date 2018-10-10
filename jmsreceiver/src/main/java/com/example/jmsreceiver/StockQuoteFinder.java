package com.example.jmsreceiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class StockQuoteFinder {

    @JmsListener(destination = "StockQueue", containerFactory = "stockFactory")
    public void receiveMessage(String symbol) throws Exception {
        double price = Math.random() * 1000;
        System.out.println("Price of " + symbol + ": " + price);
    }
}