public class ComputeRecursion {
    public static void main(String[] args) {
        System.out.println(compute(235));
    }
    public static int compute(int n) {
        System.out.println(n);
        if (n < 10) {
            return n;
        }
        else {
            return (n % 10) * compute(n / 10);
        }
    }
}
