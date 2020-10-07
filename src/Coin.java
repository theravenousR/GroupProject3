public class Coin {
    private final double DOLLAR_VALUE = 1.00;
    private final double QUARTER_VALUE = 0.25;
    private final double DIME_VALUE = 0.10;
    private final double NICKEL_VALUE = 0.05;
    private final double PENNY_VALUE = 0.01;

    private double value = 0;
    private String name = "";
    int number = 0;

    Coin() {}

    Coin(int n, int c) {
        switch(n) {
            case 1:
                value += (c * DOLLAR_VALUE);
                break;
            case 2:
                value += (c * QUARTER_VALUE);
                break;
            case 3:
                value += (c * DIME_VALUE);
                break;
            case 4:
                value += (c * NICKEL_VALUE);
                break;
            case 5:
                value += (c * PENNY_VALUE);
                break;
        }
        value = (double)Math.round(value * 100) / 100;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public void setName(String n) {
        name = n;
    }

    public void setValue(int v) {
        value = v;
    }

    public String toString () {
        return "Name: " + name + " Value: " + value;
    }
}
