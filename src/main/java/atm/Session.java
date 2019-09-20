/* * ATM Example system - file Session.java * * copyright (c) 2001 - Russell C. Bjork * */package atm;import atm.physical.CustomerConsole;import atm.transaction.Transaction;import banking.Card;import banking.Money;import banking.exceptions.InvalidAmountException;import banking.exceptions.InvalidPINException;import banking.exceptions.InvalidTransactionChoiceException;/** Representation for one ATM session serving a single customer. */public class Session {		/**	 * Constructor	 *	 * @param atm	 *            the ATM on which the session is performed	 */	public Session(ATM atm) {		this.atm = atm;		this.testing = false;		state = READING_CARD_STATE;	}	/**	 * Constructor	 *	 * @param atm	 *            the ATM on which the session is performed	 * @param amount 	 * @param to 	 * @param from 	 */	public Session(ATM atm, int cardID, String pin, int transactionChoice, int from, int to, Money amount) {		this.atm = atm;		this.cardID = cardID;		this.originalPIN = pin;		this.transactionChoice = transactionChoice;		this.from = from;		this.to = to;		this.amount = amount;		this.testing = true;		state = READING_CARD_STATE;	}	/**	 * Perform the Session Use Case	 * @throws InvalidPINException 	 * @throws InvalidAmountException 	 * @throws InvalidTransactionChoiceException 	 */	public void performSession() throws InvalidPINException, InvalidAmountException, InvalidTransactionChoiceException {		Card card = null;		Transaction currentTransaction = null;		while (state != FINAL_STATE) {			switch (state) {			case READING_CARD_STATE:				if (testing) {					card = atm.getCardReader().readCard(cardID);				} else {					card = atm.getCardReader().readCard();				}				if (card != null) {					System.out.println("Card inserted.");					state = READING_PIN_STATE;				} else {					atm.getCustomerConsole().display("Unable to read card");					System.out.println("Unable to read card");					state = EJECTING_CARD_STATE;				}				break;			case READING_PIN_STATE:				try {					if (testing) {						if (originalPIN.matches("[0-9]{3}"))							pin = Integer.parseInt(originalPIN);						else							throw new InvalidPINException();					} else {						pin = atm.getCustomerConsole().readPIN("Please enter your PIN\n" + "Then press ENTER");					}					System.out.println("PIN entered.");					state = CHOOSING_TRANSACTION_STATE;				} catch (CustomerConsole.Cancelled e) {					state = EJECTING_CARD_STATE;				}				break;			case CHOOSING_TRANSACTION_STATE:				try {					if (!testing) {						transactionChoice = atm.getCustomerConsole().readMenuChoice("Please choose transaction type",								TRANSACTION_TYPES_MENU);					}					currentTransaction = Transaction.makeTransaction(atm, this, card, pin, transactionChoice, testing);					if (currentTransaction == null)						throw new InvalidTransactionChoiceException();					System.out.println("Chosen Transaction:" + transactionChoice);					state = PERFORMING_TRANSACTION_STATE;				} catch (CustomerConsole.Cancelled e) {					state = EJECTING_CARD_STATE;				}				break;			case PERFORMING_TRANSACTION_STATE:				try {					boolean doAgain;					if (testing) {						doAgain = currentTransaction.performTransaction(from, to, amount);					} else {						doAgain = currentTransaction.performTransaction();					}										System.out.println("Transaction performed.");					if (doAgain)						state = CHOOSING_TRANSACTION_STATE;					else						state = EJECTING_CARD_STATE;				} catch (Transaction.CardRetained e) {					state = FINAL_STATE;				}				break;			case EJECTING_CARD_STATE:				try {					atm.getCardReader().ejectCard();					System.out.println("Ejecting card.");				} catch (Exception e) {					System.out.println(e.getMessage());				}				state = FINAL_STATE;				break;			}		}	}	/**	 * Change the pin recorded for the customer (if invalid pin extension was	 * performed by a transaction	 *	 * @param pin	 *            the newly entered pin	 */	public void setPIN(int pin) {		this.pin = pin;	}	// Instance variables	private boolean testing;	/**	 * The ATM on which the session is performed	 */	private ATM atm;	private int cardID;	/**	 * The PIN entered (or re-entered) by the customer	 */	private int pin;		private String originalPIN;	private int transactionChoice;		private int from;	private int to;	private Money amount;	/**	 * The current state of the session	 */	private int state;	// Possible values for state	/**	 * Reading the customer's card	 */	private static final int READING_CARD_STATE = 1;	/**	 * Asking the customer to enter a PIN	 */	private static final int READING_PIN_STATE = 2;	/**	 * Asking the customer to choose a transaction type	 */	private static final int CHOOSING_TRANSACTION_STATE = 3;	/**	 * Peforming a transaction	 */	private static final int PERFORMING_TRANSACTION_STATE = 4;	/**	 * Ejecting the customer's card	 */	private static final int EJECTING_CARD_STATE = 5;	/**	 * Session finished	 */	private static final int FINAL_STATE = 6;	/**	 * List of available transaction types to display as a menu	 */	private static final String[] TRANSACTION_TYPES_MENU = { "Withdrawal", "Deposit", "Transfer", "Balance Inquiry" };}