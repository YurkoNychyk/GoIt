import java.util.Map;
import java.util.Scanner;

/**
 * Created by home on 10.03.2016.
 */
public class Module4 {
    public static void main(String[] args) {

            switch (readInt("Виберіть фігуру, площу якої будем рахувати? (1: Коло, 2: Трикутник, 3: Прямокутник)",1)[0]) {

                case 1:
                    switch (readInt("Що ви знаєте про своє коло? 1: Радіус, 2: Координати центру і точки, що належить колу", 1)[0]) {
                        case 1:
                            //тут в метод розрахунку площі передається результат роботи метода зчитування. в метод зчитування передається повідомлення, яке має відображатися перед вводом
                            //і кількість елементів масиву з введеними користувачем числами, який поверне метод.
                            // В метод розрахунку площі передається об’єкт, який одразу і інстанціюється в списку аргументів однією з перегрузок свого конструктора.
                            //Тут використовується конструктор об’єкта "коло" в який передається примітив - значення довжини радіусу цього кола. Для розрахунку площі цього достатньо
                            System.out.println("У кола з таким радіусом площа буде " + ShapeAreaCalculator.calculateArea(new Circle(readInt("Окей. Який у вашого кола радіус в міліметрах?", 1)[0])) + " квадратних міліметрів");
                            break;
                        case 2:
                            //тут метод зчитування повертає масив з 4х елементів - координат точок центру та точки на колі.
                            //ці координати використовуються для конструкторів об’єктів двох точок. Ці дві точки використовуються для конструктора об’єкту відрізка, який в свою чергу передається в конструктор об’єкта кола
                            //у класу відрізка є метод getLength() який вирішує задачу розрахунку довжини відрізка по координатам двох точок. Ця довжина використовується при виводі в консоль значення радіусу,
                            //але в конструктор передається об’єкт відрізка, а не значення довжини відрізка, як в попередньому випадку
                            int[] circleCoordinates = new int[4];
                            circleCoordinates = readInt("Окей. Введіть координати центру A(x1,y1) та точки, що належить колу В(x2,y2) в такій послідовності через пробіл: x1 y1 x2 y2.", 4);
                            Line radius = new Line(circleCoordinates[0], circleCoordinates[1], circleCoordinates[2], circleCoordinates[3]);
                            System.out.println(
                                    "У кола з центром в точці А(" + circleCoordinates[0] + "," + circleCoordinates[1] + ") та радіусом " + radius.getLength() + "(mm)"
                                            + " площа рівна "
                                            + ShapeAreaCalculator.calculateArea(new Circle(radius))
                                            + " квадратних міліметрів");
                            break;
                        default:
                            System.out.println("Невірний вибір!"); //в разі якщо користувач ввів число, відмінне від 1 та 2
                    }

                case 2:
                    //трикутник та прямокутник -- це об’єкти одного класу Polygon
                    //відрізняються значенням довжини останньої сторони. у трикутника довжина четвертої сторони = 0. а координати четвертої точки співпадають з координатами 3ї (реалізується в конструкторі)
                    Polygon triangle = null;
                    switch (readInt("Виберіть спосіб задання трикутника. 1: Задати по точкам. 2: Задати по сторонам", 1)[0]) {

                        case 1:
                            int[] triangleCoordinates = new int[6];
                            //метод зчитування повертає масив з 6 елементів -- координат точок трикутника
                            triangleCoordinates = readInt("Задайте координати точок в такій послідовності через пробіл x1 y1 x2 y2 x3 y3", 6);
                            //з них формуються три відрізки
                            Line side1 = new Line(new Point(triangleCoordinates[0], triangleCoordinates[1]), new Point(triangleCoordinates[2], triangleCoordinates[3]));
                            Line side2 = new Line(new Point(triangleCoordinates[2], triangleCoordinates[3]), new Point(triangleCoordinates[4], triangleCoordinates[5]));
                            Line side3 = new Line(new Point(triangleCoordinates[4], triangleCoordinates[5]), new Point(triangleCoordinates[0], triangleCoordinates[1]));
                            //з відрізків формується трикутник
                            triangle = new Polygon(side1, side2, side3);
                            break;
                        case 2:
                            int[] triangleSides = new int[3];
                            triangleSides = readInt("Задайте довжини сторін через пробіл", 3);
                            side1 = new Line(triangleSides[0]);
                            side2 = new Line(triangleSides[1]);
                            side3 = new Line(triangleSides[2]);
                            triangle = new Polygon(side1, side2, side3);
                            break;
                        default:
                            System.out.println("Невірний вибір!");
                    }
                    //перевірка замкнутості периметру трикутника
                    if (polygonExist(triangle)) {
                        System.out.println("Площа трикутника рівна " + ShapeAreaCalculator.calculateArea(triangle) + " квадратних міліметрів");
                    } else {
                        System.out.println("Такого трикутника не існує!");
                        triangle = null; //заклинання для виклику прибиральника :)
                    }break;
                case 3:
                    Polygon rectangle = null;
                    switch (readInt("Виберіть спосіб задання трикутника. 1: Задати по точкам. 2: Задати по сторонам", 1)[0]) {

                        case 1:
                            int[] rectangleCoordinates = new int[8];
                            rectangleCoordinates = readInt("Задайте координати точок в такій послідовності через пробіл x1 y1 x2 y2 x3 y3", 8);

                            Line side1 = new Line(new Point(rectangleCoordinates[0], rectangleCoordinates[1]), new Point(rectangleCoordinates[2], rectangleCoordinates[3]));
                            Line side2 = new Line(new Point(rectangleCoordinates[2], rectangleCoordinates[3]), new Point(rectangleCoordinates[4], rectangleCoordinates[5]));
                            Line side3 = new Line(new Point(rectangleCoordinates[4], rectangleCoordinates[5]), new Point(rectangleCoordinates[6], rectangleCoordinates[7]));
                            Line side4 = new Line(new Point(rectangleCoordinates[6], rectangleCoordinates[7]), new Point(rectangleCoordinates[0], rectangleCoordinates[1]));
                            rectangle = new Polygon(side1, side2, side3, side4);
                            break;
                        case 2:
                            int[] triangleSides = new int[4];
                            triangleSides = readInt("Задайте довжини сторін через пробіл", 4);
                            side1 = new Line(triangleSides[0]);
                            side2 = new Line(triangleSides[1]);
                            side3 = new Line(triangleSides[2]);
                            side4 = new Line(triangleSides[3]);
                            rectangle = new Polygon(side1, side2, side3, side4);
                            break;
                        default:
                            System.out.println("Невірний вибір!");
                    }
                    if (polygonExist(rectangle)) {
                        System.out.println("Площа прямокутника рівна " + ShapeAreaCalculator.calculateArea(rectangle) + " квадратних міліметрів");
                    } else {
                        System.out.println("Такого прямокутника не існує!");
                        rectangle = null;
                    }
                    
                    
            }
    }

    public static int[] readInt(String welcomeString, int argsNumber) {
        //Метод для зчитування чисел з консолі. не відстане доки користувач не введе числа
        while (true) {
            try {
                int[] args = new int[argsNumber];
                System.out.println(welcomeString);
                //BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                //return Integer.parseInt(consoleReader.readLine());
                Scanner consoleReader = new Scanner(System.in);
                for (int i = 0; i < argsNumber; i++) {
                    args[i] = consoleReader.nextInt();
                }
                return args;
            } catch (Exception E) {
                System.out.println("Помилка вводу!");
            }
        }
    }

    public static boolean polygonExist(Polygon polygon) {
        //Метод для перевірки можливості замкнути периметр. Для цього треба щоб довжина будь-якої сторони була менша за суму довжин інших сторін
        double maxSide = Math.max(Math.max(polygon.side1.getLength(),polygon.side2.getLength()), Math.max(polygon.side3.getLength(),polygon.side4.getLength() ));
        double perimeter = polygon.side1.getLength() + polygon.side2.getLength() +  polygon.side3.getLength() + polygon.side4.getLength();
        //також перевіряється чи існує взагалі об’єкт
        if (polygon == null ) {
            return false;
        }
        //щоб не перевіряти всі достатньо перевірити чи менша довжина найдовшої сторони за суму довжин інших сторін (сума інших сторін розраховується як різниця периметру і найдовшої сторони)
        else if (maxSide < (perimeter - maxSide)){

            if (polygon.getSideNumber() == 3) {
                return true;
            }
            else
                if ( (polygon.side1.getLength() == polygon.side3.getLength() ) && ( polygon.side4.getLength() == polygon.side2.getLength() ) ) {
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

