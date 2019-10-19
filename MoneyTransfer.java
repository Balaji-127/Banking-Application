import java.util.Scanner;

class MoneyTransfer extends BankAccount
{
    Scanner sc = new Scanner(System.in);
    void transferAmount() 
    {
        int newAccountNumber;
        System.out.println("Enter the account number to Transfer money");
        newAccountNumber = sc.nextInt();
        System.out.println("Enter the amount to Transfer");
        int transferAmount = sc.nextInt();
        if(BankAccount.balance - transferAmount < 5000)
        {
            System.out.println("Cannot transfer "+transferAmount);
            System.out.println("Maximum amount can be transferred is " + (BankAccount.balance - transferAmount));
        }
        else        
        System.out.println("Transferring "+transferAmount+" to Account Number "+newAccountNumber);
	}
}