package guru.springframework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jt, Spring Framework Guru.
 */
public class CollectionSortCompare {

    public static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static class CompareFirstName implements java.util.Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

    public static void main( String[] args )
    {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Michael", "Weston"));
        list.add(new Person("Fiona", "Glenanne"));
        list.add(new Person("Sam", "Axe"));
        list.add(new Person("Jesse", "Porter"));
        list.add(new Person("Madeline", "Westen"));

        System.out.printf("Before Sort : %s%n", list);

        Collections.sort(list, new CompareFirstName());

        System.out.printf("After Sort : %s%n", list);
    }
}
