package ro.mindit.demo.domain;

import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.AccountException;

/**
 * Created by Alex on 04.02.2016.
 */
public class EmployeeTest {

    private String TEST_EMPLOYEE_NAME = "cucu";

    private Employee testEmployee;


    @Before
    public void setUp() {
        testEmployee = new Employee(TEST_EMPLOYEE_NAME);
    }


    @Test
    public void afterCreationShouldHaveAName() {

    }

    @Test
    public void afterCreationShouldNotHaveAnAccount() {

    }

    @Test
    public void shouldNotAllowToAddMultipleAccounts() {

    }

}
