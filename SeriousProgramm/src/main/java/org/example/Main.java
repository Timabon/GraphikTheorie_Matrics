package org.example;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       //displayTwoNumbers();
        //multiplyTill10();
        //specific();
        //average();
        //MarkLOX();
    }

    public static void displayTwoNumbers(){
        System.out.println("Enter first Number");
       int x = sc.nextInt();
        System.out.println("Enter second Number");
       int y = sc.nextInt();
        System.out.println(x + y);
        System.out.println(x * y);
        System.out.println(x - y);
        System.out.println(x / y);
    }

    public static void multiplyTill10(){
        System.out.println("Enter first Number");
        int x = sc.nextInt();
        for (int i = 1; i <= 10; i++){
            System.out.println(x * i);
        }
    }

    public static void specific(){
        System.out.println("Enter Radius: ");
        double x = sc.nextDouble();
        System.out.println("Perimetr is = " + x * 2 * 3.14);
        System.out.println("Area is = " + x * 3.14);
    }

    public static void average(){
        System.out.println("Enter first Number: ");
        int x = sc.nextInt();
        System.out.println("Enter second Number: ");
        int y = sc.nextInt();
        System.out.println("Enter third Number: ");
        int z = sc.nextInt();
        double d = (x + y + z) / 3;
        System.out.println("AVG is: " + d);
    }

    public static void addBinary(){
        int x = sc.nextInt();
        int z = sc.nextInt();

    }

    public static void MarkLOX(){
        for(int i = 0; i <= 100; i++){
            System.out.println("MARK LOH");
        }
    }}