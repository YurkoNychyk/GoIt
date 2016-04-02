package module10;
import module4.ConsoleReader;
import module9.Coder;

import java.io.*;

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
                        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(encodedFile)))) {
                            outputStream.write(encodedMessage.getBytes());
                            System.out.println("Повідомлення зашифровано та збережено в файлі: "+ encodedFile.getAbsolutePath());
                            break;
                        }
                        catch (Exception e){
                            System.err.println("Некоректне ім’я файлу: " + e.getMessage());
                        }
                        break;
                    }
                    break;

                case 2:
                    while (true) {
                        fileName = ConsoleReader.readString("Введіть ім’я файлу");
                        encodedFile = new File(fileName);
                        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(encodedFile)))) {
                            encodedMessage = inputStream.readUTF();
                            System.out.println("Encoded message: " + encodedMessage);
                            decodeKey = ConsoleReader.readInt("Введіть ключ шифрування.",1)[0];
                            System.out.println("Розшифроване повідомлення:\n"+ Coder.decodeString(encodedMessage,decodeKey));
                            break;
                        }
                        catch (EOFException e){
                            System.err.println("Повідомленя прочитане: " + e.getMessage());
                            System.out.println("Encoded message: " + encodedMessage);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    }
                    break;

                default:
                    System.out.println(encodedMessage);
                    break;
            }

        }
    }
}
