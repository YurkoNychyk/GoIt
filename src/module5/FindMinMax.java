package module5;

/**
 * Created by home on 17.03.2016.
 */
public class FindMinMax {
    public static int getMin(int[] array) {
        int min = array[0];
        for (int i:array
             ) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i:array
                ) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
