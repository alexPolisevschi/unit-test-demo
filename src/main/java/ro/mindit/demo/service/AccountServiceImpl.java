package ro.mindit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mindit.demo.dao.AccountDAO;

/**
 * Created by Alex on 04.02.2016.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;


    @Override
    public void deposit(int amount, int accountNo) {
        accountDAO.deposit(amount, accountNo);
    }

    @Override
    public void withdraw(int amount, int accountNo) {
        accountDAO.withdraw(amount, accountNo);
    }
}
