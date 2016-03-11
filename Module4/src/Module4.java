import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by home on 10.03.2016.
 */
public class Module4 {
    public static void main(String[] args) {


            switch (readInt ("Виберіть фігуру, площу якої будем рахувати? (1: Коло, 2: Трикутник, 3: Прямокутник)",1)[0]) {
                case 1:
                    switch (readInt("Що ви знаєте про своє коло? 1: Радіус, 2: Координати центру і точки, що належить колу",1)[0]) {
                        case 1:
                            System.out.println( "У кола з таким радіусом площа буде " + ShapeAreaCalculator.calculateArea( new Circle( readInt( "Окей. Який у вашого кола радіус в міліметрах?",1)[0])) + " квадратних міліметрів");
                            break;
                        case 2:
                            int[] circleCoordinates = new int[4];
                            circleCoordinates = readInt( "Окей. Введіть координати центру A(x1,y1) та точки, що належить колу В(x2,y2) в такій послідовності через пробіл: x1 y1 x2 y2.",4);
                            Line radius = new Line( circleCoordinates[0], circleCoordinates[1],circleCoordinates[2],circleCoordinates[3] );
                            System.out.println(
                                    "У кола з центром в точці А(" + circleCoordinates[0] + "," + circleCoordinates[1] + ") та радіусом " + radius.getLength() + "(mm)"
                                    + " площа рівна "
                                    + ShapeAreaCalculator.calculateArea( new Circle(radius) )
                                    + " квадратних міліметрів" );
                            break;
                    }
            }
    }
    public static int[] readInt(String welcomeString, int argsNumber) {
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
}
