import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        sum(LambdaTest::sumOfOddElements);
        System.out.println();
        sum(array -> LambdaTest.sumOfEvenElements(array));
    }

    public static void sum(Consumer<Integer[]> consumer) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        consumer.accept(array);
    }

    public static void sumOfEvenElements(Integer[] array) {
        Integer sumOfEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumOfEven = sumOfEven + array[i];
            }
        }
        System.out.println(sumOfEven);
    }

    public static void sumOfOddElements(Integer[] array) {
        Integer sumOfOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                sumOfOdd = sumOfOdd + array[i];
            }
        }
        System.out.println(sumOfOdd);
    }
}
