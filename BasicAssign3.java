import java.awt.geom.Line2D;
import java.util.*;

public class BasicAssign3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter point");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.println("enter line");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Create Line2D object for the line
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        if (line.ptLineDist(x,y)==0){
            System.out.println("on line");
        }
        else{
            System.out.println("not on line"); 
        }
    
    }
}
