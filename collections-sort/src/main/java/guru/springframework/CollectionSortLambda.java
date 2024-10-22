package guru.springframework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jt, Spring Framework Guru.
 */
public class CollectionSortLambda {
    public static void main( String[] args )
    {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Michael", "Weston"));
        list.add(new Person("Fiona", "Glenanne"));
        list.add(new Person("Sam", "Axe"));
        list.add(new Person("Jesse", "Porter"));
        list.add(new Person("Madeline", "Westen"));

        System.out.printf("Before Sort : %s%n", list);

        Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        System.out.printf("After Sort : %s%n", list);
    }
}
