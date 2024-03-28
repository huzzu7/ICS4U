import java.util.*;

public class StringEx1 {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String []array = string.split(" ");

        for (String n : array){
            if (n.length() != 4){
                System.out.print(n + " ");
            }
        }
        scanner.close();
        //System.out.println(Arrays.toString(array));
    }
}
