package ro.mindit.demo.others;

/**
 * Created by Alex on 04.02.2016.
 */
public class PrimeNumberValidator {

    public boolean validate(final int primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
