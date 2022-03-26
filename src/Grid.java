/**
 * This class represents a Grid object
 *
 * @author Quntao Zheng
 */


public class Grid {
    /** The board of Wordle */
    private String[][] board;
    /** Green for correct letter and position */
    public static final String GREEN = "\u001B[32m";
    /** Yellow for correct letter and wrong position */
    public static final String YELLOW = "\u001B[33m";
    /** Red for incorrect letter */
    public static final String RED = "\u001B[31m";
    /** Gray for the board */
    public static final String NORMAL = "\u001B[0m";

    /** Instantiates a Grid object */

    public Grid(){
        board = new String[6][5];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = "_";
            }
        }
    }

    /**
     * Draws the current board of the Wordle game
     */
    public void getBoard() {
        for(String[] row : board)
        {
            for(String col : row)
            {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /**
     * Fills the letter as Green
     * @param row The current row of the letter
     * @param col The current column of the letter
     * @param letter The letter
     */
    public void fillInGreen(int row, int col, String letter){
        board[row][col] = GREEN + letter + NORMAL;
    }
    /**
     * Fills the letter as Yellow
     * @param row The current row of the letter
     * @param col The current column of the letter
     * @param letter The letter
     */
    public void fillInYellow(int row, int col, String letter){
        board[row][col] = YELLOW + letter + NORMAL;
    }
    /**
     * Fills the letter as Red
     * @param row The current row of the letter
     * @param col The current column of the letter
     * @param letter The letter
     */
    public void fillInRED(int row, int col, String letter){
        board[row][col] = RED + letter + NORMAL;
    }
}
