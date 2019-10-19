import java.util.Scanner;

class ATM extends BankAccount
{
    Scanner sc = new Scanner(System.in);
    void deposit()
    {
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        balance = BankAccount.balance + amount;
        System.out.println("The current balance is : "+balance);
    }
    void withdraw()
    {
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        balance = BankAccount.balance - amount;
        System.out.println("The current balance is : "+balance);
    }
}