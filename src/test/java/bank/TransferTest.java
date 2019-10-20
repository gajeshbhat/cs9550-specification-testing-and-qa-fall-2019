package bank;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TransferTest {

	public static int accountBalance;
	public static FeesCalculator FeesTestObj;
	public static int drawAmount,drawFee,expctedFee;
	public static int amountDeposit,depositInterest,expectedIntrest;
	
	@BeforeClass
	public static void initAccountDetails() {
		FeesTestObj = new FeesCalculator();
	}

	@Test
	public void testTrasnferStudentOne() {
		
		// A transfer of 500+$ performed by a non-student on account with balance more than 5000$ earns 1% interest
		accountBalance = 499999;
		amountDeposit  = 49000;
		depositInterest = FeesTestObj.calculateDepositInterest(amountDeposit,accountBalance,false);
		expectedIntrest = 0;
		assertEquals(expectedIntrest,depositInterest);
	}

}
