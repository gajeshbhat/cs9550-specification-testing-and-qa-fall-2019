package bank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DepositTest.class, SessionTest.class, TransferTest.class, WithdrawTest.class })
public class AllTests {

}
