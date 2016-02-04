package ro.mindit.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ro.mindit.demo.dao.AccountDAO;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Alex on 04.02.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    private static final int TEST_BALANCE = 1000;

    @Mock
    private AccountDAO mockedAccountDAO;


    private EmployeeServiceImpl employeeService;


    @Before
    public void init() {
        when(mockedAccountDAO.getBalance(anyInt())).thenReturn(TEST_BALANCE);

        //when(mockedAccountDAO.getBalance(anyInt())).thenThrow(new Exception());

        employeeService = new EmployeeServiceImpl();
        employeeService.setAccountDAO(mockedAccountDAO);
    }


    @Test
    public void testGetBalance() {
        int balance = employeeService.getAccountBalance(39);
        assertThat(balance, is(TEST_BALANCE));
    }

    @Test
    public void testWithSpy_whenCoditionFalse() {
        EmployeeServiceImpl spiedEmployeeService = spy(employeeService);

        doReturn(false).when(spiedEmployeeService).ceva();
        //doNothing().when(spiedEmployeeService).ceva();

        spiedEmployeeService.myMethod();
    }
}
