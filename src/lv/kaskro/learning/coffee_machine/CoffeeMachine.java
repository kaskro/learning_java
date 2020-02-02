package lv.kaskro.learning.coffee_machine;

public class CoffeeMachine {
    public enum State {
        IDLE,
        SELECTDRINK,
        ADDWATER,
        ADDMILK,
        ADDBEANS,
        ADDCUPS,
        TAKE,
        REMAINING,
        EXIT
    }

    final String name;
    int waterInStock;
    int milkInStock;
    int beansInStock;
    int cupsInStock;
    int moneyInStock;
    State machineState = State.IDLE;
    final Drink espresso = new Drink("Espresso", 250, 0, 16, 1, 4);
    final Drink latte = new Drink("Latte", 350, 75, 20, 1, 7);
    final Drink cappuccino = new Drink("Cappuccino", 200, 100, 12, 1, 6);

    public CoffeeMachine(String name, int waterInStock, int milkInStock, int beansInStock, int cupsInStock, int moneyInStock) {
        this.name = name;
        this.waterInStock = waterInStock;
        this.milkInStock = milkInStock;
        this.beansInStock = beansInStock;
        this.cupsInStock = cupsInStock;
        this.moneyInStock = moneyInStock;
    }

    public void readAction(String action) {
        switch (this.machineState) {
            case ADDWATER:
                try {
                    this.waterInStock += this.convertToPositiveInt(action);
                    this.machineState = State.ADDMILK;
                } catch (Exception ignored) {
                }
                break;
            case ADDMILK:
                try {
                    this.milkInStock += this.convertToPositiveInt(action);
                    this.machineState = State.ADDBEANS;
                } catch (Exception ignored) {
                }
                break;
            case ADDBEANS:
                try {
                    this.beansInStock += this.convertToPositiveInt(action);
                    this.machineState = State.ADDCUPS;
                } catch (Exception ignored) {
                }
                break;
            case ADDCUPS:
                try {
                    this.cupsInStock += this.convertToPositiveInt(action);
                    this.machineState = State.IDLE;
                } catch (Exception ignored) {
                }
                break;
            case SELECTDRINK:
                switch (action) {
                    case "1":
                        if (canBuyDrink(espresso)) {
                            this.makeDrink(espresso);
                        }
                        this.machineState = State.IDLE;
                        break;
                    case "2":
                        if (canBuyDrink(latte)) {
                            this.makeDrink(latte);
                        }
                        this.machineState = State.IDLE;
                        break;
                    case "3":
                        if (canBuyDrink(cappuccino)) {
                            this.makeDrink(cappuccino);
                        }
                        this.machineState = State.IDLE;
                        break;
                    case "back":
                        this.machineState = State.IDLE;
                        break;
                }
        }
        switch (action) {
            case "buy":
                this.machineState = State.SELECTDRINK;
                break;
            case "fill":
                this.machineState = State.ADDWATER;
                break;
            case "take":
                this.takeMoneyFromMachine();
                this.machineState = State.TAKE;
                break;
            case "remaining":
                this.displayMachineStatus();
                this.machineState = State.REMAINING;
                break;
            case "exit":
                this.machineState = State.EXIT;
                break;
        }
    }

    private int convertToPositiveInt(String number) {
        return Integer.parseInt(number) < 0 ? (Integer.parseInt(number) * -1) : Integer.parseInt(number);
    }

    private boolean notEnough(int inStock, int needed) {
        return inStock - needed < 0;
    }

    public State getState() {
        return this.machineState;
    }

    private boolean canBuyDrink(Drink drink) {
        if (this.notEnough(this.waterInStock, drink.amountOfWater)) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (this.notEnough(this.milkInStock, drink.amountOfMilk)) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (this.notEnough(this.beansInStock, drink.amountOfBeans)) {
            System.out.println("Sorry, not enough beans!");
            return false;
        } else if (this.notEnough(this.cupsInStock, drink.cupsNeeded)) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    private void makeDrink(Drink drink) {
        this.waterInStock -= drink.amountOfWater;
        this.milkInStock -= drink.amountOfMilk;
        this.beansInStock -= drink.amountOfBeans;
        this.cupsInStock -= drink.cupsNeeded;
        this.moneyInStock += drink.cost;
    }

    private void takeMoneyFromMachine() {
        System.out.println("I gave you $" + moneyInStock);
        this.moneyInStock = 0;
    }

    private void displayMachineStatus() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.waterInStock + " of water");
        System.out.println(this.milkInStock + " of milk");
        System.out.println(this.beansInStock + " of coffee beans");
        System.out.println(this.cupsInStock + " of disposable cups");
        System.out.println("$" + this.moneyInStock + " of money");
        System.out.println();
    }
}
