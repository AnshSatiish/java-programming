package exercise3;

public class Driver {
    public static void main(String[] args) {
        int multiplication1 = OverloadedMethods.multiply(2,5);
        int multiplication2 = OverloadedMethods.multiply(2,5,6);
        double multiplication3 = OverloadedMethods.multiply(4.9,6.5);


        System.out.println("Answer:" + multiplication1);
        System.out.println("Answer:" + multiplication2);
        System.out.println("Answer:" + multiplication3);
    }
}
