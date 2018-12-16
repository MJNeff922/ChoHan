package chohan;

import java.util.Scanner;

public class ChoHan {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();
        Scanner sc = new Scanner(System.in);
        Scanner scNum = new Scanner(System.in);
        
        System.out.println(
        " _____  _   _ _____      _   _   ___   _   _ \n" +
        "/  __ \\| | | |  _  |    | | | | / _ \\ | \\ | |\n" +
        "| /  \\/| |_| | | | |    | |_| |/ /_\\ \\|  \\| |\n" +
        "| |    |  _  | | | |    |  _  ||  _  || . ` |\n" +
        "| \\__/\\| | | \\ \\_/ /    | | | || | | || |\\  |\n" +
        " \\____/\\_| |_/\\___/     \\_| |_/\\_| |_/\\_| \\_/");
        
        System.out.print("How much money would you like to start with? ");
        double money = scNum.nextDouble();
        
        while (money > 0) {
            System.out.print("Will the dice sum to odd or even? ");
            String pick = sc.nextLine();
            int pickValue = parse(pick);
           
            System.out.print("How much do you wish to bet on this? ");
            double bet = scNum.nextDouble();
            while (bet > money) {
                System.out.print("Bet too large, please input new bet: ");
                bet = scNum.nextDouble();
            }
        
            die1.roll();
            die2.roll();
            System.out.println("Die 1: " + die1.getNumDots() + " Die 2: " + die2.getNumDots());
            int total = die1.getNumDots() + die2.getNumDots();
        
            int result = processRoll(total);
            if (pickValue == result) {
                System.out.printf("You won $%3.2f!%n", (bet * 2));
                money += bet;
            }
            else {
                System.out.printf("You lost your bet of $%3.2f.%n", bet);
                money -= bet;
            }
            System.out.printf("You have $%3.2f remaining. Would you like to continue playing (Y/N)? ", money);
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.printf("%nYou finished with $%3.2f. Thanks for playing!", money);
    }
    
    public static int parse(String s) {
        if (s.equalsIgnoreCase("Even")) {
            return 1;
        }
        else if (s.equalsIgnoreCase("Odd")) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    public static int processRoll(int total) {
        switch(total) {
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                return 1;
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                return -1;
            default:
                return 0;
        }
    }
    
}
