import java.util.Random;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) 
    {
        BankAccount customer = new BankAccount();customer.createAccount(); 
        customer.login();   
    }
}

class BankAccount
{
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int balance;
    int accountNumber;
    String pin, id;
    String name; 
    void createAccount()
    {
        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter ID : ");
        id = sc.nextLine();
        System.out.print("Enter PIN : ");
        pin = sc.nextLine();
        System.out.println("Generating accountNumber");
        accountNumber = rand.nextInt(500);
        System.out.println("Your Account Number is "+ accountNumber);
        System.out.print("Enter initial balance : ");
        balance = sc.nextInt();
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
            System.out.println("Login Successful");
        }
        else
        {
            System.out.println("Login Failed");
        }
    }
}