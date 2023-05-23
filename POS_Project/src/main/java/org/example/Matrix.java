package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class Matrix extends HUB {
	int k = 2;

	public int[][] berechnenMatrix(int gradZahl) {  //Wir brauchen es nur fur PotenzMatrix
		if (gradZahl > 1) {
			tmp = new int[len][len]; // RESET TMP because of recursion
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					for (int l = 0; l < len; l++) {
						tmp[i][j] += matrix[i][l] * resultTemp[l][j]; // Matrix MUL
					}
				}
			}
			resultTemp = tmp;
			return berechnenMatrix(gradZahl - 1); // recursion
		} else {
			finalResult = resultTemp; // FinalResult -> TempArray
			resultTemp = matrix; // TempArray updated!
			return finalResult;
		}
	}

	public int[][] distanzMatrixv1() {
		int[][] distanzMat = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				distanzMat[i][j] = matrix[i][j];
				if (distanzMat[i][j] == 0 && i != j) {
					distanzMat[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int h = 0;
		while (h < len - 1) { // len is length of all points in Graph for example " G = A B C D E " is len = 5, so it will run only 4 times(5 - 1)
			berechnenMatrix(k);
			for (int p = 0; p < len; p++) {
				for (int l = 0; l < len; l++) {
					if (distanzMat[p][l] == Integer.MAX_VALUE && finalResult[p][l] > 0) {
						distanzMat[p][l] = k;
					}
				}
			}
			k++;
			h++;
		}
		return distanzMat;
	}

	public int[][] wegMatrix() {
		int[][] wayMatrix = new int[len][len];
		for (int i = 0; i < len; i++) { //COPY and add 1 in diagonal
			for (int j = 0; j < len; j++) {
				if (i == j) {
					wayMatrix[i][j] = 1;
				} else {
					wayMatrix[i][j] = matrix[i][j];
				}
			}
		}

		int h = 0; //add 1's when MatrixMulti[i][j] > 0 //todo something wrong with while fix too much
		while (h < len) {
			berechnenMatrix(h + 1);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (finalResult[i][j] > 0) {
						wayMatrix[i][j] = 1;
					}
				}
			}
			h++;
		}


		return wayMatrix;
	}

    public int componentsCount () {
		int[][] wayMatrix = wegMatrix();
	    HashSet<String> zeilen = new HashSet<>();
	    for (int[] array : wayMatrix) {
		    String arrayAsString = Arrays.toString(array);
		    zeilen.add(arrayAsString);
	    }
	    int count = zeilen.size();
	    System.out.println("Komp : " + count);
        return count;
    }

	public void print(int[][] mat) {
		System.out.println(Arrays.deepToString(mat)
				.replace("], ", "]\n")
				.replace("[[", "[")
				.replace("]]", "]")
				.replace(String.valueOf(Integer.MAX_VALUE), "∞"));
	}
}
