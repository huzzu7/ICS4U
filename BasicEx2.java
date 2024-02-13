import java.util.*;

public class BasicEx2 {
    public static void main(String[] args) {

        //Construct Scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize sum;
        double sum = 0;

        //Prompt for input and store input
        System.out.println("Enter number of terms and base ");
        int num = scanner.nextInt();
        double base = scanner.nextDouble();


        //Calculate sum
        for (int i = 0; i < num; i++){
            sum += Math.pow(base,i);
        }

        //Print Sum
        System.out.printf("Sum of series: %.2f" , sum);

        //Close Scanner
        scanner.close();

    }
}
