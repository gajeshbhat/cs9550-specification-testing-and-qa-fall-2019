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
public class TransferBasisPath {
	
	public static FeesCalculator transferTestObj;
	public static int actualFees;
	
	public static int dollarsToCents(int x) {
		return (x*100);
	}
	
	@BeforeClass
	public static void initAccountDetails() {
		transferTestObj = new FeesCalculator();
	}
	
	// Tests 1 - 16 for the method calculateTransferFee(…) 
	
	@Parameters
	public static Collection<Object[]> basisPathTests() {
		 return Arrays.asList(new Object[][] {
	         { 50,500,500,true,((int) Math.round(0.001f * dollarsToCents(50)))},
	         { 50,500,1200,true,((int) Math.round(0.0005f * dollarsToCents(50)))},
	         { 50,1200,500,true,((int) Math.round(0.005f * dollarsToCents(50)))},
	         { 50,1200,1200,true,((int) Math.round(0.0025f * dollarsToCents(50)))},
	         { 150,500,500,true,((int) Math.round(0.0005f * dollarsToCents(150)))},
	         { 150,500,1200,true,((int) Math.round(0.00025f * dollarsToCents(150)))},
	         { 150,1200,500,true,((int) Math.round(0.0025f * dollarsToCents(150)))},
	         { 150,1200,1200,true,((int) Math.round(0.00125f * dollarsToCents(150)))},
	         { 50,500,500,false,((int) Math.round(0.002f * dollarsToCents(50)))},
	         { 50,500,1200,false,((int) Math.round(0.001f * dollarsToCents(50)))},
	         { 50,1200,500,false,((int) Math.round(0.01f * dollarsToCents(50)))},
	         { 50,1200,1200,false,((int) Math.round(0.005f * dollarsToCents(50)))},
	         { 150,500,500,false,((int) Math.round(0.001f * dollarsToCents(150)))},
	         { 150,500,1200,false,((int) Math.round(0.0005f * dollarsToCents(150)))},
	         { 150,1200,500,false,((int) Math.round(0.005f * dollarsToCents(150)))},
	         { 150,1200,1200,false,((int) Math.round(0.0025f * dollarsToCents(150)))}
	      });
	}
	
	@Parameter(0)
	public int transferAmount;
	
	@Parameter(1)
	public int fromAccountBalance;
	
	@Parameter(2)
	public int toAccountBalance;
	
	@Parameter(3)
	public boolean isStudent;
	
	@Parameter(4)
	public int expectedFees;

	@Test
	public void testTransfer() {
		actualFees = Math.round(transferTestObj.calculateTransferFee(dollarsToCents(transferAmount), dollarsToCents(fromAccountBalance), dollarsToCents(toAccountBalance), isStudent));
		assertEquals(actualFees,expectedFees);
		
	}

}
