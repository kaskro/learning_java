package lv.kaskro.learning.coffee_machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine("CoffeeMachine", 400, 540, 120, 9, 550);
        while (!machine.getState().toString().equals("EXIT")) {
            switch (machine.getState()) {
                case SELECTDRINK:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    machine.readAction(scanner.nextLine());
                    break;
                case ADDWATER:
                    System.out.println("Write how many ml of water do you want to add:");
                    machine.readAction(scanner.nextLine());
                    break;
                case ADDMILK:
                    System.out.println("Write how many ml of milk do you want to add:");
                    machine.readAction(scanner.nextLine());
                    break;
                case ADDBEANS:
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    machine.readAction(scanner.nextLine());
                    break;
                case ADDCUPS:
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    machine.readAction(scanner.nextLine());
                    break;
                default:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    machine.readAction(scanner.nextLine());
                    break;
            }
        }
    }
}
