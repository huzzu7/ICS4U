import java.util.*;

public class BasicAssign4 {
    public static void main(String[] args) {
        int sampleSizeTotal = 0;

        for (int i = 0; i < 10000; i++){
            sampleSizeTotal += samplesize();
        }

        System.out.printf("%.2f",(float)sampleSizeTotal/10000);
    }

    public static int samplesize(){
        boolean []birthdays = new boolean[365];
        Random random = new Random();
        int counter = 0;
        
        while(true){
            int date = random.nextInt(365);
            counter++;
            if (birthdays[date]){
                return counter;
            }
            else{
                birthdays[date] = true;
            }
        }
    }
    
}
