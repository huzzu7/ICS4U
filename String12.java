import java.awt.*;

public class String12{
    public static void main (String[] args){
        Point p1 = new Point(5,10);
        Point p2 = new Point(5,10);
        Point p3 = p1;
        System.out.println(p1 == p2); // returns false -> compares memory address -> 2 diff objects
        System.out.println(p1.equals(p2)); // returns true -> compares the actual object
        System.out.println(p1 == p3); //returns true -> same memory address

        p3.translate(100,200); // will translate both p1 and p3 since they point to same object
        System.out.println(p3 + " " + p1); 

        Point p4 = new Point(p2); //new object with the same value of p2 but in a different address
        
        p4.translate(100,2); // only translates p4 and not p2

        System.out.println(p4 + " " + p2);

        
    }
}