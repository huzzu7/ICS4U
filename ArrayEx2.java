import java.util.*;

public class ArrayEx2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String words[] = line.split(" ");

        String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0 ; i < words.length; i++){
            for (int j = 0; j < days.length; j++){
                if (words[i].contains(days[j])){
                    words[i] = words[i].replace(days[j], days[(j+6)%7]);
                }
            }
        }

        String str = String.join(" ", words);
        System.out.println(str);
        scanner.close();
 
    }
    
}
