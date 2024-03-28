import java.util.Arrays;

public class Method4 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        fold(nums); 
    }

    public static int[] fold (int[] array){
        int[] newArray = new int[array.length/2];
        for (int i = 0; i < array.length/2; i++){
            newArray[i] = array[i] + array[i+array.length/2];
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}
