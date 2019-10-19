import java.util.Random;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) 
    {
        BankAccount customer = new BankAccount();
        boolean flag = true;
        customer.createAccount(); 
        while(flag)
        {
            customer.login();   
        }
    }
}

class BankAccount
{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    protected static int balance;
    private int accountNumber;
    private String pin, id;
    private String name; 
    void createAccount()
    {
        System.out.print("Enter name : ");
        name = sc.next();
        System.out.print("Enter ID : ");
        id = sc.next();
        System.out.print("Enter PIN : ");
        pin = sc.next();
        System.out.println("Generating accountNumber");
        accountNumber = rand.nextInt(1000);
        System.out.println("Your Account Number is "+ accountNumber);
        System.out.print("Enter initial balance : ");
        balance = sc.nextInt();
        System.out.println("Your Initial balance is : "+balance);
    }
    void login()
    {
        String uid,upin;
        System.out.println("Enter Login Credentials");
        System.out.print("Enter ID : ");
        uid = sc.next();
        System.out.print("Enter PIN : ");
        upin = sc.next();
        if(uid.equals(id) && upin.equals(pin))
        {
            ATM atm = new ATM();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    atm.deposit();
                    break;
                case 2:
                    atm.withdraw();
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
        else
        {
            System.out.println("Login Failed");
        }
    }
}