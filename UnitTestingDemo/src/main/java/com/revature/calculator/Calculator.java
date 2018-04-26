package main.java.com.revature.calculator;

public class Calculator {
	
	public Double add(String args) {
		Double sum = 0.0;
		if (args != null && !args.equals("")) {
			String[] numbers = args.split(",");
			for(String number : numbers) {
				sum += Double.parseDouble(number);
			}
		}
		return sum;
	}

}
