package lv.kaskro.learning.coffee_machine;

public class Drink {
    final String name;
    final int amountOfWater;
    final int amountOfMilk;
    final int amountOfBeans;
    final int cupsNeeded;
    final int cost;

    public Drink(String name, int amountOfWater, int amountOfMilk, int amountOfBeans, int cupsNeeded, int cost) {
        this.name = name;
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfBeans = amountOfBeans;
        this.cupsNeeded = cupsNeeded;
        this.cost = cost;
    }
}

