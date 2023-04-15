package exercise;

// BEGIN
public class Segment {

    private Point firstPoint;
    private Point secondPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getBeginPoint() {
        return  this.firstPoint;
    }

    public Point getEndPoint() {
        return  this.secondPoint;
    }

    public Point getMidPoint() {
        int middleX = (firstPoint.getX() + secondPoint.getX()) / 2;
        int middleY = (firstPoint.getY() + secondPoint.getY()) / 2;
        Point middlePoint = new Point(middleX, middleY);
        return middlePoint;
    }
}
// END
