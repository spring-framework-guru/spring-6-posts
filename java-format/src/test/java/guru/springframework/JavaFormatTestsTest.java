package guru.springframework;

import org.junit.jupiter.api.Test;

import java.text.Format;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class JavaFormatTestsTest {

    @Test
    void testStringBuffer() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Spring Framework %s", "Guru");
       // System.out.println(formatter);

        System.out.printf("Spring Framework %s %n", "Guru");
        System.out.printf("%s %s %s %n", "Spring", "Framework", "Guru");
        System.out.printf("%3$s %2$s %1$s", "Spring", "Framework", "Guru");

    }

    @Test
    void testStringFlags() {
        System.out.printf("%s %S %S %n", "Spring", "Framework", "Guru");
        System.out.printf("%10s %s %s %n", "Spring", "Framework", "Guru");
        System.out.printf("%-10s %s %s %n", "Spring", "Framework", "Guru");
    }

    @Test
    void testboolean() {
        System.out.printf("%b%n", null);
        System.out.printf("%B%n", null);
        System.out.printf("%B%n", true);
        System.out.printf("%B%n", Boolean.FALSE);
        System.out.printf("%b%n", 2024);
        System.out.printf("%b%n", "Java Rocks!");
        System.out.printf("%B%n", "JAVA ROCKS!");
        System.out.printf("%b%n", LocalDateTime.now());
    }

    @Test
    void testCharacter() {
        System.out.printf("%c%n", 'g');
        System.out.printf("%C%n", 'g');
        System.out.printf("%C%c%c%c%n", 71, 117, 114, 117);
        System.out.printf("%c%c%c%c%n", '\u0047', '\u0075', '\u0072', '\u0075');
    }

    @Test
    void integersTest() {
        System.out.printf("My Integer: %d%n", 20000L);
        System.out.printf(Locale.US, "%,d %n", 20000);
        System.out.printf(Locale.GERMAN, "%,d %n", 20000);
        System.out.printf(Locale.FRENCH, "%,d %n", 20000);
    }

    @Test
    void floatTest() {
        System.out.printf("%f%n", Math.PI);
        System.out.printf("%20.2f%n", Math.PI);
        System.out.printf("%20.18f%n", Math.PI);
        System.out.printf("%5.2e%n", Math.PI);
    }

    @Test
    void timeTest() {
        Date date = new Date();
        System.out.println("Use t or T, same result");
        System.out.printf("%tT%n", date);
        System.out.printf("%TT%n%n", date);
        System.out.println("Show time in 12 hour format");
        System.out.printf("%tr%n%n", date);
        System.out.println("Build Date by position");
        System.out.printf("time is %tH:%tM:%tS%n%n", date, date, date);
        System.out.println("Show time in 12 hour format, remove additional arguments by referencing index");
        System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL %1$tN %1$tz %n", date);
    }

    @Test
    void timeTest2() {
        Date date = new Date();
        System.out.println("Show time in 12 hour format, remove additional arguments by referencing index");
        System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL %1$tN %1$tz %n", date);
        System.out.println("Same Result as above, but using < instead of $");
        System.out.printf("%1$tH:%<tM:%<tS %<tp %<tL %<tN %<tz %n", date);
    }

    @Test
    void dateTests() {
        Date date = new Date();
        System.out.printf("%1$tA, %1$tB %1$tY %n", date);
        System.out.printf("%1$td/%1$tm/%1$ty %n", date);
        System.out.printf("%1$td/%1$tm/%1$tY %n", date);
        System.out.printf("%s %tB %<te, %<tY%n", "Current date: ", date);
        System.out.printf("%s %tb %<te, %<ty%n", "Current date: ", date);
        System.out.printf("%tD%n", date);
    }

    @Test
    void dateTimeTests() {
        Date date = new Date();
        System.out.printf("%tF %n", date);
        System.out.printf("%tc %n", date);
        System.out.printf(Locale.US, "%tc %n", date);
        System.out.printf(Locale.UK, "%tc %n", date);
        System.out.printf(Locale.GERMAN, "%tc %n", date);
        System.out.printf(Locale.CHINESE, "%tc %n", date);
    }
}