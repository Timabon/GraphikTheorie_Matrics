package org.example;

public abstract class HUB {

    protected int len;
    protected int[][] endResult;
    protected int[][] resultTmp;
    protected int[][] tmp;
    protected int [][] matrix = new int[][] {{0, 1, 1, 1, 0},{1, 0, 0, 1, 1},{1, 0, 0, 1, 0},{1, 1, 1, 0, 0},{0, 1, 0, 0, 0}};

    public HUB (){
        this.len = matrix[0].length;
        this.resultTmp = matrix;
        this.endResult = new int[len][len];
    }
}
