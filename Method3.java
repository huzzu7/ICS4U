import java.util.Arrays;

public class Method3 {
    
    public static void main(String[] args) {
        int [] numberArray = {1,2,3,4,5};
        int number = 6;
        arrayAdd(numberArray, number);
    }    

    public static int[] arrayAdd(int[] array, int num){
        int[] newArray = new int[array.length+1];

        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = num;
        System.out.println(Arrays.toString(newArray));

        return newArray;
    }
}
