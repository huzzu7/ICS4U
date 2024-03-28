import java.util.Scanner;

public class PracticeTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println(interest());

    }

    public static void  dating(Scanner scanner){
        String []names = new String[5];
        for (int i = 0; i<5; i++){
            System.out.println("Enter a name: ");
            names[i] = scanner.nextLine();
        }

        for (int i = 0; i<5; i++){
            for(int j=0; j<5; j++){
                String name1 = names[i];
                String name2 = names[j];


                if (i != j){
                    int score = name1.charAt(0) == name2.charAt(0) ? 4: 0;
                    for(char c1:name1.toCharArray()){
						for(char c2:name2.toCharArray()){
							if(c1==c2){
								score++;
							}
						}
                    System.out.printf("%-20s %3d\n", name1+", "+name2, score);
                }
            }

            
            }
        }
    }
    public static double interest(){
        double bal = 0, dep = 2000;

        for (int i= 0; i<20; i++){
            bal+=dep;
            bal*=1.08;
            dep *=1.05;
        }
        return bal;
     
    }
}
