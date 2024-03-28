import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        boolean isValid = true;
        
        String[] parse = line.split(" ");
        int product = 1;

        //test if number or uppercase
        for (char letter : parse[0].toCharArray()){
            if(((int)letter<48 || (int)letter > 57) && ((int)letter<65 || (int)letter > 90)){
                isValid = false;
            }
        }
        parse[0] = parse[0].replaceAll("\\D", "");
        
        //test if length of digit string is == 6
        if (parse[0].length()!=6){
            isValid = false;
        }
        
        for(int i = 0; i <5; i+=2){
            int num = Integer.parseInt(parse[0].charAt(i)+""+parse[0].charAt(i+1));
            product*=num;
        }

        //test if product is incorrect
        if (product!=Integer.parseInt(parse[1])){
            isValid = false;
        }
        
        
        System.out.println(isValid);
          

    }
}

