package module10;
import module4.ConsoleReader;
import module9.Coder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static module10.FileOps.readMessageFromFile;
import static module10.FileOps.writeMessageToFile;

/**
 * Created by home on 02.04.2016.
 */
public class Starter {
    public static void main(String[] args) {
        String message;
        String encodedMessage="";
        String decodedMessage;
        int encodeKey;
        int decodeKey;
        String fileName = "default.txt";
        File encodedFile;

        while (true){

            switch (ConsoleReader.readInt("\n1 - Зашифрувати повідомлення та записати його у файл. \n2 - Розшифрувати повідомлення з файлу",1)[0]){
                case 1:

                    message = ConsoleReader.readString("Введіть своє повідомлення та натисніть 'Enter'");
                    encodeKey = ConsoleReader.readInt("Введіть ключ шифрування.",1)[0];
                    System.out.println("Повідомлення шифрується з ключем \"" + encodeKey +  "\"");
                    encodedMessage = Coder.encodeString(message,encodeKey);
                    System.out.println(encodedMessage);

                    while (true) {
                        fileName = ConsoleReader.readString("Введіть ім’я файлу");
                        encodedFile = new File(fileName);
                        writeMessageToFile(encodedMessage, fileName);
                        break;
                    }
                    break;

                case 2:
                    while (true) {
                        fileName = ConsoleReader.readString("Введіть ім’я файлу");
                        encodedFile = new File(fileName);
                        encodedMessage = readMessageFromFile(fileName);
                        break;
                    }

                    decodeKey = ConsoleReader.readInt("Введіть ключ шифрування.",1)[0];
                    System.out.println("Розшифроване повідомлення:\n"+ Coder.decodeString(encodedMessage,decodeKey));
                    break;

                default:

                    break;
            }

        }
    }



}
