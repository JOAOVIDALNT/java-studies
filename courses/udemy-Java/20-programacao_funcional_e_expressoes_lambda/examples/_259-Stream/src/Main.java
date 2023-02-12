import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);

        System.out.printf(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("João", "Giulia", "Amelie");
        System.out.printf(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2 ); // qual é o primeiro elemento, qual é a função de iteração para os próximos elementos
        System.out.println(Arrays.toString(st3.limit(10).toArray())); // limita a 10 elementos
        // a operação limit devolve uma nova stream, por isso o toArray

        Stream<Long> fibo = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(fibo.limit(10).toArray()));


    }
}