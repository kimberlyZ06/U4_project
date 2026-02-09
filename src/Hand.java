public class Hand {
    private int[] cards;
    private int bid;

    public int[] getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public int getHand() {
        return hand;
    }

    private int hand;

    public Hand(int[] cards, int bid, int hand){
        this.cards = cards;
        this.bid = bid;
        this.hand = hand;
    }
}