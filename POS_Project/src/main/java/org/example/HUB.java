package org.example;

import java.io.*;

public abstract class HUB {

    protected int len;
    protected int[][] finalResult;
    protected int[][] resultTemp;
    protected int[][] tmp;
    protected int[][] matrix; //todo


    public HUB() {
        try (BufferedReader br = new BufferedReader(new FileReader("Matrix.csv"))) {
            String line = br.readLine();
            len = line.split(";").length;
            matrix = new int[len][len];
            for (int i = 0; i < len; i++) {
                if (line != null) {
                    String[] strArray = line.split(";"); //todo from string array to int array
                    for (int j = 0; j < len; j++) {
                        matrix[i][j] = Integer.parseInt(strArray[j]);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Buffred reader error: " + e);
        }

        this.resultTemp = matrix;
        this.finalResult = new int[len][len];

    }
}
