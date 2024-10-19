package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by jt, Spring Framework Guru.
 */
public class HashMapvsHashtable {

    @Test
    void hashMapTest() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "test");
        hashMap.put("test", null);
        hashMap.put("key1", "test");
        hashMap.put("key2", "test2");

        hashMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }

    @Test
    void hashTableTest() {
        Hashtable<String, String> hashTable = new Hashtable<>();
        hashTable.put("key1", "test");
        hashTable.put("key2", "test2");
        hashTable.put("key3", "test2");

        hashTable.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }

    @Test
    void hashTableWithNullKeyTest() {
        Hashtable<String, String> hashTable = new Hashtable<>();
        hashTable.put("key1", "test");
        hashTable.put("key2", "test2");
        hashTable.put(null, "test2");

        hashTable.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }

    @Test
    void hashTableWithNullValueTest() {
        Hashtable<String, String> hashTable = new Hashtable<>();
        hashTable.put("key1", "test");
        hashTable.put("key2", "test2");
        hashTable.put("key3", null);

        hashTable.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}
