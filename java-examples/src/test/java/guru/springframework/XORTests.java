package guru.springframework;


import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class XORTests {

    @Test
    void testXor() {

        boolean foo = true;
        boolean bar = false;

        boolean result = foo ^ bar;

        int a = 1; // 00000001
        int b = 2; // 00000010

        int c = a ^ b; // 00000011

        System.out.println("Result: " + c);

        int d = 2; // 00000010
        int e = 3; // 00000011

        System.out.println("Result: " + (d ^ e)); // 00000001

        int f = 1; //  00000011
        int g = 10; // 00001010

        System.out.println("Result: " + (f ^ g)); // 00001011

        int h = 81; // 10000000
        int i = 83; // 10000011

        System.out.println("Result: " + (h ^ i)); // 00000011

        int m = 81; // 10000001
        int l = 88; // 10000111

        System.out.println("Result: " + (m ^ l)); // 10001000

        long n = 81; // 10000001
        long o = 88; // 10000111

        System.out.println("Result: " + (n ^ o)); // 10001000
    }


    @Test
    void testBool() {
        boolean isSunny = true;
        boolean isWarm = true;

        System.out.println("Is it sunny and warm? " + (isSunny ^ isWarm));

    }

    @Test
    void testBool2() {
        boolean isSunny = true;
        boolean isWarm = false;

        System.out.println("Is it sunny and warm? " + (isSunny ^ isWarm));
    }

    @Test
    void testBitwise() {
        int i = 5;
        int j = 5;

        for (int k = 0; k < 15; k++) {
            System.out.printf("values: %d ^ %d = %d  | %d + %d = %d  \n", i, j, i ^ j, i, j, i + j);

            j++;
        }
    }

    @Test
    void testBitwise2() {
        int i = 999999999;
        long j = 999999999;

        //loop 100 times
        for (int k = 0; k < 100; k++) {
            System.out.printf("values: %d %d %d %d\n", i, j, i ^ j, i - j++);
        }
    }

    @Test
    void testBitwise3() {
        int i = 100000;
        int j = 100000;

        //loop 100 times
        for (int k = 0; k < 100; k++) {
            System.out.printf("values: %d %d %d %d\n", i, j, i ^ j, i - j++);
        }
    }
}
