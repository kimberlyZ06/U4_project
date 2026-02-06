//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Hand {
//
//    private String[] data;
//    private int bidValue;
//
//
//    public int[] getCardvals() {
//        return cardvals;
//    }
//
//    private int[] cardvals;
//
//    public Hand(String data) {
//        String fileData = "";
//        try {
//            File f = new File("src/data");
//            Scanner s = new Scanner(f);
//
//            while (s.hasNextLine()) {
//                String line = s.nextLine();
//                fileData += line + "\n";
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//
//        String[] lines = fileData.split("\n");
//            String line = fileData;
//            System.out.println("line: " + line);
//            String[] bid = line.split("\\|");
//            String cardValue = bid[0];
//
//            String[] numbers = cardValue.split(",");
//            int[] cards = new int[numbers.length];
//
//            for (int i = 0; i < numbers.length; i++) {
//                if (numbers[i].equals("Jack")) {
//                    cards[i] = 11;
//                } else if (numbers[i].equals("Queen")) {
//                    cards[i] = 12;
//                } else if (numbers[i].equals("King")) {
//                    cards[i] = 13;
//                } else if (numbers[i].equals("Ace")) {
//                    cards[i] = 14;
//                } else {
//                    cards[i] = Integer.parseInt(numbers[i]);
//                }
//            }
//            cardvals = cards;
//        }
//
//    public String handtype(int[] cardvals) {
//
//        int[] counter = new int[13];
//        for (int i = 2; i <= 14; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (cardvals[j] == i) {
//                    counter[i - 2] += 1;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(counter));
//
//        int triplet = 0;
//        int two = 0;
//        int singles = 0;
//
//        for (int i = 0; i < 13; i++) {
//            if (counter[i] == 5) {
//                return "five";
//            } else if (counter[i] == 4) {
//                return "four";
//            } else if (counter[i] == 3) {
//                triplet += 1;
//            } else if (counter[i] == 2) {
//                two += 1;
//            } else if (counter[i] == 1) {
//                singles += 1;
//            }
//        }
//
//        if (triplet == 1 && two == 1) {
//            return "full";
//        } else if (triplet == 1) {
//            return "three";
//        } else if (two == 2) {
//            return "two";
//        } else if (two == 1) {
//            return "one";
//        } else if (singles == 5) {
//            return "high";
//        }
//        return "";
//    }
//}
//
