
import java.util.Scanner;
public class Wordle {
    private String answer;
    private Grid board;
    private Scanner scan;

    public void play() {
        Word word = new Word();
        answer = word.getWord();
        board = new Grid();
        scan = new Scanner(System.in);
        int counter = 0;
        boolean win = false;

        System.out.println("Welcome to Wordle! \nTry to guess the word! \n");


        while (counter < 6 && !win) {
            clearScreen();
            System.out.print("What is your guess? ");
            String guess = scan.nextLine();
            String validGuess = validityOfGuess(guess);
            evaluateGuess(validGuess.toLowerCase(), counter);
            board.getBoard();
            if (validGuess.equals(answer)) {
                System.out.println("\nCongrats you won, the word was " + answer + "!");
                win = true;
            }
            counter++;
        }

        if (!win)
        {
            System.out.println("\nSorry, you lost the word was " + answer + ".");
        }
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
        while(!(guess.length() == 5) || guess.contains("0") || guess.contains("1") || guess.contains("2") || guess.contains("3") || guess.contains("4") || guess.contains("5") || guess.contains("6") || guess.contains("7") || guess.contains("8") || guess.contains("9")){
            System.out.println("Invalid Guess! Try again");
            System.out.print("What is your guess? ");
            validGuess = scan.nextLine();
            clearScreen();
            if(validGuess.length() == 5 && !(validGuess.contains("0") || validGuess.contains("1") || validGuess.contains("2") || validGuess.contains("3") || validGuess.contains("4") || validGuess.contains("5") || validGuess.contains("6") || validGuess.contains("7") || validGuess.contains("8") || validGuess.contains("9"))){
                break;
            }
        }

        clearScreen();
        return validGuess;

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}




