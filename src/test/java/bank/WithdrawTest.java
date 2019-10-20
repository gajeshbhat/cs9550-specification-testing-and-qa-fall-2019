package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WithdrawTest {

	public static int accountBalance;
	public static FeesCalculator WithdrawTestObj;
	public static int drawAmount,drawFee,expctedFee;
	
	@BeforeClass
	public static void initAccountDetails() {
		WithdrawTestObj = new FeesCalculator();
	}
	
	public static int getCentsFromDollars(int dollarAmount) {
		return dollarAmount*100;
	}
	
	
	/* Tests of Withdraw fee for student */
	
	@Before
	public void initAccountBalanceStudent(){
		accountBalance = getCentsFromDollars(10000);
	}
	
	// A transaction performed on the weekend by a student
	
	@Test
	public void testWithdrawalStudentWeekendSub0() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, -1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekendSub1() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 0);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekendSub2() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekendSub3() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 2);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekendSub4() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 7);
		assertEquals(expctedFee,drawFee);
	}
	
	// A transaction performed on the weekday by the student costing 0.1% of the withdraw amount
	
	@Test
	public void testWithdrawalStudentWeekdaySub0() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, -1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekdaySub1() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 0);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekdaySub2() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekdaySub3() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 2);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentWeekdaySub4() {
		
		drawAmount = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, true, 7);
		assertEquals(expctedFee,drawFee);
	}
	
	
	/* Tests of Withdraw fee for non students  */
	
	// A transaction performed by a non student on account with balance less than 1000
	
	@Test
	public void testWithdrawalLessSub0() {
		
		accountBalance = getCentsFromDollars(-1);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalLessSub1() {
		
		accountBalance = getCentsFromDollars(0);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalLessSub2() {
		
		accountBalance = getCentsFromDollars(999);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalLessSub3() {
		
		accountBalance = getCentsFromDollars(200);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalLessSub4() {

		accountBalance = getCentsFromDollars(500);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalLessSub5() {
		
		accountBalance = getCentsFromDollars(1000);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalLessSub6() {
		
		accountBalance = getCentsFromDollars(1001);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	// A transaction performed by a non student on account with balance between 1000 and 10K	
	
	@Test
	public void testWithdrawalBetweenSub0() {
		
		accountBalance = getCentsFromDollars(999);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	public void testWithdrawalBetweenSub1() {
		
		accountBalance = getCentsFromDollars(1000);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	public void testWithdrawalBetweenSub2() {
		
		accountBalance = getCentsFromDollars(1001);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	public void testWithdrawalBetweenSub3() {
		
		accountBalance = getCentsFromDollars(1200);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	public void testWithdrawalBetweenSub4() {
		
		accountBalance = getCentsFromDollars(5000);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	public void testWithdrawalBetweenSub5() {
		
		accountBalance = getCentsFromDollars(9999);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	public void testWithdrawalBetweenSub6() {
		
		accountBalance = getCentsFromDollars(10000);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	public void testWithdrawalBetweenSub7() {
		
		accountBalance = getCentsFromDollars(10001);
		drawAmount  = getCentsFromDollars(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		assertEquals(expctedFee,drawFee);
	}
	
	// A transaction performed by a non student on account with balance is more than 10K
	
	@Test
	
	public void testWithdrawalMoreSub0() {
		
		accountBalance = getCentsFromDollars(0);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	public void testWithdrawalMoreSub1() {
		
		accountBalance = getCentsFromDollars(200);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	public void testWithdrawalMoreSub2() {
		
		accountBalance = getCentsFromDollars(500);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	public void testWithdrawalMoreSub3() {
		
		accountBalance = getCentsFromDollars(9999);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalMoreSub4() {
		
		accountBalance = getCentsFromDollars(10000);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalMoreSub5() {
		
		accountBalance = getCentsFromDollars(10001);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalMoreSub6() {
		
		accountBalance = getCentsFromDollars(20000);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalMoreSub7() {
		
		accountBalance = getCentsFromDollars(50000);
		drawAmount  = getCentsFromDollars(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, false, 1);
		expctedFee = 0;
		assertEquals(expctedFee,drawFee);
	}

}
