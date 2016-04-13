package module10;

import module9.Coder;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by home on 13.04.2016.
 */
@RunWith(value = Parameterized.class)
public class FileOpsTest {
    String testString;
    String encodedString;
    String expectedEncodedString;
    String decodedString;
    String fileName;


    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        final String testString1 = "qwerty";
        final String testString2 = "12345";
        final String testString3 = "йцукеній";
        final String encodedTestString1 = "tzhuw|";
        final String encodedTestString2 = "45678";
        final String encodedTestString3 = "мщцнирљм";

        return Arrays.asList(new Object[][]{
                {testString1, encodedTestString1, "yurko"},
                {testString2, encodedTestString2, "123"},
                {testString3, encodedTestString3, "sdfdsaf"}
        });
    }

    public FileOpsTest(String testString, String encodedString, String fileName) {
        this.testString = testString;
        this.expectedEncodedString= encodedString;
        this.encodedString = Coder.encodeString(testString,3);
        this.fileName = fileName;
        FileOps.writeMessageToFile(encodedString,fileName);
    }

    @Test
    public void readMessageFromFile() throws Exception {
        decodedString = Coder.decodeString(FileOps.readMessageFromFile(fileName),3);
        assertEquals(testString,decodedString);
    }

}