package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class CalculateTriangleTest
{

    @DisplayName("Площадь вычисляется верно")
    @ParameterizedTest
    @CsvSource({"7, 7, 7, 21.217622392719", "2, 4, 3, 2.9047375", "5, 5, 5, 10.825317", "3, 3, 2, 2.828427"})
    void calculationsCorrect(Integer a, Integer b, Integer c, Float P) throws NullSideException, BadSideException {
        assertEquals(P, CalculateTriangle.calculateArea(a, b, c));
    }

    @DisplayName("Проверка на бросание исключения NullSideException")
    @ParameterizedTest
    @CsvSource({"0, 0, 0, 13", "5, 3, 0, 6", "7, 0, 3, 3"})
    void shouldThrowNullSide(int a, int b, int c, float s) throws NullSideException {
        assertThrows(NullSideException.class, () -> {CalculateTriangle.calculateArea(a, b, c);});
    }

    @DisplayName("Проверка на бросание исключения BadSideException")
    @ParameterizedTest
    @CsvSource({"1, 2, 8, 23", "3, 17, 5, 5", "11, 1, 2, 4"})
    void shouldThrowBadSide(int a, int b, int c, float s) throws BadSideException {
        assertThrows(BadSideException.class, () -> {CalculateTriangle.calculateArea(a, b, c);});
    }
}
