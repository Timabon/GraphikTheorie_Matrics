package org.example;

import java.util.Arrays;

public class Matrix extends HUB {


    int k = 2;

    public int[][] berechnenMatrix(int gradZahl) {  //Wir brauchen es nur fur PotenzMatrix
        if (gradZahl > 1) {
            tmp = new int[len][len]; // RESET TMP because of recursion
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int l = 0; l < len; l++) {
                        tmp[i][j] += matrix[i][l] * resultTmp[l][j]; // Matrix MUL
                    }
                }
            }
            resultTmp = tmp;
            return berechnenMatrix(gradZahl - 1); // recursion
        } else {
            endResult = resultTmp; // buffer arr -> EndResult
            resultTmp = matrix; // buffer arr reseted
            return endResult;
        }
    }

    public int[][] distanzMatrixv1() {
        int[][] distanzMat = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                distanzMat[i][j] = matrix[i][j];
                if (distanzMat[i][j] == 0 && i != j) {
                    distanzMat[i][j] = 9;
                }
            }
        }
        int h = 0;
        while (h < 1) {
            berechnenMatrix(k);
            for (int p = 0; p < len; p++) {
                for (int l = 0; l < len; l++) {
                    if (distanzMat[p][l] == 9 && endResult[p][l] > 0) {
                        distanzMat[p][l] = k;

                    }
                }
            }

        }


        return distanzMat;
    }
/*

    public int[][] berechnDistanz () {
        k++;
        int[][] endResDistanz = distanzMatrixv1();
        int[][] matrixMul = berechnenMatrix(k);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    endResDistanz[i][j] = 0;
                } else if (matrixMul[i][j] == 0 && endResDistanz[i][j] == k-1) {
                    endResDistanz[i][j] = k;
                }
            }
        }
        return endResDistanz;
    }
*/

    public void print(int[][] mat) {
        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        /*.replace("], ", "]\n").replace("[[", "[").replace("]]", "]"))*/
    }
}
