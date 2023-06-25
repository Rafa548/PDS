

public class BankAccountProxy implements BankAccount{
    private BankAccountImpl bankAccount;
    private String owner;
    private double balance;
    
    public BankAccountProxy(String owner, double balance) {
        this.bankAccount = new BankAccountImpl(owner, balance);
        this.owner = owner;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }
    
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return bankAccount.withdraw(amount);
        }
        throw new UnsupportedOperationException();
    }
    
    public double balance() {
        if (Company.user == User.OWNER) {
            return bankAccount.balance();
        }
        throw new UnsupportedOperationException();
    }
    
}
