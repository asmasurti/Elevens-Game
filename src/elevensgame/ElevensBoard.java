
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS
            = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS
            = {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES
            = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal. In
     * Elevens, the legal groups are (1) a pair of non-face cards whose values
     * add to 11, and (2) a group of three cards consisting of a jack, a queen,
     * and a king in some order.
     *
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal; false
     * otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        return this.containsPairSum11(selectedCards) || this.containsJQK(selectedCards);
    }

    /**
     * Determine if there are any legal plays left on the board. In Elevens,
     * there is a legal play if the board contains (1) a pair of non-face cards
     * whose values add to 11, or (2) a group of three cards consisting of a
     * jack, a queen, and a king in some order.
     *
     * @return true if there is a legal play left on the board; false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {  
        List<Integer> boardCards = this.cardIndexes();
        List<String> arrRanks = new ArrayList();
        int[] arrValues = new int[boardCards.size()];  
        Boolean isPossible = false;
        
        for(int intI = 0; intI < arrValues.length; intI++) {
            if(this.cardAt(boardCards.get(intI)).pointValue() != 0)
                arrValues[intI] = this.cardAt(boardCards.get(intI)).pointValue();
            else 
                arrRanks.add(this.cardAt(boardCards.get(intI)).rank());
        }
        
        for(int intI = 0; intI < arrValues.length; intI++) {
            for(int intJ = 0; intJ < arrValues.length; intJ++) {
                if(arrValues[intI] + arrValues[intJ] == 11) 
                    isPossible = true;                  
            }          
        }
        
        if(arrRanks.indexOf("jack") > -1 && arrRanks.indexOf("queen") > -1 && arrRanks.indexOf("king") > -1) 
            isPossible = true;  
        
        return isPossible;
    }

    /**
     * Check for an 11-pair in the selected cards.
     *
     * @param selectedCards selects a subset of this board. It is list of
     * indexes into this board that are searched to find an 11-pair.
     * @return true if the board entries in selectedCards contain an 11-pair;
     * false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        if(selectedCards.size() != 2) {
            return false;
        }
        else {
            Card c1 = this.cardAt(selectedCards.get(0));
            Card c2 = this.cardAt(selectedCards.get(1));
            
            return (c1.pointValue() + c2.pointValue()) == 11;          
        }
    }

    /**
     * Check for a JQK in the selected cards.
     *
     * @param selectedCards selects a subset of this board. It is list of
     * indexes into this board that are searched to find a JQK group.
     * @return true if the board entries in selectedCards include a jack, a
     * queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
       if(selectedCards.size() != 3) {
            return false;
        }
        else {
            Card c1 = this.cardAt(selectedCards.get(0));
            Card c2 = this.cardAt(selectedCards.get(1));
            Card c3 = this.cardAt(selectedCards.get(2));
            
            if(c1.rank().equals(c2.rank()) || c2.rank().equals(c3.rank()) || c3.rank().equals(c1.rank()))
                return false;
            
            if(c1.rank().equals("jack") || c1.rank().equals("queen") || c1.rank().equals("king")) {
                if(c2.rank().equals("jack") || c2.rank().equals("queen") || c2.rank().equals("king")) {
                    if(c3.rank().equals("jack") || c3.rank().equals("queen") || c3.rank().equals("king"))
                        return true;
                }
            }     
        }
        return false;
    }
}