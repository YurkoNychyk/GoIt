package module4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by home on 12.04.2016.
 */
@RunWith(value = Parameterized.class)
public class PolygonTest {
    Polygon testPolygon;
    double expectedArea;
    double actualArea;
    final double COMPARATION_DELTA = 0.01;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        Object[][] testDada = new Object[][]{
                {new Polygon(new Line(10),new Line(10),new Line(10),new Line(10)),100},
                {new Polygon(new Line(10),new Line(10),new Line(10)),43.3},
        };
        return Arrays.asList(testDada);

    }

    public PolygonTest(Polygon testPolygon, double expectedArea) {
        this.testPolygon= testPolygon;
        this.expectedArea = expectedArea;
        this.actualArea = testPolygon.calculateArea();
    }

    @Test
    public void calculateArea() throws Exception {
        assertEquals(expectedArea,actualArea,COMPARATION_DELTA);
    }

}