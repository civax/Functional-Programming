package examples.optional;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OptionalDemoTest {
    private static OptionalDemo demo = new OptionalDemo();

    @BeforeAll
    public static void setUp() {
        demo.setStrings(Arrays.asList("five", "even", "length", "string", "values"));
    }

    @Test
    public void testCreateOptional_fromNotNull() {
        String s = "hello";
        Optional<String> optional = OptionalDemo.createOptionalTheHardWay(s);
        assertTrue(optional.isPresent());
        assertEquals(s, optional.get());

        optional = OptionalDemo.createOptionalTheEasyWay(s);
        assertTrue(optional.isPresent());
        assertEquals(s, optional.get());
    }

    @Test
    public void testCreateOptional_fromNull() {
        String s = null;
        Optional<String> optional = OptionalDemo.createOptionalTheHardWay(s);
        assertFalse(optional.isPresent());
        assertEquals(Optional.empty(), optional);

        optional = OptionalDemo.createOptionalTheEasyWay(s);
        assertFalse(optional.isPresent());
        assertEquals(Optional.empty(), optional);
    }

    @Test
    public void findFirstEven() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        assertTrue(first.isPresent());
        assertEquals("five", first.orElse(""));
    }

    @Test
    public void findFirstEven_orElse() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        assertTrue(first.isPresent());
        assertEquals("five", first.orElse("No even length strings"));
    }

    @Test
    public void findFirstOdd() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 != 0);
        assertFalse(first.isPresent());
        assertEquals("", first.orElse(""));
    }

    @Test
    public void findFirstOdd_orElse() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 != 0);
        assertFalse(first.isPresent());
        assertEquals("No odd length strings",
                first.orElse("No odd length strings"));
    }

    private String getDefault() {
        System.out.println("inside getDefault()");
        return "No matching string found";
    }

    @Test
    public void findFirstEven_orElseWithMethodDefault() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        assertEquals("five", first.orElse(getDefault()));
    }

    @Test
    public void findFirstEven_orElseGetWithMethodDefault() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        assertEquals("five", first.orElseGet(this::getDefault));
    }

    @Test
    public void findFirstEven_orElseThrow() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        assertEquals("five", first.orElseThrow(NoSuchElementException::new));
    }

    @Test
    public void findFirst_ifPresent() {
        Optional<String> first = demo.findFirst(s -> s.length() % 2 == 0);
        first.ifPresent(val -> System.out.println("Found an even"));

        first = demo.findFirst(s -> s.length() % 2 != 0);
        first.ifPresent(val -> System.out.println("Found an odd"));
    }
}