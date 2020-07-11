package bank;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DepositTest {
	

	public static int accountBalance;
	public static FeesCalculator depositTestObj;
	public static int depositAmount;
	public static double actualFees,expectedFees; 

	public int dollarsToCents(int x) {
		return (x*100);
	}
	
	public double centsToDollars(double x) {
		return (x/100);
	}
	@BeforeClass
	public static void initAccountDetails() {
		depositTestObj = new FeesCalculator();
	}

	
	@Test
	public void testWR1() {
		depositAmount = dollarsToCents(50);
		accountBalance = dollarsToCents(500);
		boolean student = true;
		actualFees = depositTestObj.calculateDepositInterest(depositAmount, accountBalance, student);
		actualFees = centsToDollars(actualFees);
		expectedFees = centsToDollars((double) (0 * depositAmount));
		assertEquals(expectedFees,actualFees,0);
	}
	
	@Test
	public void testWR2() {
		depositAmount = dollarsToCents(250);
		accountBalance = dollarsToCents(2500);
		boolean student = false;
		actualFees = depositTestObj.calculateDepositInterest(depositAmount, accountBalance, student);
		actualFees = centsToDollars(actualFees);
		expectedFees = centsToDollars((double) (0 * depositAmount));
		assertEquals(expectedFees,actualFees,0);
	}
	
	@Test
	public void testWR3() {
		depositAmount = dollarsToCents(27500);
		accountBalance = dollarsToCents(7500);
		boolean student = true;
		actualFees = depositTestObj.calculateDepositInterest(depositAmount, accountBalance, student);
		actualFees = centsToDollars(actualFees);
		expectedFees = centsToDollars((double) (0.01 * depositAmount));
		assertEquals(expectedFees,actualFees,0);
	}
	
	@Test (expected = Exception.class)
	public void testWR4() {
		depositAmount = dollarsToCents(-50);
		accountBalance = dollarsToCents(50000);
		boolean student = false;
		actualFees = depositTestObj.calculateDepositInterest(depositAmount, accountBalance, student);
		actualFees = centsToDollars(actualFees);
		expectedFees = centsToDollars((double) (0.005 * depositAmount));
	}
	
	@Test (expected = Exception.class)
	public void testWR5() {
		depositAmount = dollarsToCents(60000);
		accountBalance = dollarsToCents(3000);
		boolean student = true;
		actualFees = depositTestObj.calculateDepositInterest(depositAmount, accountBalance, student);
		actualFees = centsToDollars(actualFees);
		expectedFees = centsToDollars((double) (0.01 * depositAmount));
	}

}
