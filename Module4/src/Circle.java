/**
 * Created by home on 10.03.2016.
 */
public class Circle {

    private Line radius;

    public Circle(int radius) {
        this.radius = new Line(radius);
    }

    public Circle(Line radius) {
        this.radius = radius;
    }

    public double getRadius () {
        return radius.getLength();
    }

}
