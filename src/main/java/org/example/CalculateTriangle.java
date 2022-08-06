package org.example;

/**
 * Hello world!
 */
public class CalculateTriangle {
    public static float calculateArea(int a, int b, int c) throws BadSideException, NullSideException {
        if (a < 1 || b < 1 || c < 1) {
            throw new NullSideException();
        } else if ((a + b) < c || (a + c) < b || (b + c) < a) {
            throw new BadSideException();
        }
        float hp = (a + b + c) / 2.0f; // Полупериметр
        return (float) Math.sqrt(hp * (hp - a) * (hp - b) * (hp - c));
    }

}
