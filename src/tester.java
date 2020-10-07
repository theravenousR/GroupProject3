import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class tester {
    static VendingMachine candyInc = new VendingMachine();
    public static String options(){
        System.out.println("S)how Products I)nsert Coin B)uy A)dd Product R)emove Coins Q)uit");
        Scanner reader = new Scanner(System.in);
        System.out.println("Pick an option: ");
        String choice = reader.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        ArrayList<Products> productsList = new ArrayList<>();
        Products Coke = new Products("Coke", 1.25);
        Products Pepsi = new Products("Pepsi", 1.05);
        Products Lays = new Products("Lays", 1.50);
        Products Cheetos = new Products("Cheetos", 1.50);
        Products milkyWay = new Products("Milky Way", 1.15);
        Products rCCola = new Products("RC Cola", 0.95);
        Products Peanuts = new Products("Peanuts", 2.15);
        productsList.add(Coke);
        productsList.add(Pepsi);
        productsList.add(rCCola);
        productsList.add(Lays);
        productsList.add(Cheetos);
        productsList.add(Peanuts);
        productsList.add(milkyWay);
        Scanner reader = new Scanner(System.in);
        String pick = options();
        while (!pick.equalsIgnoreCase("Q")) {
            int currency = 0;
            int number = 0;
            int productSelect = 0;
            switch(pick.toLowerCase()) {
                case "s":
                    for (int x = 0; x < productsList.size(); x++) {
                        System.out.println(x+1);
                        System.out.println(productsList.get(x).getName());
                        System.out.println("$" + productsList.get(x).getValue());
                    }
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
                    Coin pay = new Coin(currency, number);
                    candyInc.receivePayment(new Coin(currency, number));
                    System.out.println("$" + candyInc.getPayment() + " added!");
                    break;
                case "b":
                    if (candyInc.getPurchase() > candyInc.getPayment()) {
                        System.out.println("Insufficient funds!");
                        System.out.println("You are short: " + "$" + (candyInc.getPayment() - candyInc.getPurchase()));
                    }
                    else {
                        System.out.println("Thank you for your purchase! Here is your change: " + "$" + candyInc.transaction());
                    }
                    break;
                case "a":
                    System.out.println("Select your product: ");
                    productSelect = (reader.nextInt() - 1);
                    candyInc.add(productsList.get(productSelect));
                    candyInc.makePurchase(productsList.get(productSelect).getValue());
                    System.out.println(productsList.get(productSelect).getName() + " added to cart!");
                    System.out.println("Your total is: " + "$" + candyInc.getPurchase());
                    break;
                case "r":
                    if (candyInc.getPayment() <= 0) {
                        System.out.println("No money added!");
                        break;
                    }
                    System.out.println("Returning your money in the amount of: " + "$" + candyInc.getPayment());
                    candyInc.clear();
                    break;
                case "q":
                    //
                    break;
            }
            pick = options();
        }

    }

}