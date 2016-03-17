package module4;
/**
 * Created by home on 10.03.2016.
 */
public class Rectangle {
    private Line side1;
    private Line side2;
    private Line side3;
    private Line side4;

    public Rectangle() {
        this.side1 = new Line(1d);
        this.side2 = new Line(1d);
        this.side3 = new Line(1d);
        this.side4 = new Line(1d);
    }

    public Rectangle(Line side1, Line side2, Line side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Rectangle(Point a, Point b, Point c, Point d) {
        this.side1 = new Line(a,b);
        this.side3 = new Line(c,a);
        this.side2 = new Line(b,c);
    }
}
