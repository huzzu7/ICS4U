/* GameWord.java
 * Huzaifa Mohammed
 * Class that allows a user to play Scrabble with added utility
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameWord {
    
    //string content of the word object
    private String content;

    //character - integer hash map to store character point value
    private final Map<Character, Integer> charValue;

    //direction of the word being placed
    static int RIGHT = 1;
    static int DOWN  = 2;

    //2D array of the Scrabble board
    private int[][] board = {
        {5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5}, 
        {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1}, 
        {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1}, 
        {1, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 1}, 
        {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1}, 
        {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1}, 
        {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1}, 
        {5, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 5}, 
        {1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1}, 
        {1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1}, 
        {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1}, 
        {1, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 1}, 
        {1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1}, 
        {1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1}, 
        {5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5}, 
    };

    //Constrcutor
    public GameWord(String word){
        
        //store the string
        content = word;

        //store each character and its corresponding points
        charValue = new HashMap<>();
        charValue.put('E', 1);
        charValue.put('A', 1);
        charValue.put('I', 1);
        charValue.put('O', 1);
        charValue.put('N', 1);
        charValue.put('R', 1);
        charValue.put('T', 1);
        charValue.put('L', 1);
        charValue.put('S', 1);
        charValue.put('U', 1);
        charValue.put('D', 2);
        charValue.put('G', 2);
        charValue.put('B', 3);
        charValue.put('C', 3);
        charValue.put('M', 3);
        charValue.put('P', 3);
        charValue.put('F', 4);
        charValue.put('H', 4);
        charValue.put('V', 4);
        charValue.put('W', 4);
        charValue.put('Y', 4);
        charValue.put('K', 5);
        charValue.put('J', 8);
        charValue.put('X', 8);
        charValue.put('Q', 10);
        charValue.put('Z', 10);
    }

    //method to calculate points of a move
    public int pointValue(int x, int y, int direction){
        content = content.toUpperCase();
        char[] letters = content.toCharArray();
        int wordMultiplier = 1;
        int pt = 0;
        int moveRight = 0;
        int moveDown = 0;

        //flag to determine direction of move
        if (direction == RIGHT){
            moveRight = 1;
        }
        else{
            moveDown = 1;
        }

        //iterate through the word and get corresponding "multipliers"
        for (int i = 0; i < letters.length; i++){
          int pos = board[y+(i*moveDown)][x+(i*moveRight)];

          //add the character value after multiplying it by a letter multiplier
          if (pos < 4){
            pt+= charValue.get(letters[i])*pos;
          }

          //account for the whole word multiplier
          else{
            pt+=charValue.get(letters[i]);
            wordMultiplier *= board[y][x]-2;
          }
        }

        //multiply the whole word at the end
        pt*=wordMultiplier;

        return pt;
    }

    //method to return reverse of the word
    public String reverse(){
        String reversed = "";

        //iterate through the string backward and concatenate the letters
        for (int i = content.length()-1; i >= 0; i--)
            reversed+=content.charAt(i);
        return reversed;   
    }

    //method to determine if a word is an anagram of the object
    public boolean anagram(String word){

        //get the character arrays of the words
        char []contentArray = content.toCharArray();
        char []wordArray = word.toCharArray();

        //sort the arrays for easy comparision
        Arrays.sort(contentArray);
        Arrays.sort(wordArray);

        //determine if it matches
        if (Arrays.equals(wordArray, contentArray)) {
            return true;
        }
        else{
            return false;
        }
    }

    //helper method that accepts GameWord object as argument for the anagram method
    public boolean anagram(GameWord word){
        return anagram(word.content);
    }

    //helper method that calls the permutation method with correct arguments
    public ArrayList<String> permutations(){
        ArrayList<String> wordArray = new ArrayList<String>();
        char[] chars = content.toCharArray();
        Arrays.sort(chars);
        return permutations("", new String(chars),  wordArray);
    }

    //method that returns an array of permutations of the word
    private ArrayList<String> permutations(String fix,  String subString,  ArrayList<String> array){

        //if all the letters are fixed, the word has been permuted
        if (subString.length() ==0){
            array.add(fix);
        }
        else{
            //fix each letter in the string and call itself recursively to continue the process until each letter is fixed
            for (int i = 0; i < subString.length(); i++){
                //ignore if the fixed letter is the same as previous (i.e. we have already fixed it previously)
                if (i > 0 && subString.charAt(i) == subString.charAt(i - 1)) {
                    continue;
                }
                permutations(fix + subString.charAt(i), subString.substring(0, i)+subString.substring(i+1, subString.length()), array);
            }
        }
        return array;
    }

    // returns the GameWord object as a string
    @Override
    public String toString(){
        return content;
    }

}
