package ru.ursip.lambert.task;

import org.junit.jupiter.api.Test;
import ru.usrip.lambert.task.URSiPTask;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class URSiPTaskTest {

    @Test
    void generateNumWithoutPassAndNotOne() {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals("001", URSiPTask.generateNum(numbers));
    }

    @Test
    void generateNumWithoutPass() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals("011", URSiPTask.generateNum(numbers));
    }

    @Test
    void generateNumWithPass() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13);
        assertEquals("011", URSiPTask.generateNum(numbers));
    }

    @Test
    void generateNumWithSeveralPass() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7, 8, 9, 10, 13);
        assertEquals("004", URSiPTask.generateNum(numbers));
    }

    @Test
    void generateNumWithSeveralPassAndRepeatedValues() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 5, 6, 7, 8, 9, 10, 13);
        assertEquals("004", URSiPTask.generateNum(numbers));
    }
}