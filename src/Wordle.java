/**
 * This class represents a Wordle object
 *
 * @author Quntao Zheng
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {


    /**The answer for the game */
    private String answer;
    /**The board the game */
    private Grid board;
    /**Scanner1 for the game */
    private Scanner scan;
    /**Scanner2 for the game */
    private Scanner scan2;

    /**
     *  Playing the Wordle Game that includes the set-up(asking for number of players and rounds), wordle logic and winners (name of players with highest score).
     */
    public void play() {
        Word word = new Word();
        answer = word.getWord();
        board = new Grid();
        scan = new Scanner(System.in);
        scan2 = new Scanner(System.in);
        Player[] playerList;

        System.out.print("Welcome to multiplayer Wordle! \nHow many players are there? ");
        int numOfPlayer = scan.nextInt();
        playerList = new Player[numOfPlayer];

        System.out.println();
        for(int i = 1; i < playerList.length +1 ; i++ ){
            System.out.print("Player " + i + ", What is your name? ");
            String playerName = scan2.nextLine();
            playerList[i-1] = new Player(playerName);
        }
        System.out.println();

        System.out.print("How many rounds of Wordle do you want to play? ");
        int numOfRounds = scan.nextInt();

        System.out.println();
        for(int j = 0; j < numOfRounds; j++){
            for (Player player: playerList)
            {
                System.out.println(player.getName() + ", it is your turn! ");
                if (wordleLogic()) {
                    player.setScore(player.getScore() + 1);
                }
                word = new Word();
                answer = word.getWord();
                board = new Grid();
            }
        }

        int highestScore = 0;

        for(Player player: playerList){
            if(player.getScore() > highestScore){
                highestScore = player.getScore();
            }
        }

        ArrayList<String> winner = new ArrayList<>();
        for(Player player: playerList){
            if(player.getScore() == highestScore){
                winner.add(player.getName());
            }
        }

        System.out.println();
        System.out.println("Game Over \nAnd the winner is .............");
        for(String name : winner){
            System.out.println(name);
        }


    }

    /** Returns a boolean if the player was able to guess the word.
     * <p>
     *     Asks the player for a guess and if the guess matches the answer they get a point.
     *
     * </p>
     *
     * @return true if player guessed the word right and false if player could not guess the word
     */
    public boolean wordleLogic(){
        int counter = 0;
        boolean win = false;
        while (counter < 6 && !win) {

            System.out.print("What is your guess? ");
            String guess = scan2.nextLine();
            String validGuess = validityOfGuess(guess);
            evaluateGuess(validGuess.toLowerCase(), counter);
            board.getBoard();
            if (validGuess.equals(answer)) {
                System.out.println("\nCongrats you get a point, the word was " + answer + "!");
                win = true;
            }
            counter++;
        }

        if (!win)
        {
            System.out.println("\nThe word was " + answer + ".");
        }
        System.out.println();
        return win;
    }


    /**
     *      Evaluate the player's guess split the answer and guess into letters and comparing the two.
     *      Each guess is filled with hints, green means the letter is in that position, yellow means the letter exist in the answer but not in that position and red means that letter doesn't exist in the answer.
     *
     * @param guess The string of guess
     * @param tries The current number of tries
     */
    public void evaluateGuess(String guess, int tries) {
        String[] letterOfGuess = guess.split("(?!^)");
        String[] letterOfAnswer = answer.split("(?!^)");
        for(int i = 0; i < 5; i++) {
            if (letterOfGuess[i].equals(letterOfAnswer[i])) {
                board.fillInGreen(tries, i, letterOfGuess[i]);
            }
            else{
                board.fillInRED(tries, i, letterOfGuess[i]);
                for (int j = 0; j < 5; j++) {
                    if(letterOfGuess[i].equals(letterOfAnswer[j])) {
                        board.fillInYellow(tries, i, letterOfGuess[i]);
                    }
                }
            }

        }


    }

    /**
     * A guess is evaluated to see if it 5 letters long without symbols or numbers.
     * If the guess is not 5 letters long and contain symbols or letters, the player is prompted to keep entering a valid guess until the guess is valid.
     *
     * @param guess The guess as a String
     * @return a valid guess as a String
     */
    public String validityOfGuess(String guess) {
        String validGuess = guess;
        while(validGuess.length() != 5 || !(validGuess.matches("[a-zA-Z]+")) || validGuess.contains("0") || validGuess.contains("1") || validGuess.contains("2") || validGuess.contains("3") || validGuess.contains("4") || validGuess.contains("5") || validGuess.contains("6") || validGuess.contains("7") || validGuess.contains("8") || validGuess.contains("9")){
            System.out.println("Invalid Guess! Try again");
            System.out.print("What is your guess? ");
            validGuess = scan.nextLine();
        }
        return validGuess;
    }



}




