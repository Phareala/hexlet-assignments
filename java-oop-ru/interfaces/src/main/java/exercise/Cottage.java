package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floors;
    public Cottage(double area, int floors) {
        this.area = area;
        this.floors = floors;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        String result = this.floors + " этажный коттедж площадью " + this.area + " метров";
        return result;
    }
}
// END
