import java.util.*;

public class StringEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        int half = string.length() /2;

        for (int n = 0; n < half; n++){
            System.out.print("" + string.charAt(n)+ string.charAt(n + half));
        }

        if (string.length() % 2 == 1){
            System.out.print(string.charAt(string.length()-1));
        }
        scanner.close();

    }
}
