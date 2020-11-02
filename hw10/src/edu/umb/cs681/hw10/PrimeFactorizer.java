package edu.umb.cs681.hw10;

import java.util.LinkedList;


public class PrimeFactorizer {
	protected long dividend, from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();

	public PrimeFactorizer(long dividend) {
		if (dividend >= 2) {
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		} else {
			throw new RuntimeException("dividend must be >= 2. dividend==" + dividend);
		}
	}

	public long getDividend() {
		return dividend;
	}

	public long getFrom() {
		return from;
	}

	public long getTo() {
		return to;
	}

	public LinkedList<Long> getPrimeFactors() {
		return factors;
	}

	public void generatePrimeFactors() {
		long divisor = 2;
		while (dividend != 1 && divisor <= to) {
			if (dividend % divisor == 0) {
				factors.add(divisor);
				dividend /= divisor;
			} else {
				if (divisor == 2) {
					divisor++;
				} else {
					divisor += 2;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Prime factors of 8: ");
		PrimeFactorizer fac = new PrimeFactorizer(8);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 23: ");
		fac = new PrimeFactorizer(23);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 147: ");
		fac = new PrimeFactorizer(147);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 96: ");
		fac = new PrimeFactorizer(96);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 47: ");
		fac = new PrimeFactorizer(47);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 2412: ");
		fac = new PrimeFactorizer(2412);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());

		System.out.print("Prime factors of 8767: ");
		fac = new PrimeFactorizer(8767);
		fac.generatePrimeFactors();
		System.out.println(fac.getPrimeFactors());
	}
}
