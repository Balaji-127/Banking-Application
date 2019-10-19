import java.util.Random;
import java.util.Scanner;

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
            System.out.println("Login Successfull");
            System.out.println("1. ATM");
            System.out.println("2. Show Account Details");
            System.out.println("3. Update PIN");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    ATM atm = new ATM();
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.print("Enter your choice : ");
                    int ch = sc.nextInt();
                    switch(ch)
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
                    break;
                case 2:
                    System.out.println("Name : "+name);
                    System.out.println("Account Number : "+accountNumber);
                    System.out.println("ID : "+id);
                    System.out.println("Balance : "+balance);
                    System.out.println("");
                    break;
                case 3:
                    String oldPass,newPass;
                    System.out.println("Enter your old PIN : ");
                    oldPass = sc.next();
                    if(oldPass.equals(pin))
                    {
                        System.out.println("Enter your new PIN : ");
                        newPass = sc.next();
                        pin = newPass;
                    }
                    else
                        System.out.println("Old Password is not correct");

            }
            
        }
        else
        {
            System.out.println("Login Failed");
        }
    }
}