// import java.util.*;
// public class Scrabble {

//     public static void main(String[] args) {
//         GameWord gw = new GameWord("bab");
//         System.out.print(GameWord.permutations(gw.toString()));
//     }
// }
import java.util.*;
public class Scrabble{

	public static void main(String []args){
		GameWord gw = new GameWord("cat");
		System.out.println(gw.reverse());         // tac		
		GameWord gw2 = new GameWord("act");
		GameWord gw3 = new GameWord("quiz");

		System.out.println(gw.anagram("act"));    // true
		System.out.println(gw.anagram(gw2));      // true
		System.out.println(gw.anagram(gw3));      // false
		
		System.out.println(gw3.pointValue(0, 0, GameWord.RIGHT));      // 96
		
		ArrayList<String> words = gw.permutations();
		System.out.println(words); 				  // [cat, cta, act, atc, tca, tac] 
		
		System.out.println(gw); 				  // cat
		
	}

}