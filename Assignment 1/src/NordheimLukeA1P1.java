/*
    Luke Nordheim
    Course: CSC 360
    June 6, 2021
    Assignment 1
    Instructor: Dr. Khan
 */

import java.util.Scanner;

public class NordheimLukeA1P1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;

        System.out.println("Enter first integer: ");
        boolean loop = true;

        while(loop){
            try {
                num1 = sc.nextInt();
                loop = false;
            }
            catch (Exception E){
                System.out.println("Try again. (Incorrect input: an integer is required)");
                sc.nextLine();
            }
        }

        System.out.println("Enter second integer: ");
        loop = true;
        while(loop){
            try {
                num2 = sc.nextInt();
                loop = false;
            }
            catch (Exception E){
                System.out.println("Try again. (Incorrect input: an integer is required)");
                sc.nextLine();
            }
        }

        int sum = num1 + num2;
        System.out.println("The sum is " + sum);

        sc.close();
    }
}
