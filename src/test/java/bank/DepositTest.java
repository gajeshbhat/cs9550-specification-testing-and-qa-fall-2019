package bank;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.BeforeClass;

import bank.FeesCalculator;

public class DepositTest {
	
	public static int accountBalance;
	public static FeesCalculator FeesTestObj;
	public static int drawAmount,drawFee,expctedFee;
	public static int amountDeposit,depositInterest,expectedIntrest;
	
	@BeforeClass
	public static void initAccountDetails() {
		FeesTestObj = new FeesCalculator();
	}
	
	public static int getCentsFromDollars(int dollarAmount) {
		return dollarAmount*100;
	}
	
	// Student Client
	
	// A deposit of more than 100$ performed by a student with more than 1000$ Balance 
	
	@Test 
	public void testDepositStudentHighSub0() {
		
		accountBalance = getCentsFromDollars(1001);
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.01 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test
	public void testDepositStudentHighSub1() {
		
		accountBalance = getCentsFromDollars(500);
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.01 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test
	public void testDepositStudentHighSub2() {
		
		accountBalance = getCentsFromDollars(-200);
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.01 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	// A deposit of more than 100$ performed by a student on account with balance less than 1000$
	
	@Test	
	public void testDepositStudentMediumSub0() {
		
		accountBalance = getCentsFromDollars(500);;
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = Math.round(0.005f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositStudentMediumSub1() {
		
		accountBalance = getCentsFromDollars(1050);;
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.005 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositStudentMediumSub2() {
		
		accountBalance = getCentsFromDollars(-200);
		amountDeposit  = getCentsFromDollars(105);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.005 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	// A deposit of less than 100$ performed by a student on account with balance more than 5000$
	@Test	
	public void testDepositStudentLessInterestSub0() {
		
		accountBalance = getCentsFromDollars(5005);
		amountDeposit  = getCentsFromDollars(50);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = Math.round(0.005f * amountDeposit);;
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test
	public void testDepositStudentLessInterestSub1() {
		
		accountBalance = getCentsFromDollars(4000);
		amountDeposit  = getCentsFromDollars(50);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = Math.round(0.005f * amountDeposit);;
		assertEquals(expectedIntrest,depositInterest);
	}
	
	// A deposit of less than 100$ performed by a student on account with balance less than 5000$ - Bug
		
		@Test	
		public void testDepositStudentNoIntSub0() {
			
			accountBalance = getCentsFromDollars(4500);
			amountDeposit  = getCentsFromDollars(50);
			depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
			expectedIntrest = 0;
			assertEquals(expectedIntrest,depositInterest);
		}
		
		@Test	
		public void testDepositStudentNoIntSub1() {
		
		accountBalance = getCentsFromDollars(-100);
		amountDeposit  = getCentsFromDollars(50);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = 0;
		assertEquals(expectedIntrest,depositInterest);
		}
	
		@Test
		public void testDepositStudentNoIntSub2() {
			
			accountBalance = getCentsFromDollars(5005);
			amountDeposit  = getCentsFromDollars(50);
			depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
			expectedIntrest = 0;
			assertEquals(expectedIntrest,depositInterest);
		}
	
	
	
	/* Non Student Client */
		
	// A deposit of 500+$ performed by a non-student on account with balance more than 5000$ earns 1% interest
	@Test	
	public void testDepositNonStudentInterestSub0() {
		
		accountBalance = getCentsFromDollars(5005);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.01f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositNonStudentInterestSub1() {
		
		accountBalance = getCentsFromDollars(4500);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.01f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositNonStudentInterestSub2() {
		
		accountBalance = getCentsFromDollars(-100);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.01f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	// A deposit of 500+$ performed by a non-student on account with balance less than 5000$ earns 1% interest
	@Test	
	public void testDepositNonStudenLesstInterestSub0() {
		
		accountBalance = getCentsFromDollars(4500);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.005f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositNonStudenLesstInterestSub1() {
		
		accountBalance = getCentsFromDollars(-100);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.005f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	
	@Test	
	public void testDepositNonStudenLesstInterestSub2() {
		
		accountBalance = getCentsFromDollars(5500);
		amountDeposit  = getCentsFromDollars(505);
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = Math.round(0.005f * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
}
