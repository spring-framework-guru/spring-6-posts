package guru.springframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by jt, Spring Framework Guru.
 */
public class ArraySort {

    public static void main( String[] args )
    {
        int length = 3000;
        int[] array = new int[length];

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(0, length);
        }

        ArrayList<Integer> list = new ArrayList<Integer>(length);

        for (int i = 0; i < length; i++) {
            list.add(array[i]);
        }

        //Array sort
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        long end = System.currentTimeMillis();

        System.out.println("Array sort took: " + (end - start) + "ms");

        //Collection sort
        start = System.currentTimeMillis();
        Collections.sort(list);
        end = System.currentTimeMillis();

        System.out.println("Collection sort took: " + (end - start) + "ms");
    }


}
