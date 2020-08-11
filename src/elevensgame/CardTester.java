/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        Card c1 = new Card("ace", "hearts", 1);
        Card c2 = new Card("ace", "hearts", 1);
        Card c3 = new Card("ace", "hearts", 2);
        Card c4 = new Card("ace", "spades", 1);
        Card c5 = new Card("king", "hearts", 1);
        Card c6 = new Card("queen", "clubs", 3);
        
        System.out.println("Suit: " + c1.suit() + " Rank: " + c1.rank() + " Point Value: " + c1.pointValue());
        System.out.println("Suit: " + c2.suit() + " Rank: " + c2.rank() + " Point Value: " + c2.pointValue());
        System.out.println("Suit: " + c3.suit() + " Rank: " + c3.rank() + " Point Value: " + c3.pointValue());

    }
}
