/**
 * Created by home on 10.03.2016.
 */
public class Circle {

    private Line radius;
    //конструктор для створення об’єкту за допомогою значення довжини радіусу
    public Circle(int radius) {
        this.radius = new Line(radius);
    }
    //конструктор для створення об’єкту за допомогою відрізка
    public Circle(Line radius) {
        this.radius = radius;
    }

    public double getRadius () {
        return radius.getLength();
    }

}
