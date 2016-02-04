package ro.mindit.demo.service;

import ro.mindit.demo.domain.Employee;

/**
 * Created by Alex on 04.02.2016.
 */
public interface EmployeeService {


    void receivePaycheck(Employee employee, int amount);

    void shop(Employee employee, int amount);

}
