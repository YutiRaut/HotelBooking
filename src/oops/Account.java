package oops;

public class Account {

    public String accountHolderName;
    public String accountType;
    protected int balance;

    public void setBalance(int balance) throws Exception {
        if (balance < 0) {
            throw new Exception("Balance can not be less than zero");
        }
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
