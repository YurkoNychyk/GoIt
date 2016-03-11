/**
 * Created by home on 11.03.2016.
 */

//перегружений метод для розрахунку площі кола та багатокутника
public class ShapeAreaCalculator {
    public static double calculateArea(Circle circle){
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }
    //проста перевірка чи ми маємо справу з трикутником чи з прямокутником
    public static double calculateArea(Polygon polygon){
        if (polygon.side4.getLength() == 0) {
            //розрахунок половини периметру трикутника
            double p = (polygon.side1.getLength() + polygon.side2.getLength() + polygon.side3.getLength()) / 2;
            // sqrt(p* (p-side1)*(p-side2)*(p-side3))
            return Math.sqrt(p * (p - polygon.side1.getLength()) * (p - polygon.side2.getLength()) * (p - polygon.side3.getLength()));
        }
        else {
            //розрахунок площі прямокутника
            return polygon.side1.getLength()*polygon.side2.getLength();
        }

    }

}
