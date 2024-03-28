public class Recursion {
 // Recursion: a method that calls itself
 // 1. Base Case : a situation where the fn doesnt call itself
 // 2. Recursive Case: calls itself in a way that approaches the base case

    public static void main(String[] args) {
        bits(4);
    }

    static int fibonacci (int n){
        if (n<3){
            return 1;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    static int factorial(int n){
        if (n==1){
            return 1; // Base Case
        }
        else{
            return n * factorial(n-1); //Recursive case
        }
    }

    static void bits(int n){
        bits(n, "");
    }

    static void bits(int n, String ans ){
        if (n==0){
            System.out.println(ans);
        }
        else{
            bits(n-1, ans + "0");
            bits(n-1, ans + "1");
        }
    }
    
    static void stack (int n){
        System.out.println("IN: " + n);
        if (n>0){
            stack(n-1);
        }
        System.out.println("OUT: " + n);
    }
}