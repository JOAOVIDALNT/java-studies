import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);

        System.out.println(Arrays.toString(st1.toArray()));
        // retorna [30, 60, 90, 120, 150]

        int sum = list.stream().reduce(0, (x,y) -> x + y);
        System.out.println("Sum = " + sum);


        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0) // filtra apenas os números pares
                .map(x -> x * 10)       // multiplica eles por 10
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));

    }
}