package com.dhruvik;

import java.util.Scanner;

public class Main {
    public static double pow(double x, double y) {
        return Math.pow(x, y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Press enter to continue ");
       sc.nextLine();
        System.out.println("Enter the number to calculate: ");
        double x = sc.nextDouble();
        System.out.println("Enter the number to calculate: ");
        double y = sc.nextDouble();
        System.out.println("Answer is: " + pow(x, y));
    }
}

//ngrok http 8080