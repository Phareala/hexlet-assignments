package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;
    private double square;
    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }
    public int getRadius() {
        return this.radius;
    }
    public double getSquare() throws NegativeRadiusException {
        this.square= Math.PI * Math.pow(radius, 2);
        if (this.radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return this.square;
    }
}
// END
