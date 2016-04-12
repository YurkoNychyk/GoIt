package module4;
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


    public double calculateArea(){
        if (this.getRadius() <= 0) {
            System.out.println("Radius must be >0");
            throw new IllegalStateException();
        }
        else    {
            return Math.PI * Math.pow(this.getRadius(), 2);
        }

    }

}
