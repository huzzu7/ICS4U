import java.util.*;

public class BasicEx3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(findFactors(num));
        scanner.close();

    }

    public static ArrayList<Integer> findFactors(int number){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        //for a list of pair of factors of a number, you start repeating factors after reaching the sqrt of the number
        for (int i = 1; i<=Math.sqrt(number); i++){
            if (number%i == 0){
                if (number/i == i){
                    factors.add(i);
                }
                else{
                    factors.add(i);
                    factors.add(number/i);
                }
            }
        }
        return factors;
    }
}
