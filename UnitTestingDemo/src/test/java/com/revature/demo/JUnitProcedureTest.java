package test.java.com.revature.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//@Ignore //will skip all tests
public class JUnitProcedureTest {

	// execute once, before all tests
	@BeforeClass
	public static void beforeClass() {
		System.out.println("in beforeClass");
	}

	// execute once, after all tests
	@AfterClass
	public static void afterClass() {
		System.out.println("in afterClass");
	}

	// execute before each test
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
	}

	// execute after each test
	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}

	@Ignore
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}

	@Test
	public void testCase2() {
		System.out.println("in testCase2");
	}

}
