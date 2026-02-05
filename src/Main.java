import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        for (String line : lines) {
            int[] counter = new int[13];
            String[] bid = line.split("\\|");
            String bidValue = bid[0];

            String[] numbers = bidValue.split(",");
            int[] values = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals("Jack")) {
                    values[i] = 11;
                } else if (numbers[i].equals("Queen")) {
                    values[i] = 12;
                } else if (numbers[i].equals("King")) {
                    values[i] = 13;
                } else if (numbers[i].equals("Ace")) {
                    values[i] = 14;
                } else {
                    values[i] = Integer.parseInt(numbers[i]);
                }
            }
            System.out.println(Arrays.toString(values));

            for (int i = 2; i <= 14 ; i++) {
                for (int j = 0; j < 5; j++){
                    if (values[j] == i){
                        counter[i-2] += 1;
                    }
                }
            }
            System.out.println(Arrays.toString(counter));

            int triplet = 0;
            int two = 0;
            int singles = 0;

            for (int i = 0; i < 13; i++) {
                if (counter[i] == 5){
                    fiveOfAKind += 1;
                } else if (counter[i] == 4){
                    fourOfAKind += 1;
                } else if (counter[i] == 3){
                    triplet += 1;
                } else if (counter[i] == 2) {
                    two += 1;
                } else if (counter[i] == 1) {
                    singles += 1;
                }
            }

            System.out.println("triplet: " + triplet);
            System.out.println("double: " + two);
            System.out.println("singles: " + singles);

            if (triplet == 1 && two == 1){
                fullHouse += 1;
            } else if (triplet == 1) {
                threeOfAKind += 1;
            } else if (two == 2){
                twoPair += 1;
            } else if (two == 1) {
                onePair += 1;
            } else if (singles == 5) {
                highCard += 1;
            }
        }

        System.out.println("five: " + fiveOfAKind);
        System.out.println("full house: " + fullHouse);
        System.out.println("four: " + fourOfAKind);
        System.out.println("three: " + threeOfAKind);
        System.out.println("two pair: " + twoPair);
        System.out.println("one pair: " + onePair);
        System.out.println("high card: " + highCard);
    }
}
