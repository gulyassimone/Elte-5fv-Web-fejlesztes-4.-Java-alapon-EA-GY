package hu.elte.bankapp.webdomain;

public class AccountView {
    private final int balance;
    private final String accountNumber;

    public AccountView(int balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
