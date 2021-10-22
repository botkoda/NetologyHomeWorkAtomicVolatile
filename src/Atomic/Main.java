package Atomic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder longAdder = new LongAdder();
        final int ARRAY_LENGTH=100;
        final int RANDOM_TOP=10000;

        //Генерация 3 массивов целых положительных чисел.В количестве 7ми штук.
        List<Long> list1 = Stream.generate(() -> (long) (Math.random() * RANDOM_TOP)).limit(ARRAY_LENGTH).collect(Collectors.toList());
        List<Long> list2 = Stream.generate(() -> (long) (Math.random() * RANDOM_TOP)).limit(ARRAY_LENGTH).collect(Collectors.toList());
        List<Long> list3 = Stream.generate(() -> (long) (Math.random() * RANDOM_TOP)).limit(ARRAY_LENGTH).collect(Collectors.toList());

        //Создание трех потоков, которые суммируют выручку (каждый по своему массиву) в общий отчет
        executorService.submit(() -> list1.forEach(x -> longAdder.add(x.longValue())));
        executorService.submit(() -> list2.forEach(x -> longAdder.add(x.longValue())));
        executorService.submit(() -> list3.forEach(x -> longAdder.add(x.longValue())));

        //Главный поток ждет завершения всех рассчетов и печатает общий итог в консоль
        executorService.shutdown();
        System.out.println("Массив 1: " + Arrays.toString(list1.toArray()));
        System.out.println("Массив 2: " +Arrays.toString(list2.toArray()));
        System.out.println("Массив 3: " +Arrays.toString(list3.toArray()));
        System.out.println("Итого:  " + longAdder.sum());


    }
}
