public class Methods {
    public static void main(String[] args) {
        String name = "Me";
        doctorfy(name);
        System.out.println(name);
    }

    static void doctorfy(String name){
        name = "Dr. " + name;
    }
}
