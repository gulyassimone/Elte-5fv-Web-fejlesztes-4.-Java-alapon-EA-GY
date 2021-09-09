package calc;

import java.util.Arrays;

/**
 * Ez a main függvény.
 *
 */
public class CalcMain {

    public static final int VALUE_30 = 30;
    public static final int VALUE_12 = 12;

    /**
     * Main methode.
     * @param args
     */
    public static void main(String[] args) {
        Arrays.asList(args).forEach(CalcMain::println);

        Calculator c = new Calculator();
        println("Solution: " + c.add(VALUE_30, VALUE_12));
    }

    /**
     * Ez egy kiíratás.
     * @param value
     */
    private static void println(String value) {
        System.out.println(value);

    }

}
