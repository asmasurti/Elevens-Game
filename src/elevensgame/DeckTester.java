/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        String[] arrSuits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] arrRanks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Jack", "Queen", "King"};
        int[] arrValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
        
        Deck d1 = new Deck(arrRanks, arrSuits, arrValues);
        System.out.println("Number of cards: " + d1.size());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Card dealt: " + d1.deal());
        System.out.println("Number of cards: " + d1.size());
        
        System.out.println(d1);
    }
}

