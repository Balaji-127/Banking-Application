import java.util.Random;
import java.util.Scanner;
import java.io.Console;

class BankAccount
{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Console console = System.console();
    protected static int balance;
    private String securityQuestion;
    private String securityAnswer;
    private int accountNumber;
    private String pin, id;
    private String name; 
    void createAccount()
    {
        System.out.print("\nEnter name : ");
        name = sc.next();
        System.out.print("Enter ID : ");
        id = sc.next();
        pin = new String(console.readPassword("Enter PIN : "));
        sc.nextLine();
        System.out.print("Enter your security question : ");
        securityQuestion = sc.nextLine();
        System.out.print("Enter your security Answer : ");
        securityAnswer = sc.next();
        System.out.println("\nGenerating Account Number\n");
        accountNumber = rand.nextInt(1000);
        System.out.println("Your Account Number is "+ accountNumber);
        System.out.print("\nEnter Initial Balance : ");
        balance = sc.nextInt();
        System.out.println("\nYour Balance is : "+balance);
    }
    void login()
    {
        String uid,upin;
        System.out.println("\n\tLOGIN");

        System.out.print("Reset Password? (y/Y) : ");
        char changePassword = sc.next().charAt(0);
        if(changePassword == 'y' || changePassword == 'Y')
        {
            System.out.println(securityQuestion);
            System.out.print("Enter the answer : ");
            String passwordAnswer = sc.next();
            if(passwordAnswer.equals(securityAnswer))
            {
                String newPass = new String(console.readPassword("Enter New PIN : "));
                pin = newPass;
                System.out.println("\nPIN Updated");
            }
            else
            {
                System.out.println("The Answer if Wrong");
                login();
            }
        }

        System.out.print("Enter ID : ");
        uid = sc.next();
        boolean flag = true;
        upin = new String(console.readPassword("Enter PIN : "));
        if(uid.equals(id) && upin.equals(pin))
        {
            System.out.println("\nLogin Successfull");
            while(flag)
            {
                System.out.println("\n1. ATM");
                System.out.println("2. Show Account Details");
                System.out.println("3. Update PIN");
                System.out.println("4. Money Transfer");
                System.out.println("5. Logout\n");
                System.out.print("Enter your choice : ");
                int choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        ATM atm = new ATM();
                        System.out.println("\n\tATM");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.print("\nEnter your choice : ");
                        int ch = sc.nextInt();
                        switch(ch)
                        {
                            case 1:
                                System.out.println("\n\tDEPOSIT");
                                atm.deposit();
                                break;
                            case 2:
                                System.out.println("\n\tWITHDRAW");
                                atm.withdraw();
                                break;
                            default:
                                System.out.println("\nEnter valid choice");
                        }
                        break;
                    case 2:
                        System.out.println("\n\tACCOUNT DETAILS");
                        System.out.println("Name : "+name);
                        System.out.println("Account Number : "+accountNumber);
                        System.out.println("ID : "+id);
                        System.out.println("Balance : "+balance);
                        break;
                    case 3:
                        String oldPass,newPass;
                        System.out.println("\n\tPIN UPDATE");
                        oldPass = new String(console.readPassword("Enter Old PIN : "));
                        if(oldPass.equals(pin))
                        {
                            newPass = new String(console.readPassword("Enter New PIN : "));
                            pin = newPass;
                            System.out.println("\nPIN Updated");
                            System.out.println("Login Again");
                            login();
                        }
                        else
                            System.out.println("\nOld Password is not correct");
                        break;
                    case 4:
                        MoneyTransfer transfer = new MoneyTransfer();
                        System.out.println("\n\tMONEY TRANSFER");
                        transfer.transferAmount();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nEnter a valid choice");

                }
            }
        }
        else
        {
            System.out.println("\nLogin Failed.");
            System.out.print("Try Again? y/Y : ");
            char c = sc.next().charAt(0);
            if(c=='y' || c=='Y')
                login();
        }
    }
}