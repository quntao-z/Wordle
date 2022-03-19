import java.util.ArrayList;

public class Word {
    private String word;
    private WordList wordList;

    public Word(){
        wordList = new WordList();
        wordList.importWordList("src\\Words.txt");
        word = wordList.getWordList().get((int)(Math.random()* 12972));
    }



    public String getWord() {
        return word;
    }
}





