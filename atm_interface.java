package Oasisinfobyte;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class bankAccount {
    static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("..........");
        System.out.println("Enter your name:");
        atm_interface.name = sc.nextLine();
        System.out.println("Enter User name:");
        String usern = sc.nextLine();
        System.out.println("Enter Password:");
        String passw = sc.nextLine();
        System.out.println("Enter bank account number:");
        atm_interface.accn = sc.nextLine();
        System.out.println("..........");
        atm_interface.pro();
        while (true)
        {
            display(atm_interface.name);
            int option = sc.nextInt();
            if (option==1)
            {
                login(usern,passw);
                break;
            }
            else
            {
                if (option==2)
                {
                    System.exit(0);
                }
                else
                {
                    System.out.println("Try again later...............");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String usern,String passw){}
}
class transanction
{
    static void withdraw()
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("..........");
        System.out.println("Enter amount of money to withdraw:");
        int cashw= sc.nextInt();
        if(cashw<=atm_interface.balance)
        {
            atm_interface.balance=atm_interface.balance-cashw;
            atm_interface.history.add(Integer.toString(cashw));
            atm_interface.history.add("Withdraw");
            System.out.println("Amount of "+cashw+"/- withdrawn successfully");
            System.out.println("..........");
        }
        else
        {
            System.out.println("Insufficient balance");
            System.out.println("..........");
        }
        atm_interface.pro();
    }
    static void deposit()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("..........");
        System.out.println("Enter amount of money to deposit:");
        int dcash= sc.nextInt();
        atm_interface.updatebalance(dcash);
        atm_interface.history.add(Integer.toString(dcash));
        atm_interface.history.add("Deposit");
        System.out.println("Amount of Rs."+dcash+"/- deposited");
        System.out.println("..........");
        atm_interface.pro();
    }
    static void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving side:");
        String r=sc.nextLine();
        System.out.println("Enter the account number of receiving side:");
        int numr= sc.nextInt();
        System.out.println("Enter the amount of money to be transferred:");
        int casht= sc.nextInt();
        if (casht<=atm_interface.balance)
        {
            atm_interface.balance=atm_interface.balance-casht;
            atm_interface.history.add(Integer.toString(casht));
            atm_interface.history.add("Transfer");
            System.out.println("Amount of Rs."+casht+"/- transferred successfully");
            System.out.println("..........");
        }
        else
        {
            System.out.println("Insufficient balance to transfer");
            System.out.println("..........");
        }
    }
}
class ch
{
    static void chbalance()
    {
        System.out.println("..........");
        System.out.println("The available balance in the bank account:");
        atm_interface.shbalance();
        System.out.println("..........");
        atm_interface.pro();
    }
}
class his
{
    static void transactionhis()
    {
        System.out.println("..........");
        System.out.println("Transaction history");
        int a=0;
        if (atm_interface.balance>0)
        {
            for (int i=0;i<(atm_interface.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.println(atm_interface.history.get(a)+"");
                    a++;
                }
                System.out.println("..........");
            }
        }
        else
        {
            System.out.println("Your account is empty");
        }
        atm_interface.pro();
    }
}
public class atm_interface
{
    public static String name;
    public static int balance=0;
    public static String accn;
    public static ArrayList<String> history =new ArrayList<String>();

    static void updatebalance(int dcash)
    {
        balance=balance+dcash;
    }
    static void shbalance()
    {
        System.out.println(balance);
    }
    public static void interfacce() {
        System.out.println("237467823429");
        Scanner sc = new Scanner(System.in);
        System.out.println("..........");
        System.out.println("Welcome to an Interface");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter your option:");
        int option = sc.nextInt();
        if (option == 1) {
            bankAccount.register();
        } else {
            if (option == 2) {
                System.exit(0);
            } else {
                System.out.println("Try again later");
                interfacce();
            }
        }
    }
    static void pro()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to "+atm_interface.name+" account");
        System.out.println("..........");
        System.out.println("Please choose an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction history");
        System.out.println("6. Exit");
        System.out.println("Enter your option:");
        int option= sc.nextInt();
        switch (option)
        {
            case 1:
                transanction.withdraw();
            case 2:
                transanction.deposit();
            case 3:
                transanction.transfer();
            case 4:
                ch.chbalance();
            case 5:
                his.transactionhis();
            case 6:
                System.exit(0);
        }
    }
    public static void main(String args[])
    {
        interfacce();
    }
}