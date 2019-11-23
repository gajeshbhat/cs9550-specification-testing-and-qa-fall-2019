package bank;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class TransferTest {

	public static int fromAccountBalance,toAccountBalance;
	public static FeesCalculator transferTestObj;
	public static int transferAmount,expectedFees,actualFees;
	
	public int dollarsToCents(int x) {
		return (x*100);
	}
	
	public double centsToDollars(double x) {
		return (x/100);
	}
	@BeforeClass
	public static void initAccountDetails() {
		transferTestObj = new FeesCalculator();
	}
	
	@Test
	public void transferTestRule1() {
		transferAmount = dollarsToCents(40);
		fromAccountBalance = dollarsToCents(920);
		toAccountBalance = dollarsToCents(310);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.001*transferAmount);
		assertEquals(actualFees,expectedFees);	
	}
	
	@Test
	public void transferTestRule2() {
		transferAmount = dollarsToCents(60);
		fromAccountBalance = dollarsToCents(350);
		toAccountBalance = dollarsToCents(1810);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule3() {
		transferAmount = dollarsToCents(55);
		fromAccountBalance = dollarsToCents(1350);
		toAccountBalance = dollarsToCents(540);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule4() {
		transferAmount = dollarsToCents(99);
		fromAccountBalance = dollarsToCents(1000);
		toAccountBalance = dollarsToCents(2900);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0025*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule5() {
		transferAmount = dollarsToCents(700);
		fromAccountBalance = dollarsToCents(550);
		toAccountBalance = dollarsToCents(999);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule6() {
		transferAmount = dollarsToCents(100);
		fromAccountBalance = dollarsToCents(800);
		toAccountBalance = dollarsToCents(2300);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.00025*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule7() {
		transferAmount = dollarsToCents(1500);
		fromAccountBalance = dollarsToCents(2000);
		toAccountBalance = dollarsToCents(300);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0025*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule8() {
		transferAmount = dollarsToCents(350);
		fromAccountBalance = dollarsToCents(5000);
		toAccountBalance = dollarsToCents(10000);
		boolean student = true;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.00125*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule9() {
		transferAmount = dollarsToCents(45);
		fromAccountBalance = dollarsToCents(300);
		toAccountBalance = dollarsToCents(750);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.002*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule10() {
		transferAmount = dollarsToCents(99);
		fromAccountBalance = dollarsToCents(760);
		toAccountBalance = dollarsToCents(1001);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.001*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule11() {
		transferAmount = dollarsToCents(10);
		fromAccountBalance = dollarsToCents(4500);
		toAccountBalance = dollarsToCents(800);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.01*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule12() {
		transferAmount = dollarsToCents(25);
		fromAccountBalance = dollarsToCents(2000);
		toAccountBalance = dollarsToCents(1500);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule13() {
		transferAmount = dollarsToCents(101);
		fromAccountBalance = dollarsToCents(900);
		toAccountBalance = dollarsToCents(10);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.001*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule14() {
		transferAmount = dollarsToCents(15000);
		fromAccountBalance = dollarsToCents(400);
		toAccountBalance = dollarsToCents(2600);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule15() {
		transferAmount = dollarsToCents(2000);
		fromAccountBalance = dollarsToCents(30000);
		toAccountBalance = dollarsToCents(300);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.005*transferAmount);
		assertEquals(actualFees,expectedFees);
	}
	
	@Test
	public void transferTestRule16() {
		transferAmount = dollarsToCents(1100);
		fromAccountBalance = dollarsToCents(2500);
		toAccountBalance = dollarsToCents(9500);
		boolean student = false;
		actualFees = transferTestObj.calculateTransferFee(transferAmount, fromAccountBalance, toAccountBalance, student);
		expectedFees = (int) Math.round(0.0025*transferAmount);
		assertEquals(actualFees,expectedFees);
	}

}
