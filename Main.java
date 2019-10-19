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