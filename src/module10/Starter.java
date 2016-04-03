package module10;
import module4.ConsoleReader;
import module9.Coder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
                        try (BufferedWriter out = new BufferedWriter( new FileWriter(fileName)){
                        }){
                            out.write(encodedMessage);
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
                        StringBuffer fileInput = new StringBuffer();
                        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {


                                fileInput.append(in.readLine());

                            encodedMessage = fileInput.toString();
                            System.out.println("Повідомленя прочитане: " + encodedMessage);
                            break;
                        }
                        catch (EOFException e){
                            System.out.println("eof");

                        }
                        catch (FileNotFoundException e){
                            System.out.println("Немає такого файлу!");
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }

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
