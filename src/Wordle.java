
import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {
    private Word word;
    private String answer;
    private Grid board;
    private Scanner scan;
    private Player[] playerList;

    public void play() {
        Word word = new Word();
        answer = word.getWord();
        board = new Grid();
        scan = new Scanner(System.in);


        System.out.println("Welcome to multiplayer Wordle! \nHow many players are there? ");
        int numOfPlayer = scan.nextInt();
        playerList = new Player[numOfPlayer];

        for(int i = 1; i < playerList.length +1 ; i++ ){
            System.out.print("Player " + i + " What is your name? ");
            String playerName = scan.nextLine();
            playerList[i-1] = new Player(scan.nextLine());
        }

        System.out.println("How many rounds of Wordle do you want to play?");
        int numOfRounds = scan.nextInt();

        for(int j = 0; j < numOfRounds; j++){
            for(int i = 0; i < playerList.length; i++) {
                System.out.println(playerList[i].getName() + ", it is your turn! ");
                if (wordleLogic()) {
                    playerList[i].setScore(playerList[i].getScore() + 1);
                }
                word = new Word();
                answer = word.getWord();
                board = new Grid();
            }
        }

        int highestScore = 0;
        for(int i = 0 ; i < playerList.length; i++){
            if(playerList[i].getScore() > highestScore){
                highestScore = playerList[i].getScore();
            }
        }

        ArrayList<String> winner = new ArrayList<>();
        for(int i = 0; i < playerList.length; i++){
            if(playerList[i].getScore() == highestScore){
                winner.add(playerList[i].getName());
            }
        }

        System.out.println();
        System.out.println("Game Over \nAnd the Winner is .............");
        for(String name : winner){
            System.out.println(name);
        }


    }

    public boolean wordleLogic(){
        int counter = 0;
        boolean win = false;
        while (counter < 6 && !win) {

            System.out.print("What is your guess? ");
            String guess = scan.nextLine();
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
            System.out.println("\nSorry, you lost the word was " + answer + ".");
        }
        return win;
    }

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




