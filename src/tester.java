import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class tester {

    public static String options(){
        System.out.println("S)how Products I)nsert Coin B)uy A)dd Product R)emove Coins Q)uit");
        Scanner reader = new Scanner(System.in);
        System.out.println("Pick an option: ");
        String choice = reader.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        VendingMachine candyInc = new VendingMachine();
        ArrayList<Coin> money = new ArrayList<>();
        String name = "";
        double price = 0;
        final Coin DOLLAR = new Coin(1.0, "Dollar");
        final Coin QUARTER = new Coin(0.25, "Quarter");
        final Coin DIME = new Coin(0.1, "Dime");
        final Coin NICKEL = new Coin(0.05, "Nickel");
        final Coin PENNY = new Coin(0.01, "Penny");
        money.add(DOLLAR);
        money.add(QUARTER);
        money.add(DIME);
        money.add(NICKEL);
        money.add(PENNY);
        Products Coke = new Products("Coke", 1.25);
        Products Pepsi = new Products("Pepsi", 1.05);
        Products Lays = new Products("Lays", 1.50);
        Products Cheetos = new Products("Cheetos", 1.50);
        Products milkyWay = new Products("Milky Way", 1.15);
        Products rCCola = new Products("RC Cola", 0.95);
        Products Peanuts = new Products("Peanuts", 2.15);
        candyInc.add(Coke);
        candyInc.add(Pepsi);
        candyInc.add(rCCola);
        candyInc.add(Lays);
        candyInc.add(Cheetos);
        candyInc.add(Peanuts);
        candyInc.add(milkyWay);
        Scanner reader = new Scanner(System.in);
        String pick = options();
        while (!pick.equalsIgnoreCase("Q")) {
            int currency = 0;
            int number = 0;
            int productSelect = 0;
            switch(pick.toLowerCase()) {
                case "s":
                    for (int x = 0; x < candyInc.showProducts().size(); x++) {
                        System.out.println("#" + (x+1));
                        System.out.println(candyInc.showProducts().get(x).getName());
                        System.out.println("$" + candyInc.showProducts().get(x).getValue());
                        System.out.println("Quantity: " + candyInc.showProducts().get(x).getQuantity());
                    }
                    System.out.println("Select your product: ");
                    productSelect = (reader.nextInt() - 1);
                    if (candyInc.addCart(candyInc.showProducts().get(productSelect))) {
                        candyInc.makePurchase(candyInc.showProducts().get(productSelect).getValue());
                        System.out.println(candyInc.showProducts().get(productSelect).getName() + " added to cart!");
                        System.out.println("Your total is: " + "$" + candyInc.getPurchase());
                    }
                    else {
                        System.out.println("Product is out of stock!");
                    }
                    reader.nextLine();
                    break;
                case "i":
                    System.out.println("What type of currency are you providing? Press the corresponding number:");
                    System.out.println("1)Dollar 2)Quarter 3) Dime 4)Nickel 5) Penny");
                    currency = reader.nextInt();
                    while (currency < 1 || currency >5) {
                        System.out.println("Enter a valid selection!");
                        currency = reader.nextInt();
                    }
                    System.out.println("How many are you providing?");
                    number = reader.nextInt();
                    while (number <= 0) {
                        System.out.println("Enter a valid amount!");
                        number = reader.nextInt();
                    }
                    candyInc.receivePayment(number, money.get(currency-1));
                    System.out.println("$" + candyInc.getPayment() + " is your total added!");
                    reader.nextLine();
                    break;
                case "b":
                    if (candyInc.getPurchase() > candyInc.getPayment()) {
                        System.out.println("Insufficient funds!");
                        System.out.println("You are short!");
                        System.out.println("Returning your money in the amount of: " + "$" + Math.round(candyInc.getPayment() * 100.0) / 100.0);
                        candyInc.clearPayment();

                    }
                    else {
                        System.out.println("Thank you for your purchase! Here is your change: " + "$" + Math.round(candyInc.transaction() * 100.0) / 100.0 );

                    }
                    break;
                case "a":

                    System.out.println("Enter the product name:");
                    name = reader.nextLine();
                    System.out.println("Enter the price:");
                    price = reader.nextDouble();
                    candyInc.add(new Products(name, price));
                    System.out.println("Product Added!");
                    reader.nextLine();
                    break;
                case "r":
                    if (candyInc.getSafe() <= 0) {
                        System.out.println("No money!");
                        break;
                    }
                    System.out.println("Removing " + "$" + candyInc.getSafe());
                    candyInc.clearSafe();
                    break;

                default:
                    break;
            }
            pick = options();
        }

    }

}