/**
 * This class represents a Word object
 *
 * @author Quntao Zheng
 */

import java.util.ArrayList;

public class Word {
   /** The word chosen for the game */
    private String word;
    /** The word list where thw word come from */
    private WordList wordList;


    /** Instantiates a Word object*/
    public Word(){
        wordList = new WordList();
        wordList.importWordList("src\\Words.txt");
        word = wordList.getWordList().get((int)(Math.random()* 12972));
    }


    /**
     * Return a word chosen from word list
     * @return the word
     */
    public String getWord() {
        return word;
    }
}





