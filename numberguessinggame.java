package Oasisinfobyte;
import java.util.*;
public class numberguessinggame
{
    static ArrayList<Integer> scoreCard=new ArrayList<Integer>();
    public static void main(String args[])
    {
        numberguessinggame methodswap=new numberguessinggame();
        methodswap.menu(scoreCard);
    }
    public void menu(ArrayList<Integer>scoreCard)
    {
        numberguessinggame methodswap=new numberguessinggame();
        Scanner sc=new Scanner(System.in);
        System.out.println("--------(**)--------");
        System.out.println("Welcome to the number game");
        System.out.println("1. Play the game");
        System.out.println("2. View Scorecard");
        System.out.println("3. Exit the game");
        System.out.println("--------(**)--------");
        System.out.println("Which choice will you choose from the above");
        int menuChoice= sc.nextInt();
        switch (menuChoice)
        {
            case 1:
                System.out.println("\n Enter the number range:");
                int numberRange=sc.nextInt();
                int randomnumber=methodswap.randomnumber(numberRange);
                methodswap.guessnumber(randomnumber);
                break;
            case 2:
                methodswap.displayscoreCard();
                break;
            case 3:
                System.out.println("Thank you for playing......");
                System.exit(1);
                break;
            default:
                System.out.println("Wrong choice please tyr again");
        }
    }
    public int randomnumber(int numberRange)
    {
        Random ra=new Random();
        int randomnumber= ra.nextInt(numberRange);
        return randomnumber;
    }
    public void guessnumber(int randomnumber)
    {
        Scanner sc=new Scanner(System.in);
        int userguess;
        int guess=0;
        do {
            System.out.println("Enter the user guess");
            userguess=sc.nextInt();
            guess++;
            if (userguess>randomnumber)
            {
                System.out.println("Lower");
            }
            else if (userguess<randomnumber)
            {
                System.out.println("Higher");
            }
        }
        while (randomnumber != userguess);
        {
            System.out.println("");
            if (guess==1)
            {
                System.out.println("The answered number is right in "+guess+" try!");
            }
            else
            {
                System.out.println("The answered number is right in "+guess+" tries!");
            }
            scoreCard.add(guess);
            System.out.println("");
            menu(scoreCard);
        }
    }
    public void displayscoreCard()
    {
        System.out.println(".............");
        System.out.println("Score Card");
        System.out.println(".............");
        System.out.println("Your fastest game of recent is"+"\n");
        Collections.sort(scoreCard);
        for (Integer scores:scoreCard)
        {
            System.out.println("Finished the game in "+scores+" tries!");
        }
        System.out.println("");
        menu(scoreCard);
    }
}
