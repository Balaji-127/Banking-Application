import java.util.Scanner;

class ATM extends BankAccount
{
    Scanner sc = new Scanner(System.in);
    void deposit()
    {
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        if(amount > 20000)
            System.out.println("\nCannot deposit more than 20000");
        else
        {
            balance = BankAccount.balance + amount;
            System.out.println("\nDeposited : "+amount);
            System.out.println("The current balance is : "+balance);
        }
    }
    void withdraw()
    {
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        if(amount > 10000)
            System.out.println("\nMaximum Withdraw is 10000");
        else if(amount <= 0)
            System.out.println("\nEnter valid value");
        else if(BankAccount.balance - amount < 5000)
        {
            System.out.println("\nMinimum account balance must be 5000");
            System.out.println("\nBalance : "+BankAccount.balance);
            System.out.println("Maximum withdraw allowed is " + (BankAccount.balance - 5000));
        }
        else
        {
            balance = BankAccount.balance - amount;
            System.out.println("\nWithdrawn : "+amount);
            System.out.println("The current balance is : "+balance);
        }
    }
}