package module4;

import java.util.Scanner;

/**
 * Created by home on 18.03.2016.
 */
public class ConsoleReader {
    private static Scanner consoleReader;
    public static int[] readInt(String welcomeString, int argsNumber) {
        //Метод для зчитування чисел з консолі. не відстане доки користувач не введе числа
        while (true) {
            try {
                consoleReader = new Scanner(System.in);
                int[] args = new int[argsNumber];
                System.out.println(welcomeString );
                for (int i = 0; i < argsNumber; i++) {
                    args[i] = consoleReader.nextInt();
                }
                return args;
            } catch (Exception E) {
                System.out.println("Помилка вводу!");
            }
        }
    }

    public static String readString(String welcomeMessage) {
        System.out.println(welcomeMessage);
        return consoleReader.next();
    }
}
