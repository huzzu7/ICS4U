import java.util.*;

public class BasicAssign1 {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string += string.charAt(0); 

        System.out.println(string);
        for (int i = 1; i < string.length()-1; i++) {
            //System.out.println(string.charAt(string.length()-i)+""+string.charAt(i));
            System.out.print(string.charAt(string.length()-i-1));
            for (int j = 1; j < string.length()-1; j++) {
                 System.out.print(" ");
            }
            System.out.print(string.charAt(i)+"\n");
        }
        for (int k = string.length()-1; k >= 0; k--) {
            System.out.print(string.charAt(k));
        }
        
        scanner.close();
    }
}
