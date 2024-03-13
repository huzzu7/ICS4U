import java.util.Random;

public class Method5 {
    
    public static void main(String[] args) {
        Random random = new Random();
        String[] words = {"what"};
        for (int i = 0; i < 10; i++){
            System.out.printf("%s %03d\n",licensePlate(words,random),licenseNum(random));
        }
    }

    public static String licensePlate(String[] array, Random random){
        
        String license = "";
        for(int i =0; i<4; i++){
            license += (char) (random.nextInt(25)+65);
        }
        for (String word: array){
            if(word.equals(license)){
                return licensePlate(array, random);
            }
        }
        return license;
    }

    public static int licenseNum(Random random) {
        return random.nextInt(1000);
    }

}
