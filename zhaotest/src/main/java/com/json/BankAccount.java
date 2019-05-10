package com.json;///////    BankAccount.java    ///////

/**
 *  * Superclass of bank account hierarchy.
 *  * @author Paul S. Wang
 *  
 */
public class BankAccount {
    public BankAccount() {
    }

    /**
     *  * Constructor.  Initializes a new account. 
     *  * @param id    BankAccount number
     *  * @param amt   Initial balance amount
     *  * @param ss    Social security number as string
     *  
     */
    public BankAccount(String id, String ss, double amt) {
        acct_no = id;
        owner = ss;
        acct_bal = (amt > 0) ? amt : 0.0;
    }

    /**
     *  * Retrieves the account balance. 
     *  * @return the <tt>balance</tt>
     *  
     */
    public double balance() {
        return acct_bal;
    }

    /**
     *  * Deposits into account. 
     *  * @param amt   the amount to deposit, if <tt>amt <=0</tt> no effect
     *  
     */
    public void deposit(double amt) {
        if (amt > 0)
            acct_bal += amt;
    }

    /**
     *  * Withdraw from account. 
     *  * @param amt    the amount to deposit
     *  * @return       <tt>false</tt> if <tt>amt <=0</tt>
     *  *               or insufficient balance
     *  
     */
    public boolean withdraw(double amt) {
        if (amt <= 0 || amt > acct_bal)
            return false;// failure
        acct_bal -= amt;
        return true;

    }

    protected String acct_no;// account number

    protected String owner;// owner ss no.

    private double acct_bal; // current balance
}