import java.util.Random;
import java.util.Scanner;
import java.io.Console;

class BankAccount
{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Console console = System.console();
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
        pin = new String(console.readPassword("Enter PIN : "));
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
        upin = new String(console.readPassword("Enter PIN : "));
        if(uid.equals(id) && upin.equals(pin))
        {
            System.out.println("Login Successfull");
            System.out.println("1. ATM");
            System.out.println("2. Show Account Details");
            System.out.println("3. Update PIN");
            System.out.println("4. Money Transfer");
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
                    oldPass = new String(console.readPassword("Enter PIN : "));
                    if(oldPass.equals(pin))
                    {
                        newPass = new String(console.readPassword("Enter PIN : "));
                        pin = newPass;
                    }
                    else
                        System.out.println("Old Password is not correct");
                    break;
                case 4:
                    MoneyTransfer transfer = new MoneyTransfer();
                    transfer.transferAmount();
                    break;

            }
            
        }
        else
        {
            System.out.println("Login Failed");
        }
    }
}