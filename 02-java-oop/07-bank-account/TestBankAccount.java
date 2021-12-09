public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        BankAccount c = new BankAccount();
        BankAccount.getAccounts();
        b.depositAccount(1000, "checking");
        c.depositAccount(2000, "savings");
        System.out.println(b.getCheckingBalance());
        System.err.println(c.getSavingsBalance());
        b.printAccNum();
        c.printAccNum();
        b.withdrawAccount(2000, "checking");
        System.out.println(b.getCheckingBalance());
        

    }
}
