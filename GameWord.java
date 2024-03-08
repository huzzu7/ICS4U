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
}
