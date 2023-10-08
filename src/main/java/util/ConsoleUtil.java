package util;

public final class ConsoleUtil {
    private ConsoleUtil() {}

    public static void print(String string) {
        System.out.println(string);
    }

    public static void print(String string, Object... value) {
        System.out.println(String.format(string, value));
    }
}
