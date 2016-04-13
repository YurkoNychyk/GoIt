package module10;

import java.io.*;

/**
 * Created by home on 13.04.2016.
 */
public class FileOps {
    public static void writeMessageToFile(String encodedMessage, final String fileName) {
        try (BufferedWriter out = new BufferedWriter( new FileWriter(fileName)){
        }){
            out.write(encodedMessage);
            System.out.println("Повідомлення зашифровано та збережено в файлі: "+ new File(fileName).getAbsolutePath());
            return;
        }
        catch (IOException e){
            System.err.println("Некоректне ім’я файлу: " + e.getMessage());
        }
    }

    public static String readMessageFromFile(final String fileName){
        StringBuffer fileInput = new StringBuffer();
        String substring;
        String encodedMessage = null;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            int i=0;
            while (true) {
                i++;
                substring = in.readLine();
                //System.out.println(substring);
                if (substring!=null){
                    fileInput.append(substring);
                }
                else
                {
                    break;
                }
            }
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
        return encodedMessage = fileInput.toString();
    }
}
