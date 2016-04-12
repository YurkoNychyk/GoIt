package module4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by home on 12.04.2016.
 */
public class TemperatureConvertorTest {
    final double COMPARATION_DELTA = 0.01;
    @Test
    public void convertToFarenheit() throws Exception {
        final double expectedFarenheitTemp = 212;
        assertEquals(expectedFarenheitTemp,TemperatureConvertor.convertToFarenheit(100),COMPARATION_DELTA);
    }

    @Test
    public void convertToCelcius() throws Exception {
        final double expectedCelsiusTemp = 100;
        assertEquals(expectedCelsiusTemp,TemperatureConvertor.convertToCelcius(212),COMPARATION_DELTA);
    }

}