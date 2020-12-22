package edu.umb.cs681.hw16;

public class StockEvent {
    private String ticker;
    private Float quote;

    StockEvent(String t, Float q) {
        ticker = t;
        quote = q;
    }

    public String getTicker() {
        return ticker;
    }

    public Float getQuote() {
        return quote;
    }
}
