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
public class CircleTest {
    Circle testCircle;
    double expectedArea;
    double actualArea;
    final double COMPARATION_DELTA = 0.01;

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        Object[][] testDada = new Object[][] {
                {new Circle(10), Math.PI*Math.pow(10,2)},
                {new Circle(-10), Math.PI*Math.pow(-10,2)},
        };
        return Arrays.asList(testDada);
    }

    public CircleTest(Circle testCircle, double expectedArea, double actualArea) {
        this.testCircle = testCircle;
        this.expectedArea = expectedArea;
        this.actualArea = testCircle.calculateArea();
    }

    @Test
    public void calculateArea() throws Exception {
        assertEquals(expectedArea,actualArea,COMPARATION_DELTA);


    }

}