import java.util.*;

public class ArrayEx1 {
    public static void main(String[] args) {
        
    
        Scanner scanner = new Scanner(System.in);
        int []marks = new int[8]; 
        int sum = 0;
        for (int i = 0; i < 8; i++){
            System.out.print("Enter mark: ");
            marks[i] = scanner.nextInt();
            sum+=marks[i];
        }

        int avg = sum/8;
        Arrays.sort(marks);
        System.out.println(Arrays.toString(marks));
        
        for(int mark: marks){
            int difference = Math.abs(mark-avg);
            String desc = mark > avg ? "above" : "below";
            System.out.printf("mark %d is %d %s average\n", mark, difference, desc);
        }
        
        scanner.close();



        
}
}
