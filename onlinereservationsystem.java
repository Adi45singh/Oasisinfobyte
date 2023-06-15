package Oasisinfobyte;
import java.util.Scanner;
public class onlinereservationsystem
{
    private static boolean[] slots=new boolean[10];

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        while (true)
        {
            System.out.println("\n Please select a choice");
            System.out.println("1. View slot");
            System.out.println("2. Reserve slot");
            System.out.println("3. Cancel reservation");
            System.out.println("4. Exit");


            int choice= sc.nextInt();

            switch (choice)
            {
                case 1:
                    viewslot();
                    break;
                case 2:
                    reserveslot();
                    break;
                case 3:
                    cancelreservation();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("\n Invalid choice");
            }
        }
    }
    private static void viewslot()
    {
        System.out.println("\n Current slots");
        for (int i=0;i<slots.length;i++)
        {
            if (slots[i])
            {
                System.out.println("X ");
            }
            else
            {
                System.out.println((i+1)+" ");
            }
        }
        System.out.println();
    }
    private static void reserveslot()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter slots number (1-10) ");
        int slotsNumber=sc.nextInt();
        if(slotsNumber <1 || slotsNumber>10)
        {
            System.out.println("Invalid slots number");
        }
        else if (slots[slotsNumber-1])
        {
            System.out.println("Slot already reserved");
        }
        else
        {
            slots[slotsNumber-1]=true;
            System.out.println("Slot reserved!");
        }
    }
    private static void cancelreservation()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter slots number (1-10) ");
        int slotsNumber=sc.nextInt();
        if(slotsNumber <1 || slotsNumber>10)
        {
            System.out.println("Invalid slots number");
        }
        else if (slots[slotsNumber-1])
        {
            System.out.println("Slot already reserved");
        }
        else
        {
            slots[slotsNumber-1]=false;
            System.out.println("Slot canceled");
        }
    }
}
