import java.util.Arrays;

public class GameWord {

    private static String content;


    public GameWord(String word){
        content = word; 
    }

    public String reverse(){
        String reversed = "";
        for (int i = content.length()-1; i >= 0; i--)
            reversed+=content.charAt(i);
        return reversed;   
    }

    public boolean anagram(String word){
        char []contentArray = content.toCharArray();
        char []wordArray = word.toCharArray();

        Arrays.sort(contentArray);
        Arrays.sort(wordArray);
        return false;
    }
}
