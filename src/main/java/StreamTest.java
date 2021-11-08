import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120)
                .filter(x -> x < 90)
                .map(x -> x + 10)
                .limit(3)
                .forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream stream = list.stream();
        stream.filter(x -> x.toString().length() == 3).forEach(System.out::println);

        String[] array = {"Java", "Rush"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split(""))
//                .flatMap(Arrays::stream)
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
//                .flatMapToInt(x -> IntStream.range(0, x))
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::print);
        System.out.println();

        List<String> newList = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream newStream = list.stream();
        System.out.println(newStream.limit(5)
                .skip(3)
                .sorted()
//                .forEach(System.out::println);
                .count());

        List<String> streamToList = Stream.of("One", "Two", "Three").collect(Collectors.toList());
        System.out.println(streamToList.size());

        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce((acc, x) -> acc + x));
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(100, (acc, x) -> acc + x));

        System.out.println(Stream.of(1, 2, 3, 4, 5).findFirst());
        System.out.println(Stream.of(1, 2, 3, 4, 5).allMatch(x -> x <= 3));
        System.out.println(Stream.of(1, 2, 3, 4, 5).anyMatch(x -> x <= 3));
        System.out.println(Stream.of(1, 2, 3, 4, 5).noneMatch(x -> x >= 6));
        System.out.println(Stream.of(1, 2, 3, 4, 5).collect(Collectors.counting()));
        System.out.println(Stream.of(1, 2, 3, 4, 5).count());
//        System.out.println(Stream.of(1, 2, 3, 4, 5).collect(Collectors.joining(", ")));
        Stream.of(1, 2, 3, 4, 5).map(x -> x * x).forEach(System.out::println);

    }
}
