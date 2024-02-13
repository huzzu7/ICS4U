import java.awt.*;
import java.util.*;


public class ArrayEx3 {
    public static void main(String[] args) {

    Random random = new Random();
    Point trees[] = new Point[10];
    trees[0] = new Point (random.nextInt(30), random.nextInt(30));
    int counter = 1;

    while (counter < 10){
        Point pt = new Point (random.nextInt(30), random.nextInt(30));
        boolean valid = true; 
        for (Point location : trees) {
            if (location != null && pt.distance(location) < 3) {
                valid = false; 
                break;
            }
        }
        if (valid) {
            trees[counter] = pt;
            counter++;
        }
    }
    System.out.println(Arrays.toString(trees));

    for (Point tree : trees){
        System.out.printf("(%d,%d),",(int)tree.getX(),(int)tree.getY());
    }
    }
    
}
