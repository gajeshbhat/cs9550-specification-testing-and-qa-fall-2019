package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;

import bank.FeesCalculator;

import org.junit.Test;



public class FeesCalculatorTest {
	
	public static int accountBalance;
	public static FeesCalculator FeesTestObj;
	public static int drawAmount,drawFee,expctedFee;
	public static int amountDeposit,depositInterest,expectedIntrest;
	
	@BeforeClass
	public static void initAccountDetails() {
		FeesTestObj = new FeesCalculator();
	}
	
	/* Tests of Withdraw fee for student follow */
	
	@Before
	public void initAccountBalanceStudent(){
		accountBalance = 1000000;
	}
	
	@Test
	public void testWithdrawalStudentWeekend() {
		
		// A transaction performed on the weekend by a student
		drawAmount = 5000;
		expctedFee = 0;
		drawFee = FeesTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 7);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalStudentWeekday() {
		
		// A transaction performed on the weekday by the student costing 0.1% of the withdraw amount
		drawAmount = 10000;
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = FeesTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 3);
		assertEquals(expctedFee,drawFee);
	}

	
	
	/* Tests of Withdraw fee for non students follow */
	
	@Test
	public void testWithdrawalLess() {
		
		// A transaction performed by a non student on account with balance less than 1000
		accountBalance = 99999;
		drawAmount  = 1000;
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = FeesTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	
	@Test
	public void testWithdrawalMiddle() {
		
		// A transaction performed by a non student on account with balance between 1000 and 10K
		accountBalance = 100000;
		drawAmount  = 15000;
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = FeesTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	
	@Test
	public void testWithdrawalHigh() {
		
		// A transaction performed by a non student on account with balance between 1000 and 10K
		accountBalance = 1200000;
		drawAmount  = 10000;
		drawFee = FeesTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	/* Test Deposit */
	
	/* Tests of deposit interest for student deposit follow */
	
	@Test
	public void testDepositStudentHigh() {
		
		// A deposit of 100+$ performed by a student on account with balance more than 1000$ earns 1% interest
		accountBalance = 1200000;
		amountDeposit  = 15000;
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.01 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	@Test	
	public void testDepositStudentMedium() {
		
		// A deposit of 100+$ performed by a student on account with balance less than 1000$ earns 0.5% interest
		accountBalance = 99999;
		amountDeposit  = 15000;
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.005 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	@Test	
	public void testDepositStudentLess() {
		
		// A deposit of 100-$ performed by a student on account with balance more than 1000$ earns 0.5% interest
		accountBalance = 100000;
		amountDeposit  = 150;
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = (int)(0.005 * amountDeposit);
		assertEquals(expectedIntrest,depositInterest);
	}
	@Test	
	public void testDepositStudentLessNoInterest() {
		
		// A deposit of 100-$ performed by a student on account with balance less than 5000$ earns no interest
		accountBalance = 49999;
		amountDeposit  = 150;
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance, true);
		expectedIntrest = 0;
		assertEquals(expectedIntrest,depositInterest);
	}
	
	/* Tests of deposit interest for non student deposit follow */
	
}
