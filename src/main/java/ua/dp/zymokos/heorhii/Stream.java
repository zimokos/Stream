package ua.dp.zymokos.heorhii;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list = createArrayList();
        printArrayList(list);
        System.out.print("Квадраты элементов списка: ");
        list.stream()
                .map(x -> x * x)
                .map(x -> x + " ")
                .forEach(System.out::print);
        System.out.println();
        System.out.print("Сумма квадратов всех элементов: " + list.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x));
        System.out.println();
        System.out.println();

        HashSet<Integer> set = createHashSet();
        printHashSet(set);
        System.out.print("Четные элементы набора: ");
        set.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x + " ")
                .forEach(System.out::print);
        System.out.println();
        System.out.println("Количество четных элементов: " + set.stream()
                .filter(x -> x % 2 == 0)
                .count());
        System.out.println();

        HashSet<String> setOfName = createSetOfName();
        System.out.print("Набор имен сотрудников: ");
        System.out.println(setOfName.stream().collect(Collectors.joining(", ")));
        System.out.print("Имена сотрудников на букву \"J\": ");
        System.out.println(setOfName.stream()
                .filter(e -> e.contains("J"))
                .collect(Collectors.joining(", ")));
        System.out.println();

        Integer[] array = createArray();
        printArray(array);
        sum(u -> Stream.sumOfOddElements(u), array); // Stream::sumOfOddElements
        sum(u -> Stream.sumOfEvenElements(u), array); // Stream::sumOfEvenElements

//        System.out.println();
//        printArray(array);
//        sumOfEvenAndOddElements(array);
    }

    public static List<Integer> createArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        return list;
    }

    public static <E> void printArrayList(List<E> list) {
        System.out.print("Список случайных чисел: ");
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static HashSet<Integer> createHashSet() {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 10) {
            set.add((int) (Math.random() * 100));
        }
        return set;
    }

    public static <E> void printHashSet(HashSet<E> set) {
        System.out.print("Набор случайных чисел: ");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static HashSet<String> createSetOfName() {
        HashSet<String> setOfName = new HashSet<>();
        setOfName.add("James");
        setOfName.add("Alice");
        setOfName.add("Kate");
        setOfName.add("John");
        setOfName.add("Benjamin");
        setOfName.add("Samuel");
        setOfName.add("Jane");
        setOfName.add("Rachel");
        setOfName.add("Laura");
        setOfName.add("Jennifer");
        return setOfName;
    }

    public static Integer[] createArray() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

    public static <E> void printArray(E[] array) {
        System.out.print("Массив случайных чисел: ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sum(Consumer<Integer[]> consumer, Integer[] array) {
        consumer.accept(array);
    }

    public static void sumOfEvenElements(Integer[] array) {
        Integer sumOfEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumOfEven = sumOfEven + array[i];
            }
        }
        System.out.println("Сумма четных (по индексу) элементов: " + sumOfEven);
    }

    public static void sumOfOddElements(Integer[] array) {
        Integer sumOfOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                sumOfOdd = sumOfOdd + array[i];
            }
        }
        System.out.println("Сумма нечетных (по индексу) элементов: " + sumOfOdd);
    }

    public static void sumOfEvenAndOddElements(Integer[] array) {
        Integer sumOfEven = 0;
        Integer sumOfOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumOfEven = sumOfEven + array[i];
            } else {
                sumOfOdd = sumOfOdd + array[i];
            }
        }
        System.out.println("Even = " + sumOfEven + " Odd = " + sumOfOdd);
    }
}
