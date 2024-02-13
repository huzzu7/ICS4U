import java.util.*;

public class BasicEx5 {

    public static void main(String[] args) {
        
    
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    
    double product = 1;
    for (int i = num; i > 0; i--){
        product = product*i;
    }

    System.out.println(product);
    scanner.close();

}
}