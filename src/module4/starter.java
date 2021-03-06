package module4;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by home on 10.03.2016.
 */
public class Starter {
    public static void main(String[] args) {
        double celT;
        double farT;

            switch (ConsoleReader.readInt("Що будем рахувати? (1: Площу кола, 2: Площу трикутника, 3: Площу прямокутника, 4: Переводити С у F, 5: Переводити F у С)",1)[0]) {

                case 1:
                    switch (ConsoleReader.readInt("Що ви знаєте про своє коло? 1: Радіус, 2: Координати центру і точки, що належить колу", 1)[0]) {
                        case 1:
                            //тут в метод розрахунку площі передається результат роботи метода зчитування. в метод зчитування передається повідомлення, яке має відображатися перед вводом
                            //і кількість елементів масиву з введеними користувачем числами, який поверне метод.
                            // В метод розрахунку площі передається об’єкт, який одразу і інстанціюється в списку аргументів однією з перегрузок свого конструктора.
                            //Тут використовується конструктор об’єкта "коло" в який передається примітив - значення довжини радіусу цього кола. Для розрахунку площі цього достатньо
                            while (true)    {

                                try {
                                    Circle circle =  new Circle(ConsoleReader.readInt("Який у вашого кола радіус в міліметрах?", 1)[0]);
                                    System.out.println("У кола з таким радіусом площа буде " + circle.calculateArea() + " квадратних міліметрів\n");
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;
                        case 2:
                            //тут метод зчитування повертає масив з 4х елементів - координат точок центру та точки на колі.
                            //ці координати використовуються для конструкторів об’єктів двох точок. Ці дві точки використовуються для конструктора об’єкту відрізка, який в свою чергу передається в конструктор об’єкта кола
                            //у класу відрізка є метод getLength() який вирішує задачу розрахунку довжини відрізка по координатам двох точок. Ця довжина використовується при виводі в консоль значення радіусу,
                            //але в конструктор передається об’єкт відрізка, а не значення довжини відрізка, як в попередньому випадку

                            while (true)    {
                                try {
                                    int[] circleCoordinates = new int[4];
                                    circleCoordinates = ConsoleReader.readInt("Введіть координати центру A(x1,y1) та точки, що належить колу В(x2,y2) в такій послідовності через пробіл: x1 y1 x2 y2.", 4);
                                    Line radius = new Line(circleCoordinates[0], circleCoordinates[1], circleCoordinates[2], circleCoordinates[3]);
                                    Circle circle = new Circle(radius);
                                    System.out.println(
                                            "У кола з центром в точці А(" + circleCoordinates[0] + "," + circleCoordinates[1] + ") та радіусом " + radius.getLength() + "(mm)"
                                                    + " площа рівна "
                                                    + circle.calculateArea()
                                                    + " квадратних міліметрів");
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;

                        default:
                            System.out.println("Невірний вибір!"); //в разі якщо користувач ввів число, відмінне від 1 та 2
                    }
                    break;

                case 2:
                    //трикутник та прямокутник -- це об’єкти одного класу Polygon
                    //відрізняються значенням довжини останньої сторони. у трикутника довжина четвертої сторони = 0. а координати четвертої точки співпадають з координатами 3ї (реалізується в конструкторі)
                    Polygon triangle = null;
                    switch (ConsoleReader.readInt("Виберіть спосіб задання трикутника. 1: Задати по точкам. 2: Задати по сторонам", 1)[0]) {

                        case 1:
                            while (true)    {
                                try {
                                    int[] triangleCoordinates = new int[6];
                                    //метод зчитування повертає масив з 6 елементів -- координат точок трикутника
                                    triangleCoordinates = ConsoleReader.readInt("Задайте координати точок в такій послідовності через пробіл x1 y1 x2 y2 x3 y3", 6);
                                    //з них формуються три відрізки
                                    Line side1 = new Line(new Point(triangleCoordinates[0], triangleCoordinates[1]), new Point(triangleCoordinates[2], triangleCoordinates[3]));
                                    Line side2 = new Line(new Point(triangleCoordinates[2], triangleCoordinates[3]), new Point(triangleCoordinates[4], triangleCoordinates[5]));
                                    Line side3 = new Line(new Point(triangleCoordinates[4], triangleCoordinates[5]), new Point(triangleCoordinates[0], triangleCoordinates[1]));
                                    //з відрізків формується трикутник
                                    triangle = new Polygon(side1, side2, side3);
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;
                        case 2:

                            while (true)    {

                                try {
                                    int[] triangleSides = new int[3];
                                    triangleSides = ConsoleReader.readInt("Задайте довжини сторін через пробіл", 3);
                                    Line side1 = new Line(triangleSides[0]);
                                    Line side2 = new Line(triangleSides[1]);
                                    Line side3 = new Line(triangleSides[2]);
                                    triangle = new Polygon(side1, side2, side3);
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;
                        default:
                            System.out.println("Невірний вибір!");
                    }
                    //перевірка замкнутості периметру трикутника
                    try {
                        System.out.println("Площа трикутника рівна " + triangle.calculateArea() + " квадратних міліметрів");
                    }

                    catch (IllegalStateException e){
                        System.out.println("Такого трикутника не існує!");
                        System.err.println(e.getMessage());
                        triangle = null; //заклинання для виклику прибиральника :)
                    }

                    break;

                case 3:
                    Polygon rectangle = null;
                    switch (ConsoleReader.readInt("Виберіть спосіб задання прямокутника. 1: Задати по точкам. 2: Задати по сторонам", 1)[0]) {

                        case 1:
                            while (true)    {
                                try {
                                    int[] rectangleCoordinates = new int[8];
                                    rectangleCoordinates = ConsoleReader.readInt("Задайте координати точок в такій послідовності через пробіл x1 y1 x2 y2 x3 y3", 8);

                                    Line side1 = new Line(new Point(rectangleCoordinates[0], rectangleCoordinates[1]), new Point(rectangleCoordinates[2], rectangleCoordinates[3]));
                                    Line side2 = new Line(new Point(rectangleCoordinates[2], rectangleCoordinates[3]), new Point(rectangleCoordinates[4], rectangleCoordinates[5]));
                                    Line side3 = new Line(new Point(rectangleCoordinates[4], rectangleCoordinates[5]), new Point(rectangleCoordinates[6], rectangleCoordinates[7]));
                                    Line side4 = new Line(new Point(rectangleCoordinates[6], rectangleCoordinates[7]), new Point(rectangleCoordinates[0], rectangleCoordinates[1]));
                                    rectangle = new Polygon(side1, side2, side3, side4);
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;

                        case 2:
                            while (true)    {
                                try {
                                    int[] triangleSides = new int[4];
                                    triangleSides = ConsoleReader.readInt("Задайте довжини сторін через пробіл", 4);
                                    Line side1 = new Line(triangleSides[0]);
                                    Line side2 = new Line(triangleSides[1]);
                                    Line side3 = new Line(triangleSides[2]);
                                    Line side4 = new Line(triangleSides[3]);
                                    rectangle = new Polygon(side1, side2, side3, side4);

                                    try {
                                        System.out.println("Площа прямокутника рівна " + rectangle.calculateArea() + " квадратних міліметрів");
                                    }
                                    catch (IllegalStateException e){
                                        System.out.println("Такого прямокутника не існує!");
                                        rectangle = null;
                                    }
                                    break;
                                }
                                catch (IllegalStateException e) {
                                    System.out.println("Помилка вводу: "+ e.getMessage() + "\nДавайте ще раз:");
                                }
                            }
                            break;

                        default:
                            System.out.println("Невірний вибір!");
                    }

                    break;
                case 4:
                    celT = ConsoleReader.readInt("Введіть значення температури в градусах цельсія", 1)[0];
                    farT = TemperatureConvertor.convertToFarenheit(celT);
                    System.out.println(celT + " градусів цельсія = " + farT+ "градусів фаренгейта" );
                    break;
                case 5:
                    farT = ConsoleReader.readInt("Введіть значення температури в градусах фаренгейта", 1)[0];
                    celT = TemperatureConvertor.convertToCelcius(farT);
                    System.out.println(farT + " градусів фаренгейта = " + celT + "градусів цельсія" );
                    break;
                    
            }
    }
}

