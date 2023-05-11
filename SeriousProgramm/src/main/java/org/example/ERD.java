package org.example;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.Matrix.*;


public class ERD {
    private static ArrayList<Integer> execntr = new ArrayList<>();

    public static ArrayList<Integer> ExzentretitetCalculation() {
        int a = 0;
        for (int i = 0; i < distanzMatrix.length; i++) {
            for (int j = 0; j < distanzMatrix[1].length; j++) {
                if (a < distanzMatrix[i][j]) {
                    a = distanzMatrix[i][j];
                }
            }
            execntr.add(a);
            a = 0;
        }
        return execntr;
    }

    public static void exzentretitet() {
        ExzentretitetCalculation();
        System.out.println("Excentrezitat: ");
        int s = 0;
        for (Integer num : execntr) {
            System.out.print("Row " + s + ": " + "ex(v) ");
            System.out.println(num);
            s++;
        }
    }

    public static int durchMesse() {
        if(execntr.size() == 0){
        ExzentretitetCalculation();}
        int a = Collections.max(execntr);
        System.out.println("Durchmesse: " + a);
        return a;
    }

    public static int Radius() {
        if(execntr.size() == 0){
            ExzentretitetCalculation();}
        int a = Collections.min(execntr);
        System.out.println("Radius: " + a);
        return a;
    }

    public static void Centre(){
        int a = Radius();
        int b = 1;
        System.out.println(execntr);
        for(Integer s : execntr) {
            if (s.equals(a)) {
                System.out.println("Zentrum " + b + ": " + s);
                b++;
            }
        }
    }

    // TODO: Если один компонент не связан ни с чем
    public static void Komponenten(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if(i!=j){
                    if(wayMatrix[i][j] == wayMatrix[j][j]){
                        System.out.println("Knoten: " + (i+1) + " ist verbunden mit " + (j+1));
                    }
                }
            }
        }
    }

    public static void Artikulationen(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {

                    }
                }
            }
        }