import java.util.ArrayList;

public class VendingMachine extends Coin {
    private double purchase;
    private double payment;
    private ArrayList<Products> cart = new ArrayList<>();

    VendingMachine() {
        purchase = 0;
        payment = 0;
    }

    VendingMachine(double pr, double py) {
        purchase = pr;
        payment = py;
    }

    public void add(Products p) {
        cart.add(p);
    }

    public void clear() {
        purchase = 0;
        payment = 0;
        cart.clear();
    }

    public void recordPurchase(double amount) {
        purchase += amount;
    }

    public void receivePayment(Coin c) {
        //System.out.println("Adding " + c.getValue());
        payment += c.getValue();
    }

    public void makePurchase(double a) {
        purchase += a;
    }

    public double getPurchase() {
        return purchase;
    }

    public double getPayment() {
        return payment;
    }

    public double transaction() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        cart.clear();
        return change;
    }
}
