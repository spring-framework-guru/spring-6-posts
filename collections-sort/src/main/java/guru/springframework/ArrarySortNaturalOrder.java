package guru.springframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by jt, Spring Framework Guru.
 */
public class ArrarySortNaturalOrder {

    //main
    public static void main( String[] args )
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Michael Weston");
        list.add("Fiona Glenanne");
        list.add("Sam Axe");
        list.add("Jesse Porter");
        list.add("Madeline Westen");

        System.out.printf("Before Sort : %s%n", list);

        list.sort(Comparator.naturalOrder());

        System.out.printf("After Natural Order Sort : %s%n", list);

        list.sort(Comparator.reverseOrder());

        System.out.printf("After Reverse Order Sort : %s%n", list);

        list.sort((s1, s2) -> s1.split(" ")[1].compareTo(s2.split(" ")[1]));

        System.out.printf("After Lambda Sort by Last Name : %s%n", list);
    }

}
