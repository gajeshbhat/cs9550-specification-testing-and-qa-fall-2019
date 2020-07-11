package bank;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import atm.ATM;
import atm.Session;
import bank.BankDatabase.AccountNotFound;
import banking.Money;
import banking.exceptions.InvalidAmountException;
import banking.exceptions.InvalidPINException;
import banking.exceptions.InvalidTransactionChoiceException;
import simulation.Simulation;

public class SessionTest{
	
	String pins[] = {"123","1234","12345"};
	boolean pinValid[] = {false, true, false};
	
	int amount[] = {-1, 0, 20, 500, 980, 1000, 1020, 100, 120, 140, 150, 160, 180, 200};
	boolean amountValid[] = {false, true, true, true, true, true, false, true, true, true, true, true, true, true};
	
	//Testing for daily limit of 1000$. for this we are creating a new client with a daily limit of 1000$ and a balance of 5000$
	//this is tested for 100$. and it is passing
	@Test (expected = InvalidAmountException.class)
	public void withdrawalAmountTest1() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(-1);
		int userID = 123;
		String PIN = new String("123");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		session.performSession();
		
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 1;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 0;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void withdrawalAmountTest2() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(0);
		int userID = 123;
		String PIN = new String("123");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		session.performSession();
		
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 1;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 0;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void withdrawalAmountTest3() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(100);
		int userID = 123;
		String PIN = new String("123");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		session.performSession();
		
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 1;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 10000;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void withdrawalAmountTest4() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(980);
		int userID = 456;
		String PIN = new String("456");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		try{
			session.performSession();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 2;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 98000;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void withdrawalAmountTest5() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(1000);
		int userID = 456;
		String PIN = new String("456");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		session.performSession();
		
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 2;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 100000;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void withdrawalAmountTest6() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {
		Money withdrawalMoney = new Money(1020);
		int userID = 789;
		String PIN = new String("789");
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,userID,PIN,0,0,0,withdrawalMoney);
		Session session = new Session(atm, userID, PIN, 0, 0, 0, withdrawalMoney);
		session.performSession();
		
		//Checking database to see if withdrawal was successful
		AccountEntry account = null;
		BankDatabase database = BankDatabase.getInstance();
		try {
			int accountID = 3;		//Primary key in database
			int typeOfAccount = 0; 	//Checking Account
			account = database.getAccountInfo(accountID, typeOfAccount);
		} catch (AccountNotFound e) {
		}
		int withdrawal = account.getWithdrawals();
		int expectedWithdrawals = 0;
		assertEquals(expectedWithdrawals, withdrawal);
	}
	@Test
	public void Test1_1() throws InvalidTransactionChoiceException {
		Money money = new Money(-1);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}

	@Test
	public void Test1_2() throws InvalidTransactionChoiceException {
		Money money = new Money(0);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_3() throws InvalidTransactionChoiceException {
		Money money = new Money(20);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_4() throws InvalidTransactionChoiceException {
		Money money = new Money(500);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_5() throws InvalidTransactionChoiceException {
		Money money = new Money(980);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}

	@Test
	public void Test1_6() throws InvalidTransactionChoiceException {
		Money money = new Money(1000);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_7() throws InvalidTransactionChoiceException {
		Money money = new Money(1020);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_8() throws InvalidTransactionChoiceException {
		Money money = new Money(100);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_9() throws InvalidTransactionChoiceException {
		Money money = new Money(120);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_10() throws InvalidTransactionChoiceException {
		Money money = new Money(140);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_11() throws InvalidTransactionChoiceException {
		Money money = new Money(150);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_12() throws InvalidTransactionChoiceException {
		Money money = new Money(160);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_13() throws InvalidTransactionChoiceException {
		Money money = new Money(180);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test1_14() throws InvalidTransactionChoiceException {
		Money money = new Money(200);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"123",0,0,1,money);
		Session session = new Session(atm, 6789,"123",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
//	=================================================================================================================
	
	@Test
	public void Test2_1() throws InvalidTransactionChoiceException {
		Money money = new Money(-1);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}

	@Test
	public void Test2_2() throws InvalidTransactionChoiceException {
		Money money = new Money(0);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	@Test
	public void Test2_3() throws InvalidTransactionChoiceException {
		Money money = new Money(20);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_4() throws InvalidTransactionChoiceException {
		Money money = new Money(500);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_5() throws InvalidTransactionChoiceException {
		Money money = new Money(980);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}

	@Test
	public void Test2_6() throws InvalidTransactionChoiceException {
		Money money = new Money(1000);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_7() throws InvalidTransactionChoiceException {
		Money money = new Money(1020);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_8() throws InvalidTransactionChoiceException {
		Money money = new Money(100);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_9() throws InvalidTransactionChoiceException {
		Money money = new Money(120);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_10() throws InvalidTransactionChoiceException {
		Money money = new Money(140);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_11() throws InvalidTransactionChoiceException {
		Money money = new Money(150);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_12() throws InvalidTransactionChoiceException {
		Money money = new Money(160);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_13() throws InvalidTransactionChoiceException {
		Money money = new Money(180);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
	@Test
	public void Test2_14() throws InvalidTransactionChoiceException {
		Money money = new Money(200);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"1234",0,0,1,money);
		Session session = new Session(atm, 6789,"1234",0,0,1, money);
		boolean passed = true, passed1 = true;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = false;
		} catch (InvalidAmountException e) {
			passed1 = false;
		}
		assertTrue(passed & passed1);
	}
	
//	==================================================================================================================
	
	@Test
	public void Test3_1() throws InvalidTransactionChoiceException {
		Money money = new Money(-1);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}

	@Test
	public void Test3_2() throws InvalidTransactionChoiceException {
		Money money = new Money(0);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_3() throws InvalidTransactionChoiceException {
		Money money = new Money(20);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_4() throws InvalidTransactionChoiceException {
		Money money = new Money(500);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_5() throws InvalidTransactionChoiceException {
		Money money = new Money(980);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}

	@Test
	public void Test3_6() throws InvalidTransactionChoiceException {
		Money money = new Money(1000);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_7() throws InvalidTransactionChoiceException {
		Money money = new Money(1020);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_8() throws InvalidTransactionChoiceException {
		Money money = new Money(100);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_9() throws InvalidTransactionChoiceException {
		Money money = new Money(120);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_10() throws InvalidTransactionChoiceException {
		Money money = new Money(140);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_11() throws InvalidTransactionChoiceException {
		Money money = new Money(150);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_12() throws InvalidTransactionChoiceException {
		Money money = new Money(160);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_13() throws InvalidTransactionChoiceException {
		Money money = new Money(180);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
	
	@Test
	public void Test3_14() throws InvalidTransactionChoiceException {
		Money money = new Money(200);
		ATM atm = new ATM(0,"London","CIBC Branch",null,true,6789,"12345",0,0,1,money);
		Session session = new Session(atm, 6789,"12345",0,0,1, money);
		boolean passed = false, passed1 = false;
		try {
			session.performSession();
		} catch (InvalidPINException e) {
			passed = true;
		} catch (InvalidAmountException e) {
			passed1 = true;
		}
		assertTrue(passed | passed1);
	}
}