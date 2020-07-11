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
	public static int calculateFee(float x, int amount) {
		return ((int) Math.round(x * dollarsToCents(amount)));
	}
	
	// Tests 1 - 16 for the method calculateTransferFee(…) 
	
	@Parameters
	public static Collection<Object[]> basisPathTests() {
		 return Arrays.asList(new Object[][] {
	         { 50,500,500,true,calculateFee(0.001f,50)},
	         { 50,500,1200,true,calculateFee(0.0005f,50)},
	         { 50,1200,500,true,calculateFee(0.005f,50)},
	         { 50,1200,1200,true,calculateFee(0.0025f,50)},
	         { 150,500,500,true,calculateFee(0.0005f,150)},
	         { 150,500,1200,true,calculateFee(0.00025f,150)},
	         { 150,1200,500,true,calculateFee(0.0025f,150)},
	         { 150,1200,1200,true,calculateFee(0.00125f,150)},
	         { 50,500,500,false,calculateFee(0.002f,50)},
	         { 50,500,1200,false,calculateFee(0.001f,50)},
	         { 50,1200,500,false,calculateFee(0.01f,50)},
	         { 50,1200,1200,false,calculateFee(0.005f,50)},
	         { 150,500,500,false,calculateFee(0.001f,150)},
	         { 150,500,1200,false,calculateFee(0.0005f,150)},
	         { 150,1200,500,false,calculateFee(0.005f,150)},
	         { 150,1200,1200,false,calculateFee(0.0025f,150)}
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
