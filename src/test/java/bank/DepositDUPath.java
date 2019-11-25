package bank;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
public class DepositDUPath {
	
	public static FeesCalculator depositTestObj;
	public static int actualFees;
	
	public static int dollarsToCents(int x) {
		return (x*100);
	}
	
	@BeforeClass
	public static void initAccountDetails() {
		depositTestObj = new FeesCalculator();
	}
	public static int calculateFee(float x, int amount) {
		return ((int) Math.round(x * dollarsToCents(amount)));
	}
	
	// Tests 1 - 8 for the method calculateDepositInterest(…) 
	
	@Parameters
	public static Collection<Object[]> duPathTests() {
		 return Arrays.asList(new Object[][] {
	         {110,1100,true,calculateFee(0.01f,110)},
	         {110,900,true,calculateFee(0.005f,110)},
	         {90,5100,true,calculateFee(0.005f,90)},
	         {90,4900,true,calculateFee(0.0f,90)},
	         {510,5100,false,calculateFee(0.01f,510)},
	         {510,4900,false,calculateFee(0.005f,510)},
	         {490,11000,false,calculateFee(0.005f,490)},
	         {490,9000,false,calculateFee(0.0f,490)}
	      });
	}
	
	@Parameter(0)
	public int depositAmount;
	
	@Parameter(1)
	public int accountBalance;
	
	@Parameter(2)
	public boolean isStudent;
	
	@Parameter(3)
	public int expectedFees;

	@Test
	public void testDeposit() {
		actualFees = Math.round(depositTestObj.calculateDepositInterest(dollarsToCents(depositAmount),dollarsToCents(accountBalance),isStudent));
		assertEquals(actualFees,expectedFees);
		
	}

}
