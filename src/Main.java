import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         int fiveOfAKind = 0;
         int fourOfAKind = 0;
         int fullHouse = 0;
         int threeOfAKind = 0;
         int twoPair = 0;
         int onePair = 0;
         int highCard = 0;
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] lines = fileData.split("\n");

        for(String line : lines){
            String[] bid = line.split("\\|");
            String bidValue = bid[0];

            Hand hand1 = new Hand(bidValue);
            System.out.println(Arrays.toString(hand1.getCardvals()));
            System.out.println(hand1.handtype(hand1.getCardvals()));
        }


//        System.out.println("Five of a kind: " + fiveOfAKind);
//        System.out.println("Four of a kind: " + fourOfAKind);
//        System.out.println("Full house: " + fullHouse);
//        System.out.println("Three of a Kind: " + threeOfAKind);
//        System.out.println("Two pair: " + twoPair);
//        System.out.println("One pair: " + onePair);
//        System.out.println("High card: " + highCard);
    }
}
