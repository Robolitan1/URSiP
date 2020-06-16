package ru.usrip.lambert.task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Задание: Lambert Artem
 * <p>
 * Реализовать метод для генерации номера проекта на Java, Kotlin или Scala
 * <p>
 * Сигнатура метода (java):
 * public static String generateNum(List<Integer> numbers)
 * <p>
 * На вход будет переданы сущетвующие номера в виде масива целых чисел.
 * Необходимо вернуть номер следующего проекта, по следующей логике:
 * Если текущие номера проекта не содержат пропусков, то необходимо вернуть максимальный элемент + 1.
 * Если пропуски есть, необходимо вернуть минимальный из них.
 * Пропуском называется разница между номерами больше или равная единицы (f(1,3) содержит пропуск, а f(1,2) нет).
 * Переданные номера проектов могут дублироваться, но сгенерированный методом номер не должен повторять существующий.
 * Номера проектов неотрицательные.
 * <p>
 * Пример:
 * f(1,2,3) = 4
 * f(1,3) = 2
 * f(2) = 1
 * <p>
 * Сгенерированный номер необходимо вернуть в формате трехразрядной строки, т.е.:
 * f(1) = "001"
 * f(10) = "010"
 * f(100) = "100"
 * <p>
 * В реализации приветствуется функциональный стиль.
 * Оцениваться будет качество кода и его корректность.
 * Решение необходимо залить в публичный репозиторий и предоставить ссылку.
 */

public class URSiPTask {
    public static String generateNum(List<Integer> numbers) {
        // just to clean and sorted incoming list of numbers
        List<Integer> buff = numbers.stream().sorted().distinct().collect(Collectors.toList());

        // check first value to save time of stream manipulation
        if (buff.get(0) > 1) {
            return format(buff.get(0) - 1);
        }

        //get first index where we have pass between numbers
        int index = IntStream.range(0, buff.size() - 1)
                .filter(i -> containsPass(buff.get(i), buff.get(i + 1)))
                .findFirst()
                .orElse(0);
        return index == 0 ? format(buff.get(buff.size() - 1) + 1) : format(buff.get(index) + 1);
    }

    private static boolean containsPass(int currentElement, int nextElement) {
        return nextElement - currentElement > 1 ? true : false;
    }

    private static String format(int nextNumberOfProject) {
        return String.format("%03d", nextNumberOfProject);
    }
}
