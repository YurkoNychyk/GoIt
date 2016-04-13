package module9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by home on 13.04.2016.
 */
@RunWith(value = Parameterized.class)
public class CoderTest {
    String testString;
    String encodedString;
    String expectedEncodedString;
    String decodedString;

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        final String testString1 = "qwerty";
        final String testString2 = "12345";
        final String testString3 = "йцукеній";
        final String encodedTestString1 = "tzhuw|";
        final String encodedTestString2 = "45678";
        final String encodedTestString3 = "мщцнирљм";
        return Arrays.asList(new Object[][]{
                {testString1, encodedTestString1},
                {testString2, encodedTestString2},
                {testString3, encodedTestString3}
        });
    }

    public CoderTest(String testString, String encodedString) {
        this.testString = testString;
        this.expectedEncodedString= encodedString;
        this.encodedString = Coder.encodeString(testString,3);
        this.decodedString = Coder.decodeString(encodedString,3);
    }

    @Test
    public void encodeString() throws Exception {
        assertEquals(expectedEncodedString,encodedString);
    }

    @Test
    public void decodeString() throws Exception {
        assertEquals(testString,decodedString);

    }

}