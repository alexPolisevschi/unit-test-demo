package ro.mindit.demo.dao;

/**
 * Created by Alex on 04.02.2016.
 */
public interface AccountDAO {

    void deposit(int amount, int accountNo);

    void withdraw(int amount, int accountNo);

    int getBalance(int accountNo);
}
