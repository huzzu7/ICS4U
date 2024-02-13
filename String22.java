import java.util.*;

public class String22 {
    public static void main(String[] args) {
        String st1 = "sun"; 
        String st2 = "sun"; //The compiler will take all occurences of the same string
                            // and point to same object
        System.out.println(st1 == st2);


        String st3 = "sun";
        String st4 = "sunny";

        st3 +="ny";
        System.out.println(st4==st3); // will return false bc it point st3 and s24 at diff addresses bc theyre diff
                                     // when you change st3, it destroys the object and empties the memory, creates a new object
                                     // at a new memory address (not @ st4)


        char ch = 'a'; //holds ASCII value
        System.out.println((char)(ch+1)); //cast it as char to print b, else it will print ascii value of 98
        System.out.println(ch==97);

        for(int i=0; i<st4.length();i++){
            if(st4.charAt(i) != 'u'){
                System.out.println(st4.charAt(i)+" ");
            }
        }

        int []nums = {45,67,4};
        for (int n : nums){
            System.out.println(n);
        }
        for (int n : new int[]{2,5,67}){
            System.out.println(n);
        }

        for (int i = 0; i<nums.length; i++){
            nums[i] +=10;
        }

        System.out.println(nums);
        System.out.println(Arrays.toString(nums)); //nums is the address so how can u convert the address to a string?
                                                // does the method take care of that


        for (char c: st1.toCharArray()){
            System.out.println(c);
        }

        String line = "This is only a test";
        System.out.println(line.indexOf(' '));
        System.out.println(line.indexOf("is"));
        System.out.println(line.contains("is"));

        System.out.println(line.replace("is", "**"));
        System.out.println(line.replaceAll("[aeiou]", "**"));

        String []words = line.split(" ");
        System.out.println(Arrays.toString(words));

        //Substring
        String front = line.substring(0,8);
        String back = line.substring(8);
        System.out.println(front+"--"+back);

        

        //learn regular Expression 
    }
}
