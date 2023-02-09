/*
    Luke Nordheim
    Course: CSC 360
    June 6, 2021
    Assignment 1
    Instructor: Dr. Khan
 */

import java.io.File;
import java.util.Scanner;

public class NordheimLukeA1P2 {
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of input file: ");
        String fileName = sc.next();
        String yourFilePath = "C:\\Users\\luken\\OneDrive\\Documents\\NKU\\SUMMER 2021\\CSC 360\\Assignment 1\\src\\" + fileName;

        File file = new File(yourFilePath);
        int parseCount=0;
        int unparsableCount=0;
        double average;
        int value = 0;

        try{
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String line = input.nextLine();
                try{
                    value = value + Integer.parseInt(line);
                    parseCount++;
                }
                catch (NumberFormatException e){
                    System.out.println("Cannot parse " + line + " as an integer.");
                    unparsableCount++;
                }
            }
            input.close();
        }
        catch (Exception ex) {
            System.out.println("Could not find file: " + fileName);
            System.exit(1);
        }
        System.out.println("Number of parsable lines: " + parseCount);
        average = (double) value / parseCount;
        System.out.println("Average value: " + average);
        System.out.println("Number of unparsable lines: " + unparsableCount);
        sc.close();
    }
}
