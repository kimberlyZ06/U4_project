public class Hand {
    private int[] cards;
    private int bid;
    private int hand;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int[] getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public int getHand() {
        return hand;
    }


    public Hand(int[] cards, int bid, int hand, int rank) {
        this.cards = cards;
        this.bid = bid;
        this.hand = hand;
        this.rank = rank;
    }

    public boolean isStronger(int handCurrent, int handBefore, int[] cardsCurrent, int[] cardsBefore) {
        if (handCurrent > handBefore) {
            return true;
        } else if (handCurrent < handBefore) {
            return false;
        } else if (handCurrent == handBefore) {
            for (int i = 0; i < 5; i++) {
                if (cardsCurrent[i] > cardsBefore[i]) {
                    return true;
                } else if (cardsCurrent[i] < cardsBefore[i]) {
                    return false;
                } else if (cardsCurrent[i] == cardsBefore[i]){
                    i += 0;
                }
            }
        }
        return false;
    }
}