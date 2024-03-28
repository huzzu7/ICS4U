import java.util.*;

public class BasicEx1{
    public static void main (String[] args){

    Scanner scanner = new Scanner(System.in);

    int num;
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;
    int size= 0;
    int sum = 0;

   while (true){
    num = scanner.nextInt();

    if(num==0){
        break;
    }
    size++;
    sum += num;
    largest = num > largest ? num : largest;
    smallest = num < smallest ? num : smallest;
    }

   System.out.println("Size: "+ size);   
   System.out.println("Sum: "+ sum);
   System.out.println("Largest: " + largest);
   System.out.println("Smallest: " + smallest);
   System.out.printf("Average: %.2f", (float)sum/(float)size);
   
   scanner.close();

}
}
