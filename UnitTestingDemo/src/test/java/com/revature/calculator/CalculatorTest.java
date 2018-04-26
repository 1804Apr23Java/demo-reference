package test.java.com.revature.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.revature.calculator.Calculator;

public class CalculatorTest {
	
	private Calculator c;
	
	/*
	 * Requirement: build a String calculator with a method which can add a 
	 * comma-separated list of 0,1, or 2 numbers
	 */
	
	@Before
	public void setCalc() {
		this.c = new Calculator();
	}
	
	@Test
	public void testEmptyStringReturnsZero() {
		double sum = c.add("");
		assertEquals(0,sum,.001);
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		double sum = c.add("12.9,15.3");
		assertEquals(28.2,sum,.001);
	}
	

	//could also check: more than two numbers throws exception
	//skip multiple commas, etc
}
