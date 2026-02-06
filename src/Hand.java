public class Hand {
    private int bid;
    private int[] cards;
    private int rank;

    public Hand (int[] cards, int bid, int rank){
        this.cards = cards;
        this.bid = bid;
        this.rank = rank;
    }
}