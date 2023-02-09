public class Exception4 {
    public static void foo() {
        try {
            System.out.println("Entering try");
            int[] a = new int[10];
            a[9] = 1;
            System.out.println("Leaving try");
        }
        finally {
            System.out.println("Finally clause in foo is executed");
        }
    }
    public static void main(String[] args) {
        try {
            foo();
        }
        catch (Exception ex) {
            System.out.println("Catch clause in main is executed");
        }
    }

}
