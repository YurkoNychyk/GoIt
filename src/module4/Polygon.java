package module4;
/**
 * Created by home on 10.03.2016.
 */
//трикутник та прямокутник -- це об’єкти одного класу Polygon
//відрізняються значенням довжини останньої сторони. у трикутника довжина четвертої сторони = 0. а координати четвертої точки співпадають з координатами 3ї (реалізується в конструкторі)
public class Polygon {

    private int sideNumber;

    public int getSideNumber() {
        return sideNumber; //число сторін багатокутника
    }

    public void setSideNumber(int sideNumber) {
        this.sideNumber = sideNumber;
    }


    Line side1;
    Line side2;
    Line side3;
    Line side4;

    public Polygon() {
        this.side1 = new Line(0);
        this.side2 = new Line(0);
        this.side3 = new Line(0);
        this.side4 = new Line(0);
        sideNumber=0;
    }

    public Polygon(Line side1, Line side2, Line side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = new Line(0);
        sideNumber = 3;
    }
    public Polygon(Point a, Point b, Point c) {
        this.side1 = new Line(a,b);
        this.side3 = new Line(c,a);
        this.side2 = new Line(b,c);
        this.side4 = new Line(c,c);
        sideNumber = 3;
    }
    public Polygon(Line side1, Line side2, Line side3, Line side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        sideNumber = 4;
    }
    public Polygon(Point a, Point b, Point c, Point d) {
        this.side1 = new Line(a,b);
        this.side2 = new Line(b,c);
        this.side3 = new Line(c,d);
        this.side4 = new Line(d,a);
        sideNumber = 4;
    }

    public double calculateArea(){
        if (polygonExist()) {
            if (this.side4.getLength() == 0) {
                //розрахунок половини периметру трикутника
                double p = (this.side1.getLength() + this.side2.getLength() + this.side3.getLength()) / 2;
                // sqrt(p* (p-side1)*(p-side2)*(p-side3))
                return Math.sqrt(p * (p - this.side1.getLength()) * (p - this.side2.getLength()) * (p - this.side3.getLength()));
            }
            else {
                //розрахунок площі прямокутника
                return this.side1.getLength()*this.side2.getLength();
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public boolean polygonExist() {
        //Метод для перевірки можливості замкнути периметр. Для цього треба щоб довжина будь-якої сторони була менша за суму довжин інших сторін
        double maxSide = Math.max(Math.max(this.side1.getLength(),this.side2.getLength()), Math.max(this.side3.getLength(),this.side4.getLength() ));
        double perimeter = this.side1.getLength() + this.side2.getLength() +  this.side3.getLength() + this.side4.getLength();

        //щоб не перевіряти всі достатньо перевірити чи менша довжина найдовшої сторони за суму довжин інших сторін (сума інших сторін розраховується як різниця периметру і найдовшої сторони)
         if (maxSide < (perimeter - maxSide)){

            if (this.getSideNumber() == 3) {
                return true;
            }
            else
            if ( (this.side1.getLength() == this.side3.getLength() ) && ( this.side4.getLength() == this.side2.getLength() ) ) {
                return true;
            }
            else {
                return false;
            }
        }
        else
            return false;
    }


}
