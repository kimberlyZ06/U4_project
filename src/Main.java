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
            String[] numbers = line.split(",");
            int[] values = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals("Jack")){
                    values[i] = 11;
                } else if (numbers[i].equals("Queen")) {
                    values[i] = 12;
                } else if (numbers[i].equals("King")) {
                    values[i] = 13;
                } else if (numbers[i].equals("Ace")){
                    values[i] = 14;
                } else {
                    values[i] = Integer.parseInt(numbers[i]);
                }
            }
            System.out.println(Arrays.toString(values));

            int triplet = 0;
            int two = 0;
            int counter = 0;

            int index0 = values[0];
            for (int j = 0; j < values.length; j++) {
                int firstNum = values[j];
                values[j] = 0;
                System.out.println(firstNum);
                for (int i = j + 1; i < values.length; i++) {
                    if (firstNum == values[i] && values[i] != 0) {
                        counter += 1;
                        values[i] = 0;
                    }

                    System.out.println("counter: " + counter);
                }
            }

            if (counter == 2){
                triplet += 1;
            } else if (counter == 1) {
                two += 1;
            }

            System.out.println("triplet: " + triplet);
            System.out.println("two: " + two);
        }
        System.out.println("five: " + fiveOfAKind);
        System.out.println("four: " + fourOfAKind);
        System.out.println("full house: " + fullHouse);
        System.out.println("three: " + threeOfAKind);
        System.out.println("two pair: " + twoPair);
        System.out.println("one pair: " + onePair);
        System.out.println("high card: " + highCard);
    }
}
