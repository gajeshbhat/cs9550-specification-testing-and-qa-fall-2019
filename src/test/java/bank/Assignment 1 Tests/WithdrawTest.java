package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WithdrawTest {
	
	public int dollarsToCents(int x) {
		return (x*100);
	}

	public static int accountBalance;
	public static FeesCalculator WithdrawTestObj;
	public static int drawAmount,drawFee,expctedFee,dayOfWeek;
	public static boolean student;
	
	@BeforeClass
	public static void initAccountDetails() {
		WithdrawTestObj = new FeesCalculator();
	}
	
	
	/* Tests of Withdraw fee for student */
	
	@Before
	public void initAccountBalanceStudent(){
		accountBalance = dollarsToCents(10000);
	}
	
	// Day of the week covers the entire range of values for the days
	
	@Test (expected = Exception.class)
	public void testWithdrawalStudentRWC1() {
		student = true;
		dayOfWeek = -1;
		drawAmount = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test (expected = Exception.class)
	public void testWithdrawalStudentRWC2() {
		student = true;
		dayOfWeek = 0;
		drawAmount = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test
	public void testWithdrawalStudentRWC3() {
		student = true;
		dayOfWeek = 1;
		drawAmount = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentRWC4() {
		student = true;
		dayOfWeek = 2;
		drawAmount = dollarsToCents(100);
		expctedFee = Math.round(drawAmount*0.001f);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	
	@Test
	public void testWithdrawalStudentRWC5() {
		student = true;
		dayOfWeek = 6;
		drawAmount = dollarsToCents(100);
		expctedFee = Math.round(drawAmount*0.001f);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student,dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalStudentRWC6() {
		student = true;
		dayOfWeek = 7;
		drawAmount = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test (expected = Exception.class)
	public void testWithdrawalStudentRWC7() {
		student = true;
		dayOfWeek = 8;
		drawAmount = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	
	/* Tests of Withdraw fee for non students  */
	
	// A transaction performed by a non student on account with balance less than 1000
	
	@Test (expected = Exception.class)
	public void testWithdrawalNonStudentRWC8() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(-1);
		drawAmount  = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test (expected = Exception.class)
	public void testWithdrawalNonStudentRWC9() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(0);
		drawAmount  = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test (expected = Exception.class)
	public void testWithdrawalNonStudentRWC10() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1);
		drawAmount  = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	
	@Test
	public void testWithdrawalNonStudentRWC11() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(500);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC12() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(999);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	
	@Test
	public void testWithdrawalNonStudentRWC13() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1000);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC14() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1001);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	// A transaction performed by a non student on account with balance between 1000 and 10000	
	
	@Test
	public void testWithdrawalNonStudentRWC15() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(999);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC16() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1000);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalNonStudentRWC17() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1001);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC18() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(1500);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalNonStudentRWC19() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(5000);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalNonStudentRWC20() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(9999);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalNonStudentRWC21() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(10000);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	@Test
	public void testWithdrawalNonStudentRWC22() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(10001);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	// A transaction performed by a non student on account with balance is more than 10K
	
	
	@Test (expected = Exception.class)
	public void testWithdrawalNonStudentRWC23() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(-1);
		drawAmount  = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test (expected = Exception.class)
	public void testWithdrawalNonStudentRWC24() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(0);
		drawAmount  = dollarsToCents(100);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC25() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(200);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.002 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC26() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(9999);
		drawAmount  = dollarsToCents(100);
		expctedFee = (int)(0.001 * drawAmount);
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC27() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(10000);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC28() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(10001);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC29() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(20000);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}
	
	@Test
	public void testWithdrawalNonStudentRWC30() {
		student = false;
		dayOfWeek = 2;
		accountBalance = dollarsToCents(50000);
		drawAmount  = dollarsToCents(100);
		expctedFee = 0;
		drawFee = WithdrawTestObj.calculateWithdrawalFee(drawAmount, accountBalance, student, dayOfWeek);
		assertEquals(expctedFee,drawFee);
	}

}
