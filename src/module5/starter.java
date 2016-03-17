package module5;

import java.util.Random;

/**
 * Created by home on 17.03.2016.
 */
public class starter {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for (int i=0; i<array1.length; i++) {
            array1[i] = new Random().nextInt(100);
        }
        ArraySorting.printArray(array1);
        System.out.println();
        System.out.println("Min element is " + FindMinMax.getMin(array1));
        System.out.println("Max element is " + FindMinMax.getMax(array1));

    }

}
