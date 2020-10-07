public class Products {
    private String name = "";
    private double price = 0;
    private int quantity = 0;

    Products() {}
    Products(String n, double p) {
        name = n;
        price = p;
        quantity += 1;
    }

    public void upQuantity() {
        quantity++;
    }

    public void downQuantity() {
        quantity--;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return price;
    }

    public void setName(String n) {
        name = n;
    }

    public void setValue(int v) {
        price = v;
    }

    public String toString () {
        return "Name: " + name + " Price: " + price;
    }
}
