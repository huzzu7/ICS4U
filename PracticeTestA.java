import java.util.*;
public class PracticeTestA{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //triangles(scanner);
        //yodaRAHHH(scanner);
        String word = "hjeje";
        System.out.println(word.charAt(0));
    }

    public static void yodaRAHHH(Scanner scanner){
        String string = scanner.nextLine();
        String [] words = string.split(" ");

        int offset = words.length % 2==0 ? 0 : 1;
        for (int i = words.length/2+offset; i < words.length; i++){
            String punctuation = i == words.length-1 ? ", " : " ";
            if (i ==  words.length/2+offset){
                char[] first_word = words[words.length/2+offset].toCharArray();
                first_word[0] = Character.toUpperCase(first_word[0]);              
                for (char character : first_word){
                    System.out.print(character);
                }
                System.out.print(punctuation);
            }
            else{
            System.out.print(words[i]+punctuation);}
        }
        for (int i = 0; i < words.length/2+offset; i++){
            System.out.print(words[i]+" ");
        }    
    }

    public static void triangles(Scanner scanner){
        System.out.println("How many triangles?");
        int num_triangles = scanner.nextInt();

        Random random = new Random();
        
        
        for (int i = num_triangles; i > 0; i--){
            while (true){
                int x = random.nextInt(50)+1;
                int y = random.nextInt(50)+1;
                double hyp = Math.pow(Math.pow(x,2) + Math.pow(y,2), 0.5);
                double decimal = hyp - (int) hyp;

                if (decimal==0 && hyp <= 50){
                    System.out.println(x+" "+y+" "+(int)hyp);
                    break;
                }
            }    
        }
    }
}