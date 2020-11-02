package edu.umb.cs681.hw01;

public class MyExampleObservable {
	public static void main(String args[]) {

		StockQuoteObservable stockQuote = new StockQuoteObservable();
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer 1 notified.");
		});
		stockQuote.changeQuote("Amazon", 1);
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer 2 notified.");
		});
		stockQuote.changeQuote("Google", 2);

		DJIAQuoteObservable djiaQuote = new DJIAQuoteObservable();
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer 1 notified.");
		});
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer 2 notified.");
		});
		djiaQuote.changeQuote("ABC", 143);
		djiaQuote.changeQuote("XYZ", 33);

	}
}
