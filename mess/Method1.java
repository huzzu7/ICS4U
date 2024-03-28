public class Method1 {

    public static void main(String[] args) {

        int[] nums = {1,1,3,3,4,5,6, 8,};

        System.out.printf("%.2f\n",mean(nums));
        
    }

    public static double mean (int[] array){
        double sum = 0;
        
        for (int num: array){
            sum+= num;
        }

        return  sum/array.length;
    }
}