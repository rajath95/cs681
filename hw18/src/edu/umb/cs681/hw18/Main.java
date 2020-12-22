package edu.umb.cs681.hw18;

public class Main {

    public static void main(String[] args) {
        StockQuoteObservable s = new StockQuoteObservable();

        s.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float quote = ((StockEvent) obj).getQuote();
            System.out.println("Observer 1 - Stock event: " + ticker + " " + quote);
        });

        s.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float quote = ((StockEvent) obj).getQuote();
            System.out.println("Observer 2 - Stock event: " + ticker + " " + quote);
        });

        System.out.println("Number of observers: " + s.countObservers());

        String AMZNCode = "AMZN";
        Float AMZNValue = 10.0f;

        System.out.println("Add new Stock: " + AMZNCode);
        s.setQuote(AMZNCode, AMZNValue);

        AMZNValue = 20.0f;
        System.out.println("AMZN changed");
        s.changeQuote(AMZNCode, AMZNValue);
    }
}
