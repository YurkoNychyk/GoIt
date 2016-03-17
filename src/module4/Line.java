package module4;
/**
 * Created by home on 11.03.2016.
 */
//Клас відрізка. може конструюватися по двом точкам або по 4м координатам
//має метод отримання довжини відрізка
public class Line {
    private Point a = null;
    private Point b = null;
    private Double length = null;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    public Line (int x1, int y1, int x2, int y2) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }
    public Line(double length) {
        this.length = length;
    }

    public void setA(int x, int y) {
        a = new Point(x, y);
    }
    public void setB(int x, int y) {
        b = new Point(x, y);
    }

    //отрмання довжини відрізка
    public double getLength() {
        if (length == null) {
            length = Math.sqrt(Math.pow( (double)b.getX() - (double)a.getX(),2 ) +  Math.pow( (double)b.getY() - (double)a.getY(),2 ));
            return length;
        }
        else {
            if (length <= 0 )
            {
                //System.out.println("Line length must be >0");
                throw new IllegalStateException("Довжина має бути > 0!", null);
            }
            return length;
        }

    }


}
