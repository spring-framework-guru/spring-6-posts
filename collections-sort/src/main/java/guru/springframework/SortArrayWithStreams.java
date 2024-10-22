package guru.springframework;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by jt, Spring Framework Guru.
 */
public class SortArrayWithStreams {

    public static void main( String[] args ) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Michael Weston");
        list.add("Fiona Glenanne");
        list.add("Sam Axe");
        list.add("Jesse Porter");
        list.add("Madeline Westen");

        System.out.printf("Before Sort : %s%n", list);
        System.out.println("\nSorted with stream");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nSorted with stream in reverse order");

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("\nSorted with stream by last name");

        list.stream()
                .sorted((s1, s2) -> s1.split(" ")[1].compareTo(s2.split(" ")[1]))
                .forEach(System.out::println);
    }
}
