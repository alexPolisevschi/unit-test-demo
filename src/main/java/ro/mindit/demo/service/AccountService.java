package ro.mindit.demo.service;

/**
 * Created by Alex on 04.02.2016.
 */
public interface AccountService {

    void deposit(int amount, int accountNo);

    void withdraw(int amount, int accountNo);
}
