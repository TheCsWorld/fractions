package mymaths;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(Fraction copy) {
		this.numerator = copy.getNumerator();
		this.denominator = copy.getDenominator();
	}
	
	public Fraction(int wholeNumber) {
		this(wholeNumber, 1);
	}
	public Fraction(int numerator, int denominator) {
		if(denominator==0)
		{
			System.out.println("Error!");
		}
		if(denominator<0)
		{
			numerator *=  -1;
			denominator *= -1;
		}
		
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public void setNumerator(int num) {
		numerator = num;
	}
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public Fraction multiply(Fraction other) {
		int newNumerator = this.getNumerator() * other.getNumerator();
		int newDenominator = this.getDenominator() * other.getDenominator();

		return new Fraction(newNumerator, newDenominator);
		
	}
	public Fraction multiply(int wholeNumber) {
		Fraction newFraction = new Fraction(wholeNumber);
		return this.multiply(newFraction);
	}
	
	public Fraction add(Fraction other)
	{
		int newDenominator = this.getDenominator() * other.getDenominator();
		int firstNumerator = this.getNumerator() * other.getDenominator();
		int secondNumerator = other.getNumerator() * this.getDenominator();
		int addedNumerator = firstNumerator + secondNumerator;
		
		return new Fraction(addedNumerator, newDenominator);
	}

	public static void main(String[] args) {
		
		Fraction frac = new Fraction(1, 8);
		System.out.println(frac);
		Fraction frac2 = new Fraction(1, 4);
		System.out.println(frac2);
		frac2.setNumerator(2);
		System.out.println(frac2);
		
		Fraction frac3 = frac.multiply(frac2);
		
		frac = frac.multiply(frac2);
		frac.multiply(frac2);
		System.out.println(frac);
		
		Fraction frac4 = new Fraction(3);
		System.out.println(frac4);
		
		Fraction fractionCopy = new Fraction(frac3);
	}
}
