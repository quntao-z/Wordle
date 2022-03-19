public class Grid {
    private String[][] board;
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String NORMAL = "\u001B[0m";


    public Grid(){
        board = new String[6][5];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = "_";
            }
        }
    }

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

    public void fillInGreen(int row, int col, String condition){
        board[row][col] = GREEN + condition + NORMAL;
    }
    public void fillInYellow(int row, int col, String condition){
        board[row][col] = YELLOW + condition + NORMAL;
    }
    public void fillInRED(int row, int col, String condition){
        board[row][col] = RED + condition + NORMAL;
    }
}
