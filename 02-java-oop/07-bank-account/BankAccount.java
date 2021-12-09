import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {
    
    public long accNum(){
        ThreadLocalRandom a = ThreadLocalRandom.current();
        return a.nextLong(1000000000L, 9999999999L) ;
    }
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private static int numAccounts = 0;
    private static double totalCheckingBalance = 0;
    private static double totalSavingsBalance = 0;
    private long accountNumber = accNum();


    public BankAccount(){
        numAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void depositAccount(int amount, String account){
        if(account == "checking"){
            this.checkingBalance += amount;
            totalCheckingBalance += amount;
        }
        else{
            this.savingsBalance += amount;
            totalSavingsBalance += amount;
        }
    }
    
    public void withdrawAccount(int amount, String account){
        if(account == "checking" && this.checkingBalance > amount){
            this.checkingBalance -= amount;
            totalCheckingBalance -= amount;
        }
        else if(savingsBalance > amount){
            this.savingsBalance -= amount;
            totalSavingsBalance -= amount;
        }
        else{
            System.out.println("Insufficient Funds");
        }
    }

    public static void getAccounts(){
        System.out.printf("There are %d accounts.\n", numAccounts);
    }

    public void printAccNum() {
        System.out.printf("Your account number is: %d\n", this.accountNumber);
    }

    
    


}
