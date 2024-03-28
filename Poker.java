import java.util.*;

public class Poker{

    public static void main(String[] args) {
		Deck deck = new Deck();
		for(int i=1; i<=10; i++){					
			ArrayList<Card>player = deck.deal(3);
			ArrayList<Card>computer = deck.deal(3);
			
			System.out.println("\nGame "+i+":");
			System.out.println("------------");
			System.out.println("Player has: " + player);
			showHand(player);
			System.out.println("Computer has: " + computer);
			showHand(computer);
			
			if(evaluateHand(computer) > evaluateHand(player)){
				System.out.println("Computer Wins!");
			}
			else if(evaluateHand(player) > evaluateHand(computer)){
				System.out.println("Player Wins!");
			}
			else{
				System.out.println("Its a tie.");
			}
		}
		
    }

	public static boolean threeKind(ArrayList<Card>hand){
		return hand.get(0).getVal() == hand.get(1).getVal()  && hand.get(1).getVal() == hand.get(2).getVal();	
	}

    public static boolean flush(ArrayList<Card>hand){
        return hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() ==  hand.get(2).getSuit();	
    }

    public static boolean straight(ArrayList<Card>hand){
        int[] values = {hand.get(0).getVal(), hand.get(1).getVal(), hand.get(2).getVal()};
        
        Arrays.sort(values);

        return values[0]+1 == values[1] && values[1]+1 == values[2];
        
    }

    public static boolean straightFlush (ArrayList<Card>hand){
        return flush(hand) && straight(hand);
    }

    public static boolean pair (ArrayList<Card>hand){
        int[] values = {hand.get(0).getVal(), hand.get(1).getVal(), hand.get(2).getVal()};
        Arrays.sort(values);

        return values[0]==values[1] || values[1]==values[2];
    }


	public static void showHand(ArrayList<Card>hand){
		String []hands={"High Card","Pair","Flush","Straight","Three of a kind","Straight Flush"};
		System.out.println(hands[evaluateHand(hand)]);
	}


	public static int evaluateHand(ArrayList<Card>hand){
		if (straightFlush(hand)){
			return 5;
		}
		else if (threeKind(hand)){
			return 4;
		}
		else if (straight(hand)){
			return 3;
		}
		else if (flush(hand)){
			return 2;
		}
		else if (pair(hand)){
			return 1;
		}
		else{
			return 0;
		}		
	}
}

class Deck{
	private ArrayList<Card>cards;
	
	public Deck(){
		init();
	}

	public void init(){
		cards = new ArrayList<Card>();
		for(int i = 0; i<52; i++){
			cards.add(new Card(i));
		}
		Collections.shuffle(cards);	
	}

	public ArrayList<Card>deal(int n){
		if(n>cards.size()){
			init();
		}
		ArrayList<Card>ans = new ArrayList<Card>(cards.subList(0,n));
		cards.removeAll(ans);
		return ans;
	}
}

class Card{
	private int val, suit;
	
	public Card(int n){
		val = n%13+1;
		suit = n/13;
	}
	
	public int getVal(){
		return val;
	}
	public int getSuit(){
		return suit;
	}

	@Override
	public String toString(){
		String valueString = "";
		String suitString = "";
		if (val == 1){
			valueString = "Ace";
		}
		else if (val > 1 && val < 11){
			valueString = val+"";
		}
		else if (val == 11){
			valueString = "Jack";
		}
		else if (val == 12){
			valueString = "Queen";
		}
		else if (val == 13){
			valueString = "King";
		}
		else{
			valueString = "";
		}

		if (suit == 0){
			suitString = "Clubs";
		}
		else if (suit == 1){
			suitString = "Diamonds";
		}
		else if (suit == 2){
			suitString = "Hearts";
		}
		else if (suit == 3){
			suitString = "Spades";
		}
		else{
			suitString = "";
		}

		String finalString = valueString + " of " + suitString;
		return finalString;
	}
	
}

