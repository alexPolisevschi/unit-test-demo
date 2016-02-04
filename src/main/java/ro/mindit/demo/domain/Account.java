package ro.mindit.demo.domain;

import java.util.Random;

/**
 * Created by Alex on 04.02.2016.
 */
public class Account {

    private final int accountNo;

    private int balance;


    public Account() {
        Random ran = new Random();

        this.accountNo = ran.nextInt(100) + 5;
        this.balance = 0;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public int getAccountNo() {
        return accountNo;
    }

}
