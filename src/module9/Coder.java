package module9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by home on 31.03.2016.
 */
public class Coder {
    public static String encodeString (String s, int key) throws NullPointerException{
        return codeString(s,key);
    }
    public static String decodeString(String s, int key) throws NullPointerException    {
        return codeString(s,-key);
    }

    private static String codeString(String s, int key){
        char charArray[] = s.toCharArray();
        int[] codesArray = new int[charArray.length];
        StringBuffer outputString = new StringBuffer();

        for (int i=0; i<charArray.length; i++) {
            codesArray[i] = (int)charArray[i] +key;
            charArray[i] = (char)codesArray[i];
            outputString.append(charArray[i]);
        }

        return outputString.toString();

    }
}
