package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;
    public Flat(double area, double balconyArea, int floors) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floors;
    }

    @Override
    public double getArea() {
        double result = this.area + this.balconyArea;
        return result;
    }

    @Override
    public String toString() {
        String result = "Квартира площадью " + getArea() + " метров на " + this.floor + " этаже";
        return result;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        }
        return -1;
    }
}
// END
