public class Hand {
    private int[] cards;
    private int bid;
    private int hand;

    public void setRank(int rank) {
        this.rank = rank;
    }

    private int rank;

    public int[] getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public int getHand() {
        return hand;
    }

    public int getRank() {
        return rank;
    }

    public Hand(int[] cards, int bid, int hand, int rank){
        this.cards = cards;
        this.bid = bid;
        this.hand = hand;
        this.rank = rank;
    }
}