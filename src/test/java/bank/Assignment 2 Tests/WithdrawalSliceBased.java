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
public class WithdrawalSliceBased {
	
	public static FeesCalculator withdrawalTestObj;
	public static int actualFees;
	
	public static int dollarsToCents(int x) {
		return (x*100);
	}
	
	@BeforeClass
	public static void initAccountDetails() {
		withdrawalTestObj = new FeesCalculator();
	}
	public static int calculateFee(float x, int amount) {
		return ((int) Math.round(x * dollarsToCents(amount)));
	}
	// Tests 1 - 6 for the method calculateWithdrawalFee(…) 
	
	@Parameters
	public static Collection<Object[]> sliceBasedTests() {
		 return Arrays.asList(new Object[][] {
	         {500,500,true,7,calculateFee(0.0f,500)},
	         {500,500,true,1,calculateFee(0.0f,500)},
	         {500,500,true,2,calculateFee(0.001f,500)},
	         {500,500,false,1,calculateFee(0.002f,500)},
	         {500,5000,false,2,calculateFee(0.001f,500)},
	         {500,50000,false,3,calculateFee(0.0f,500)}
	      });
	}
	
	@Parameter(0)
	public int transferAmount;
	
	@Parameter(1)
	public int accountBalance;
	
	@Parameter(2)
	public boolean isStudent;
	
	@Parameter(3)
	public int dayOfWeek;
	
	@Parameter(4)
	public int expectedFees;

	@Test
	public void testWithdrawal() {
		actualFees = Math.round(withdrawalTestObj.calculateWithdrawalFee(dollarsToCents(transferAmount),dollarsToCents(accountBalance),isStudent,dayOfWeek));
		assertEquals(actualFees,expectedFees);
		
	}

}
