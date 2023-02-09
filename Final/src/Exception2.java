public class Exception2 {
    public static void foo() {
        try {
            System.out.println("Entering try");
            int[] a = new int[10];
            a[10] = 1;
            System.out.println("Leaving try");
        } catch (Exception ex) {
            System.out.println("Catch clause in foo is executed");
            throw ex;
        } finally {
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
