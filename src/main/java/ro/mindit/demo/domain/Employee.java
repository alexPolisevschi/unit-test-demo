package ro.mindit.demo.domain;

/**
 * Created by Alex on 04.02.2016.
 */
public class Employee {

    private String name;

    private Account account;



    public Employee(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public boolean isRich() {
        return true;
    }

    public boolean isInDebt() {
        if(account.getBalance() < 0) {
            return true;
        }
        return false;
    }

    public void addAccount(Account account) {
        this.account = account;
    }

    public int getAccountNo() throws TestAccountException{

        if(account == null) throw new TestAccountException("no account!");
        return account.getAccountNo();
    }




}
