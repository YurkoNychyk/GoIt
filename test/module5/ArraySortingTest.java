package module5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by home on 13.04.2016.
 */
@RunWith(value = Parameterized.class)
public class ArraySortingTest {
    int[] testArray;
    int[] expectedArray;
    int[] sortedArray;

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        int[] sortedArray1 = new int[] {10,15,20,25,40,54};
        int[] sortedArray2 = new int[] {-54,-40,-25,-20,-15,-10};
        int[] sortedArray3 = new int[] {0,0,0,0,0,0};
        int[] sortedArray4 = new int[] {10};

        int[] array1 = new int[] {15,10,20,54,40,25};
        int[] array2 = new int[] {-10,-54,-20,-25,-40,-15};
        int[] array3 = new int[] {0,0,0,0,0,0};
        int[] array4 = new int[] {10};

        return Arrays.asList(new Object[][]{
                {array1,sortedArray1},
                {array2,sortedArray2},
                {array3,sortedArray3},
                {array4,sortedArray4}
        });
    }

    public ArraySortingTest(int[] testArray, int[] expectedArray) {
        this.testArray = testArray;
        this.expectedArray = expectedArray;
        this.sortedArray = ArraySorting.sortArray(testArray);
    }

    @Test
    public void testSortArray() throws Exception {
        /* assertEquals(expectedArray,sortedArray); */
        assertArrayEquals(expectedArray,sortedArray);
    }
}