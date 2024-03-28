import java.util.*;

public class BasicAssign2 {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string += " ";
        String code = "";
        int prev_length = 0;
        for (int i = 0; i < string.length(); i++){
            if (i>0 && string.charAt(i)!=string.charAt(i-1)){
                //System.out.println(i-prev_length);
                code += (i-prev_length)+""+string.charAt(i-1);
                prev_length = i;
            }
        }
        System.out.println(code);
        scanner.close();
    }
}
