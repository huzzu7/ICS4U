// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Arrays;

class Elevator {
   private int max;
   private int floor;
   private int dir;
   private int[] calls;
   public static final int STOP = 0;
   public static final int UP = 1;
   public static final int DOWN = -1;

   public Elevator(int mx) {
      this.max = mx;
      this.floor = 0;
      this.dir = 0;
      this.calls = new int[mx + 1];
   }

   public int getFloor() {
      return this.floor;
   }

   public void request(int fl) {
      int var10002 = this.calls[fl]++;
   }

   public boolean upCall() {
      for(int f = this.floor + 1; f <= this.max; ++f) {
         if (this.calls[f] > 0) {
            return true;
         }
      }

      return false;
   }

   public boolean downCall() {
      for(int f = this.floor - 1; f >= 0; --f) {
         if (this.calls[f] > 0) {
            return true;
         }
      }

      return false;
   }

   public void pickDir() {
      if (!this.upCall() && this.downCall()) {
         this.dir = -1;
      } else if (this.upCall() && !this.downCall()) {
         this.dir = 1;
      }

      if (!this.upCall() && !this.downCall()) {
         this.dir = 0;
      }

   }

   public void move() {
      if (this.calls[this.floor] > 0) {
         this.calls[this.floor] = 0;
      } else {
         this.floor += this.dir;
      }

      this.pickDir();
   }

   public void display() {
      System.out.println(Arrays.toString(this.calls));
      System.out.printf(" %" + (1 + this.floor * 3) + "s\n", "E");
   }
}
