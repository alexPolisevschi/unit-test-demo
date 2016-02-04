package ro.mindit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mindit.demo.dao.AccountDAO;
import ro.mindit.demo.domain.Employee;

/**
 * Created by Alex on 04.02.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private AccountDAO accountDAO;


    @Override
    public void receivePaycheck(Employee employee, int amount) {
        accountDAO.deposit(amount, employee.getAccountNo());
    }

    @Override
    public void shop(Employee employee, int amount) {
        accountDAO.withdraw(amount, employee.getAccountNo());
    }
}
