package WorkingWithAbstraction_CardsWithPowerEx03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();

        Card card = new Card(CardsRanks.valueOf(rank), CardsSuits.valueOf(suit));

        System.out.println(card);
    }
}
