public class TestOctagon {
    public static void main(String[] args)
    throws CloneNotSupportedException {
        Octagon o1 = new Octagon(5.0);
        System.out.println(o1);
        Octagon o2 = (Octagon)o1.clone();
        System.out.println(o2);
        System.out.println("o1.compareTo(o2) : " + o1.compareTo(o2));
    }
}
