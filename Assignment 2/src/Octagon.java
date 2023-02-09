public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    private double side;
    private boolean wasCloned = false;

    public Octagon(double side){
        this.side=side;
    }

    public double getSide() {
        return side;
    }

    public double getArea(){
        double area;
        area = (2 + 4 / Math.sqrt(2)) * side * side;
        return area;
    }

    public double getPerimeter() {
        double perimeter;
        perimeter = side * 8;
        return perimeter;
    }

    @Override
    public Object clone() {
        wasCloned = true;
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public int compareTo(Octagon other) {
        if (this.getArea() < other.getArea()) {
            return -1;
        } else if (this.getArea() == other.getArea()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Octagon with side = " + getSide() + ", perimeter = " + getPerimeter() + ", area = " + getArea() + ", wasCloned = " + wasCloned;
    }
}



