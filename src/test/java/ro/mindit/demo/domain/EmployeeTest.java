package ro.mindit.demo.domain;

import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.AccountException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Alex on 04.02.2016.
 */
public class EmployeeTest {

    private static final String TEST_EMPLOYEE_NAME = "cucu";

    private Employee testEmployee;


    @Before
    public void setUp() {
        testEmployee = new Employee(TEST_EMPLOYEE_NAME);
    }


    @Test
    public void afterCreationShouldHaveAName() {
        assertThat(testEmployee.getName(), is(TEST_EMPLOYEE_NAME));
    }

    @Test(expected = TestAccountException.class)
    public void ifNoAccountThrowsException() throws TestAccountException {
        testEmployee.getAccountNo();
    }

    @Test
    public void ifNoAccountThrowsException2() {
        try {
            testEmployee.getAccountNo();
            fail("account should throw exception");
        } catch(TestAccountException e) {
            // success
        }
    }

    @Test
    public void afterCreationShouldNotHaveAnAccount() {

    }

    @Test
    public void shouldNotAllowToAddMultipleAccounts() {

    }

}
