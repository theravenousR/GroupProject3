public class Coin {

    private double value = 0;
    private String name = "";
    int number = 0;

    Coin() {}

    Coin(double aV, String aN) {
        value = aV;
        name = aN;
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
