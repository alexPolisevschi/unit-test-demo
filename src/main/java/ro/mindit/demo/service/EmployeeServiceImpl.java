package ro.mindit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mindit.demo.dao.AccountDAO;
import ro.mindit.demo.domain.Employee;
import ro.mindit.demo.domain.TestAccountException;

/**
 * Created by Alex on 04.02.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private AccountDAO accountDAO;


    @Override
    public void receivePaycheck(Employee employee, int amount) throws TestAccountException {
        accountDAO.deposit(amount, employee.getAccountNo());
    }

    @Override
    public void shop(Employee employee, int amount) throws TestAccountException {
        accountDAO.withdraw(amount, employee.getAccountNo());
    }


    public int getAccountBalance(int accountNo) {
        return accountDAO.getBalance(accountNo);
    }


    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    public void myMethod() {

        if(ceva()) {
            System.out.println("a");
        } else {
            System.out.println("n");
        }
    }

    boolean ceva() {
        return true;
    }
}
