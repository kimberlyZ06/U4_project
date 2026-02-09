import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
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

        Hand[] allHands = new Hand[lines.length];

        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;
        int handCombo = 0;

        int index = 0;

        for (String line : lines) {
            int[] counter = new int[13];
            String[] bid = line.split("\\|");
            String bidValue = bid[0];
            int actualBidValue = Integer.parseInt(bid[1]);

            String[] numbers = bidValue.split(",");
            int[] values = new int[numbers.length];
            String[] object = new String[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j].equals("Jack")) {
                    values[j] = 11;
                } else if (numbers[j].equals("Queen")) {
                    values[j] = 12;
                } else if (numbers[j].equals("King")) {
                    values[j] = 13;
                } else if (numbers[j].equals("Ace")) {
                    values[j] = 14;
                } else {
                    values[j] = Integer.parseInt(numbers[j]);
                }
            }

            for (int k = 2; k <= 14 ; k++) {
                for (int j = 0; j < 5; j++){
                    if (values[j] == k){
                        counter[k -2] += 1;
                    }
                }
            }

            int triplet = 0;
            int two = 0;
            int singles = 0;

            for (int l = 0; l < 13; l++) {
                if (counter[l] == 5){
                    fiveOfAKind += 1;
                    handCombo = 7;
                } else if (counter[l] == 4){
                    fourOfAKind += 1;
                    handCombo = 6;
                } else if (counter[l] == 3){
                    triplet += 1;
                } else if (counter[l] == 2) {
                    two += 1;
                } else if (counter[l] == 1) {
                    singles += 1;
                }
            }


            if (triplet == 1 && two == 1){
                fullHouse += 1;
                handCombo = 5;
            } else if (triplet == 1) {
                threeOfAKind += 1;
                handCombo = 4;
            } else if (two == 2){
                twoPair += 1;
                handCombo = 3;
            } else if (two == 1) {
                onePair += 1;
                handCombo = 2;
            } else if (singles == 5) {
                highCard += 1;
                handCombo = 1;
            }

            Hand h = new Hand(values, actualBidValue, handCombo);
            allHands[index] = h;

            index++;
        }

        for (int i = 0; i < allHands.length; i++){
            System.out.println("----------");
            System.out.println(allHands[i].getHand());
            System.out.println(allHands[i].getBid());
            System.out.println(Arrays.toString(allHands[i].getCards()));
        }



    }
}
