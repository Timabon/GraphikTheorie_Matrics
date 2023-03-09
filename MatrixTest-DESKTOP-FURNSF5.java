package org.example;

import org.junit.jupiter.api.Test;

class MatrixTest {

    Matrix ma = new Matrix();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void berechnenMatrix() {
        ma.berechnenMatrix(6);
        System.out.println(ma.toString(ma.result));
    }

    @Test
    void print() {
    }

    @Test
    void distanzMatrix() {
        System.out.println(ma.toString(ma.matrix));
        ma.distanzMatrix(4);

    }
}