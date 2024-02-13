import java.util.*;

public class StringEx3 {
    public static void main(String[] args) {
        //char []num = {'0','1','2','3','4','5','6','7','8','9'};

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String str_number = "";

        for (char ch: string.toCharArray()){
            if (Character.isDigit(ch)){
                str_number+=ch;
            }
        }
        
        // for (int n =0 ; n < string.length(); n++){
        //     for (int j = 0; j < 10; j++){
        //         if (string.charAt(n)==num[j]){
        //             str_number += num[j];
        //         }
        //     }
        // }

        int number = Integer.parseInt(str_number);
        System.out.println(number);
        scanner.close();

    }
}
