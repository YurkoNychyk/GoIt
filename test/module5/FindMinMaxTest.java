package module5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by home on 13.04.2016.
 */
@RunWith(value = Parameterized.class)
public class FindMinMaxTest {
    int expectedMin;
    int expectedMax;
    int[] testArray;


    @Parameterized.Parameters (name = "{index}: {0} min={1}, max={2} ")
    public static List<Object[]> testData(){
        int[] array1 = new int[] {10,15,20,25,40,54};
        int[] array2 = new int[] {-10,-15,-20,-25,-40,-54};
        int[] array3 = new int[] {0,0,0,0,0,0};
        int[] array4 = new int[] {10};
        Object[][] testCollection = new Object[][]{
                {array1, 10, 54},
                {array2,-54,-10},
                {array3,  0,  0},
                {array4, 10, 10}
        };
        return Arrays.asList(testCollection) ;
    }

    public FindMinMaxTest(int[] testArray,int expectedMin, int expectedMax ) {
        this.expectedMin = expectedMin;
        this.expectedMax = expectedMax;
        this.testArray = testArray;
    }

    @Test
    public void testGetMin() throws Exception {
        assertEquals(expectedMin,FindMinMax.getMin(testArray));
    }

    @Test
    public void testGetMax() throws Exception {
        assertEquals(expectedMax,FindMinMax.getMax(testArray));
    }

}