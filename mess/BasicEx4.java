public class BasicEx4 {
    public static void main(String[] args) {
        double investment = 5000;
        double interest = 0.12;

        for (int i = 0; i < 10; i++){
            investment+= interest*investment;
            interest-=0.01;
        }
        System.out.printf("$%.2f",investment);
    }
}
