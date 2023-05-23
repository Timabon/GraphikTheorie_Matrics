package org.example;

public class Main {
    public static void main(String[] args) {
        Matrix mt = new Matrix();
        initDistanzMatrix();
        initMatrixMulti(3); //multipliziert matrix bis den gewünschten Grad, in dem Fall -> 3
        initWay();
        System.out.println();
        mt.componentsCount();
    }

    public static void initMatrixMulti (int j)  {
        Matrix mtx = new Matrix();
        for (int i = 1; i <= j; i++) {
        System.out.println("\nMatrixMulti A" + i + ": ");
        mtx.print(mtx.berechnenMatrix(i));
        }
    }

    public static void initDistanzMatrix ()  {
        System.out.println("\nDistanzMatrix: ");
        Matrix mtx = new Matrix();
        mtx.print(mtx.distanzMatrixv1());
    }

    public static void initWay () {
        System.out.println("\nWegMatrix: ");
        Matrix mtx = new Matrix();
        mtx.print(mtx.wegMatrix());
    }

}
