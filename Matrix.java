package org.example;

import java.util.Arrays;

public class Matrix {

    int [][] matrix = new int[][] {{0, 1, 1, 1, 0},{1, 0, 0, 1, 1},{1, 0, 0, 1, 0},{1, 1, 1, 0, 0},{0, 1, 0, 0, 0}};
    int[][] result = matrix;
    int[][] tmp;
    int len = matrix[0].length;

    public int[][] berechnenMatrix(int gradZahl) {  //Wir brauchen es nur fur PotenzMatrix
            tmp = new int[len][len]; // RESET TMP need because of recursion
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int l = 0; l < len; l++) {
                        tmp[i][j] += matrix[i][l] * result[l][j]; // Matrix MULTI
                    }
                }
            }
            result = tmp;
            if (gradZahl > 2) { return berechnenMatrix(gradZahl - 1); } // RECURSION
        return result;
    }

    public int calcWertFromPotMa (int i, int j, int grad) {
        berechnenMatrix(2);
        tmp[i][j] += matrix[i][j] * result[i][j];
        return 0;
    }

    public int [][] distanzMatrix (int gradZahl) {
        int k = 2;
        int[][] distMat = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == 1) {
                    distMat[i][j] = matrix[i][j];
                } else if (i != j){
                    distMat[i][j] = k;
                }
            }
        }
        k++;
        toString(distMat);
        if (gradZahl > 2) { return distanzMatrix(gradZahl - 1); } // RECURSION
        return distMat;
    }

    public String toString (int[][] mat){
        String str = "";
        for (int i = 0; i < matrix[0].length; i++) {
            str += "\n";
            for (int j = 0; j < matrix[1].length; j++) {
                str += "| " + mat[i][j] + " |";
            }
        }
        return str;
    }

    public void print () {
        System.out.println(toString());
    }













/*                                                        testing rekursions
    public int rekursion(int i, int j) {
        if (i == 5) return 0;
        System.out.print("" + matrix[i][j] + ", ");
        if (j == 4) {
            j = 0;
            return rekursion(i + 1, j);
        }
        return rekursion(i,j + 1);
    }
*/
}
