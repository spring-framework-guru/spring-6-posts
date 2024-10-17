package guru.springframework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jt, Spring Framework Guru.
 */
public class CollectionSortReverse {
    public static void main( String[] args )
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Michael Weston");
        list.add("Fiona Glenanne");
        list.add("Sam Axe");
        list.add("Jesse Porter");
        list.add("Madeline Westen");

        System.out.printf("Before Sort : %s%n", list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.printf("After Sort : %s%n", list);
    }
}
