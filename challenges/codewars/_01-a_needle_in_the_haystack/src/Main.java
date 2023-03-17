import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] haystack = {"test","test","test","needle","tiger"};

        findNeedle(haystack);
    }

    public static String findNeedle(Object[] haystack) {
        return String.format("find needle at position, %d", Arrays.asList().indexOf("needle"));
    }
}