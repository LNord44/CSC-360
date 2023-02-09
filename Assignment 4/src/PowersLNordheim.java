import java.util.Scanner;
import java.lang.Math;

public class PowersLNordheim {
    private static int multiplications;

    public static double power1(double base, int n) {
        double result = base;
        for (int i = 1; i < n; i++) {
            multiplications++;
            result = result * base;
        }
        multiplications++;
        return result;
    }

    public static double power2(double base, int n) {
        if (n > 0) {
            multiplications++;
            return (base * power2(base, n - 1));
        }
        else {
            return 1;
        }
    }

    public static double power3(double base, int n) {
        if (n > 0 && n % 2 == 0) {
            multiplications++;
            double noteVariable = power3(base, (n / 2));
            return (noteVariable * noteVariable);
        }
        else if (n > 0 && n % 2 == 1) {
            multiplications = multiplications + 2;
            double noteVariable = power3(base, (n / 2));
            return (base * noteVariable * noteVariable);
        }
        else {
            return 1;
        }
    }

    public static double multPow(double a, double base, int n) {
        if (n == 0) {
            return a;
        }
        else if (n > 0 && n % 2 == 0) {
            multiplications++;
            return multPow(a, base * base, n /2);
        }
        else {
            multiplications = multiplications + 2;
            return multPow(a * base, base * base, n / 2);
        }
    }

    public static double power4(double base, int n) {
        return multPow(1, base, n);
    }

    public static double power5(double base, int n) {
        double a = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                multiplications = multiplications + 2;
                a = a * base;
                base = base * base;
            }
            else {
                multiplications++;
                base = base * base;
            }
            n = n / 2;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        double base = input.nextDouble();
        System.out.println("Enter a non-negative integer exponent: ");
        int n = input.nextInt();
        double result = Math.pow(base, n);
        System.out.println("\nComputing " + base + " to the power of " + n + ": ");
        System.out.println("Math.pow(" + base + ", " + n + ")= " + result);
        multiplications = 0;
        double pow1 = power1(base, n);
        System.out.println("\npower1(" + base + ", " + n + ")= " + pow1);
        System.out.println("Multiplications = " + multiplications);
        multiplications = 0;
        double pow2 = power2(base, n);
        System.out.println("\npower2(" + base + ", " + n + ")= " + pow2);
        System.out.println("Multiplications = " + multiplications);
        multiplications = 0;
        double pow3 = power3(base, n);
        System.out.println("\npower3(" + base + ", " + n + ")= " + pow3);
        System.out.println("Multiplications = " + multiplications);
        multiplications = 0;
        double pow4 = power4(base, n);
        System.out.println("\npower4(" + base + ", " + n + ")= " + pow4);
        System.out.println("Multiplications = " + multiplications);
        multiplications = 0;
        double pow5 = power5(base, n);
        System.out.println("\npower5(" + base + ", " + n + ")= " + pow5);
        System.out.println("Multiplications = " + multiplications);

    }
}
