public class MyRobot {
   private double  x, y, heading;

   public MyRobot(){
    x = 0;
    y = 0;
    heading = 0;
   }

   public MyRobot(double startX, double startY, double startTheta){
    x = startX;
    y = startY;
    heading = startTheta;
   }

   public void turn(double turnAngle){
    heading += turnAngle;
   }

   public void advance(double move){
    x += move*(Math.cos(Math.toRadians(heading)));
    y += move*(Math.sin(Math.toRadians(heading)));
   }

   @Override
   public String toString(){
    return String.format("x: %s y: %s heading %.2f", x, y, heading);  
   }
}
