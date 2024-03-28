import java.awt.geom.Line2D;
import java.util.*;

public class BasicAssign3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //collect input
        System.out.print("Enter a point (separated by space): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.println("Enter a line (separated by space): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // create Line2D object for the line
        Line2D line = new Line2D.Double(x1, y1, x2, y2);

        //check distance to line
        if (line.ptLineDist(x,y)==0){
            System.out.println("on line");
        }
        else{
            System.out.println("not on line"); 
        }
        scanner.close();
    }
}
