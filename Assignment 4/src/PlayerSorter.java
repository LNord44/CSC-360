import java.io.*;
import java.util.*;


public class PlayerSorter {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();

        File file = new File("src/players.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()) {
            String fName = sc.next();
            String lName = sc.next();
            double score = sc.nextDouble();
            players.add(new Player(fName, lName, score)); {
                FileNotFoundException e;
            }
        }


        int dataSize = players.size();

        PriorityQueue<Player> playerNameLenPQ = new PriorityQueue<Player>(dataSize, new NameLengthComparator().reversed());
        PriorityQueue<Player> playerScorePQ = new PriorityQueue<Player>(dataSize, new ScoreComparator().reversed());

        for ( int i=0; i < dataSize; i++) {
            playerNameLenPQ.add(players.get(i));
            playerScorePQ.add(players.get(i));
        }

        System.out.println("--------- Name comparator -----------");
        System.out.printf("%-20s %-10s\n", "Name", "Score");

        removeAndPrintQueue(playerNameLenPQ);


        System.out.println("--------- Score Comparator ----------");
        System.out.printf("%-20s %-10s\n", "Name", "Score");

        removeAndPrintQueue2(playerScorePQ);

    }

    public static void removeAndPrintQueue(PriorityQueue<Player> playerNameLenPQ) {
        while (!playerNameLenPQ.isEmpty()) {
            Player obj = playerNameLenPQ.remove();
            System.out.printf("%-20s %.2f\n",obj.getName(),obj.getScore());
        }
    }

    public static void removeAndPrintQueue2(PriorityQueue<Player> playerScorePQ) {
        while (!playerScorePQ.isEmpty()) {
            Player obj = playerScorePQ.remove();
            System.out.printf("%-20s %.2f\n",obj.getName(),obj.getScore());
        }
    }
}

class Player {
    private final String fName;
    private final String lName;
    private final double score;

    public Player(String fName, String lName, double score) {
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }

    public String getName() {
        return fName+" "+lName;
    }

    public double getScore() {
        return score;
    }
}

class NameLengthComparator implements Comparator<Player> {
    public int compare(Player s1, Player s2) {
        if(s1.getName().length() < s2.getName().length()) {
            return 1;
        }
        else if (s1.getName().length() > s2.getName().length()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class ScoreComparator implements Comparator<Player> {
    public int compare(Player s1, Player s2) {
        if(s1.getScore() < s2.getScore()) {
            return 1;
        }
        else if (s1.getScore() > s2.getScore()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
