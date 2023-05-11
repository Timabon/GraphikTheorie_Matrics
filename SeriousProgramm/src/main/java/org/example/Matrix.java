package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Matrix {
    private static int rows, columns;
    static int[][] matrix, matrix2, matrix3;
    static int[][] distanzMatrix;

    static int[][] wayMatrix;
    static int MultTimesCounter = 0;
    static int distanceCounter = 2;

    static int times1 = 0;


    public static void main(String[] args) throws Exception {
        csvReader();
        matrixMultiply(3);
        distanzMatrix();
        //wayMatrix();
        toString(matrix2);
        toString(distanzMatrix);
        //toString(matrix);
        toString(wayMatrix);
        // ERD.exzentretitet();
        // ERD.durchMesse();
        //  ERD.Radius();
        //  ERD.Centre();
            ERD.Komponenten();
    }


    public static void csvReader() throws Exception {
        FileReader reader = new FileReader("file3.txt");
        BufferedReader br = new BufferedReader(reader);
        String currentline = "";

        while ((currentline = br.readLine()) != null) {
            String[] values = currentline.split(",");
            rows++;
            if (columns == 0) {
                columns = values.length;
            }
            if (values.length != columns) {
                throw new Exception("Failure: Rows are not matching");
            }
        }
        //System.out.println("Rows: " + rows);
        //System.out.println("Columns " + columns);

        reader = new FileReader("file3.txt");
        br = new BufferedReader(reader);

        matrix = new int[rows][columns];
        for (int i = 0; i <= matrix.length; i++) {
            while ((currentline = br.readLine()) != null) {
                String[] values = currentline.split(",");
                for (int j = 0; j < values.length; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
                break;
            }
        }
    }

    public static int[][] matrixMultiply(int times) {
        matrix3 = matrix;

        for (MultTimesCounter = 1; MultTimesCounter < times; MultTimesCounter++) {
            matrix2 = new int[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix2[i][j] += matrix[i][k] * matrix3[k][j];
                    }
                }
            }
            wayMatrix();
            distanzMatrix();
            matrix3 = matrix2;
        }
        return matrix3;
    }

    public static void distanzMatrix() {

        if (MultTimesCounter == 1) {
            distanzMatrix = new int[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[1].length; j++) {
                    if (i != j) {
                        distanzMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if (matrix3[k][j] == 0) {
                    if (k != j && matrix[k][j] == 0 && matrix3[k][j] != matrix2[k][j]) {
                        distanzMatrix[k][j] = distanceCounter;
                    }
                }
            }
        }
        distanceCounter++;
    }


    public static void wayMatrix() {
        if (MultTimesCounter == 1) {
            wayMatrix = new int[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[1].length; j++) {
                    if (i == j) {
                        wayMatrix[i][j] = 1;
                    } else {
                        wayMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int n = 0; n < matrix.length; n++) {
                if (matrix2[k][n] != matrix3[k][n] && matrix2[k][n] != 0) {
                    wayMatrix[k][n] = 1;
                }
            }
        }
    }


    public static String toString(int[][] matrixName) {

        /*if (matrix.equals(matrixName)) {
            System.out.println("Matrix 1: ");
            for (int[] s : matrix) {
                System.out.println(Arrays.toString(s));
            }
        } else */
        if (matrix2.equals(matrixName)) {
            System.out.println("Result: ");
            for (int[] s : matrix2) {
                System.out.println(Arrays.toString(s));
            }
        } else if (matrix3.equals(matrixName)) {
            System.out.println("Result: ");
            for (int[] s : matrix3) {
                System.out.println(Arrays.toString(s));
            }
        } else if (distanzMatrix.equals(matrixName)) {
            System.out.println("DistanzMatrix: ");
            for (int[] s : distanzMatrix) {
                System.out.println(Arrays.toString(s));
            }
        } else if (wayMatrix.equals(matrixName)) {
            System.out.println("Waymatrix: ");
            for (int[] s : wayMatrix) {
                System.out.println(Arrays.toString(s));
            }
        }
        return matrixName.toString();
    }
}







