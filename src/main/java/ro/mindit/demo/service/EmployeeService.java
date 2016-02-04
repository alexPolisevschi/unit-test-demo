package ro.mindit.demo.service;

import ro.mindit.demo.domain.Employee;
import ro.mindit.demo.domain.TestAccountException;

/**
 * Created by Alex on 04.02.2016.
 */
public interface EmployeeService {


    void receivePaycheck(Employee employee, int amount) throws TestAccountException;

    void shop(Employee employee, int amount) throws TestAccountException;

}
