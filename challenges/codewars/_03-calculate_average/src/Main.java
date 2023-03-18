import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 5, 8, 12};
        System.out.println(find_average(array));
    }

    public static double find_average(int[] array) {
         return Arrays.stream(array).average().orElse(0);

    }
}