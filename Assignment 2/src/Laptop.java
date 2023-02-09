public class Laptop implements Comparable<Laptop>{
    double cpu,screenSize;
    int ram, hdd, weight, batteryLife, price, laptopScore, gpu;


    public Laptop(double cpu, double screenSize, int ram, int hdd, int weight, int batteryLife, int price, int gpu) {
        this.cpu=cpu;
        this.screenSize=screenSize;
        this.ram=ram;
        this.hdd=hdd;
        this.weight=weight;
        this.batteryLife=batteryLife;
        this.price=price;
        this.gpu=gpu;
        this.laptopScore= (int)((2 * cpu/3.0) + (2 * ram/32) + (1 * hdd/2048) + gpu + (1 * screenSize/ 17.0) + (1 * weight/6) + (1 * batteryLife/9) + (1 * price/2000));
    }

    public double getCpu() {
        return cpu;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public int getWeight() {
        return weight;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public int getPrice() {
        return price;
    }

    public int isGpu() {
        return gpu;
    }

    public static Laptop[] randomLaptopCreator(){
        double cpuMax = 3.0;
        int ramMax = 32;
        int hddMax = 2048;
        double screenMax = 17.0;
        int weightMax = 6;
        int batteryMax = 9;
        int priceMax = 2000;

        double cpuMin = 1.0;
        int ramMin = 8;
        int hddMin = 64;
        double screenMin = 12.0;
        int weightMin = 2;
        int batteryMin = 2;
        int priceMin = 500;

        Laptop laptopList[] = new Laptop[5];

        for (int j=0; j<5; j++) {
            double randCpu = (cpuMin + (int) (Math.random() * ((cpuMax - cpuMin) + 1)));
            int randRam = (ramMin + (int) (Math.random() * ((ramMax - ramMin) + 1)));
            int randHdd = (hddMin + (int) (Math.random() * ((hddMax - hddMin) + 1)));
            double randScreen = (screenMin + (int) (Math.random() * ((screenMax - screenMin) + 1)));
            int randWeight = (weightMin + (int) (Math.random() * ((weightMax - weightMin) + 1)));
            int randBattery = (weightMin + (int) (Math.random() * ((batteryMax - batteryMin) + 1)));
            int randPrice = (weightMin + (int) (Math.random() * ((priceMax - priceMin) + 1)));

            laptopList[j] = new Laptop(randCpu, randScreen, randRam, randHdd, randWeight, randBattery, randPrice, 1);
        }
        return laptopList;
    }


    @Override
    public String toString() {
        return "Laptop with cpu: " + getCpu() + ", screen size: " + getScreenSize() + ", ram: " + getRam() + ", hdd " + getHdd() + ", weight: " + getWeight() + ", battery life (in hours): " + getBatteryLife() + ", price: " + getPrice() + ", gpu: " + isGpu() + " laptop score: " + laptopScore + "\n";
    }

    @Override
    public int compareTo(Laptop other) {
        if (this.laptopScore < other.laptopScore) {
            return -1;
        } else if (this.laptopScore == other.laptopScore) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args){
        Laptop laptopList[] = randomLaptopCreator();

        // unsorted
        for (Laptop l : laptopList) {
            System.out.println(l);
        }

        // sorting
        java.util.Arrays.sort(laptopList);

        // sorted
        for (Laptop l : laptopList) {
            System.out.println(l);
        }
    }
}
/*
https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
https://liveexample.pearsoncmg.com/html/SortRectangles.html
method that sets random values for an object within a range java
 */