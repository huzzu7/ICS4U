import java.util.*;

public class Method2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String string = scanner.nextLine();
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        repeat(string, number);

    }

    public static void repeat (String text, int loop){
        for (int i = 0; i < loop; i++){
            System.out.println(text);
        }
    }
}
