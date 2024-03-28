import java.util.*;

public class BasicAssign4 {
    public static void main(String[] args) {
        //initialize sample size
        int sampleSizeTotal = 0;
        
        //run the simulation 10000 times
        for (int i = 0; i < 10000; i++){
            sampleSizeTotal += samplesize();
        }

        //print the average of the 10000 simulations
        System.out.printf("%.2f\n",(float)sampleSizeTotal/10000);
        

    }

    //method that runs the experiment to determine the sample size of minimum one shared birthday
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
