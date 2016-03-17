import java.util.Random;

/**
 * Created by home on 17.03.2016.
 */
public class ArraySorting {
    public static void main(String[] args) {
        int[] newArray = new int[10];
        int[] sortedArray = newArray;
        Random randomizer = new Random();

        for (int i=0; i<newArray.length;i++) {
            newArray[i] = randomizer.nextInt(10);
        }
        printArray(newArray);
        sortedArray = sortArray(newArray);
        System.out.println();
        printArray(sortedArray);


    }

    public static int[] sortArray(int[] array) {
        for (int inc=1; inc<array.length;inc++) {
            for (int revercedInc=inc; revercedInc>0 && array[revercedInc-1]>array[revercedInc] ; revercedInc--){
                array[revercedInc] = swap(array[revercedInc-1],array[revercedInc-1]=array[revercedInc]);
            }
        }
        return array;
    }
    public static int swap(int x,int y) {
        return x;
    }

    public static void printArray(int[] array)  {
        System.out.println();
        for (int i:array) {
            System.out.print(i + " ");
        }
    }
}
