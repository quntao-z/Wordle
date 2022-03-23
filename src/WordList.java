import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
    private ArrayList<String> wordList;

    public void importWordList(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            wordList = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] wordFromTXT = line.split("\\r?\\n");

                for(int i = 0; i < wordFromTXT.length; i++){
                    wordList.add(wordFromTXT[i]);
                }

            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }
}
