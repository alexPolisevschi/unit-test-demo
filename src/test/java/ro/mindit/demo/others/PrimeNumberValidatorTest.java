package ro.mindit.demo.others;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 04.02.2016.
 */
@RunWith(Parameterized.class)
public class PrimeNumberValidatorTest {

    private int inputNumber;
    private boolean expectedResult;

    private PrimeNumberValidator primeNumberValidator;

    @Before
    public void setUp() {
        primeNumberValidator = new PrimeNumberValidator();
    }


    @Parameterized.Parameters
    public static Collection primeNumbers() {

        System.out.println("primeNumbers() is called");

        return Arrays.asList(new Object[][] {
                { 2, true },
                { 6, false },
                { 19, true },
                { 22, false },
                { 23, true },
                { 61, true },
                { 10000, false }
        });
    }


    public PrimeNumberValidatorTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }


    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parametrized number is : " + inputNumber);
        assertEquals(expectedResult, primeNumberValidator.validate(inputNumber));
    }

}