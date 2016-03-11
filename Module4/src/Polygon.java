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


}
