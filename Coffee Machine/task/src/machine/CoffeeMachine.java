package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine {
    public static void printState(int money, int water, int milk, int beans, int cups) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }


    public static void menu(int money, int water, int milk, int beans, int cups) {
        Scanner stringScan = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = stringScan.nextLine();
        switch (input) {
            case "buy":
                buy(money, water, milk, beans, cups);
                return;
            case "fill":
                fill(money, water, milk, beans, cups);
                return;
            case "take":
                take(money, water, milk, beans, cups);
                return;
            case "remaining":
                remaining(money, water, milk, beans, cups);
            case "exit":
                System.exit(0);

        }

    }

    public static void buy(int money, int water, int milk, int beans, int cups) {
        Scanner intScan = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
        String buyInput = intScan.next();
        ArrayList<String> missingList = new ArrayList<>();
        switch (buyInput) {
            case "1":
                //espresso
                if (water >= 250 && beans >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");

                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                    menu(money, water, milk, beans, cups);
                } else if (!(water >= 250)) {
                    missingList.add("water");
                }
                if (!(beans >= 16)) {
                    missingList.add("beans");
                }
                if (!(cups >= 1)) {
                    missingList.add("cup");
                }
                System.out.println("Sorry, not enough " + missingList.toString().replaceAll("\\[","").replaceAll("\\]",""));
                menu(money, water, milk, beans, cups);
            case "2":
                //latte
                if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                water -= 350;
                milk -= 75;
                beans -= 20;
                money += 7;
                cups -= 1;
                menu(money, water, milk, beans, cups);
                } else if (!(water >= 350)) {
                    missingList.add("water");
                }
                if (!(milk >= 75)) {
                    missingList.add("milk");
                }
                if (!(beans >= 20)) {
                    missingList.add("beans");
                }
                if (!(cups >= 1)) {
                    missingList.add("cup");
                }
                System.out.println("Sorry, not enough " + missingList.toString().replaceAll("\\[","").replaceAll("\\]",""));
                menu(money, water, milk, beans, cups);
            case "3":
                //cappuccino
                if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cups -= 1;
                menu(money, water, milk, beans, cups);
                } else if (!(water >= 200)) {
                    missingList.add("water");
                }
                if (!(milk >= 100)) {
                    missingList.add("milk");
                }
                if (!(beans >= 12)) {
                    missingList.add("beans");
                }
                if (!(cups >= 1)) {
                    missingList.add("cup");
                }
                System.out.println("Sorry, not enough " + missingList.toString().replaceAll("\\[","").replaceAll("\\]",""));
                menu(money, water, milk, beans, cups);
            case "back":
                menu(money, water, milk, beans, cups);
        }
    }

    public static void fill(int money, int water, int milk, int beans, int cups) {
        Scanner fillScan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        water += fillScan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += fillScan.nextInt();
        System.out.println("Write how many grams of beans you want to add: ");
        beans += fillScan.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += fillScan.nextInt();


        menu(money, water, milk, beans, cups);
    }

    public static void take(int money, int water, int milk, int beans, int cups) {
        System.out.println("I gave you $" + money);
        money = 0;


        menu(money, water, milk, beans, cups);
    }

    public static void remaining(int money, int water, int milk, int beans, int cups) {
        printState(money, water, milk, beans, cups);
        menu(money, water, milk, beans, cups);
    }

    public static void main(String[] args) {
        int money = 550;
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;

        menu(money, water, milk, beans, cups);

    }
}
