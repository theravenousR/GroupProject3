import java.util.ArrayList;

public class VendingMachine extends Coin {
    private double purchase;
    private double payment;
    private ArrayList<Products> cart = new ArrayList<>();
    private ArrayList<Products> itemList = new ArrayList<>();

    VendingMachine() {
        purchase = 0;
        payment = 0;
    }

    VendingMachine(double pr, double py) {
        purchase = pr;
        payment = py;
    }

    public void add(Products p) {
        itemList.add(p);
    }

    public boolean addCart(Products p) {
        if (p.getQuantity() > 0) {
            cart.add(p);
            p.downQuantity();
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Products> showProducts() {
        return itemList;
    }

    public void clear() {
        purchase = 0;
        payment = 0;
        itemList.clear();
    }

    public void recordPurchase(double amount) {
        purchase += amount;
    }

    public void receivePayment(int n, Coin c) {
        //System.out.println("Adding " + c.getValue());
        payment += (n *c .getValue());
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
        itemList.clear();
        return change;
    }
}
