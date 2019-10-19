import java.util.Scanner;

class MoneyTransfer extends BankAccount
{
    Scanner sc = new Scanner(System.in);
    void transferAmount() 
    {
        int newAccountNumber;
        System.out.print("Enter the Account Number to Transfer Money : ");
        newAccountNumber = sc.nextInt();
        System.out.print("Enter the amount to Transfer : ");
        int transferAmount = sc.nextInt();
        if(BankAccount.balance - transferAmount < 5000)
        {
            System.out.println("\nCannot transfer "+transferAmount);
            System.out.println("Balance : "+BankAccount.balance);
            System.out.println("Maximum amount can be transferred is " + (BankAccount.balance - 5000));
        }
        else  
        {
            System.out.println("\nTransferring "+transferAmount+" to Account Number "+newAccountNumber);
            BankAccount.balance -= transferAmount;
            System.out.println("Balance : "+BankAccount.balance);
        }      
	}
}