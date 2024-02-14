import java.util.*;

public class BasicAssign1 {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");

        String string = scanner.nextLine();

        //add the first letter to the end
        string += string.charAt(0);
        System.out.println(string);

        //print the middle letters with appropriate spacing and sequence
        for (int i = 1; i < string.length()-1; i++) {
            System.out.print(string.charAt(string.length()-i-1));
            for (int j = 1; j < string.length()-1; j++) {
                 System.out.print(" ");
            }
            System.out.print(string.charAt(i)+"\n");
        }

        //print the mirrored string
        for (int k = string.length()-1; k >= 0; k--) {
            System.out.print(string.charAt(k));
        }
        
        scanner.close();
    }
}
