package exercise3;

public class OverloadedMethods {
    public static int multiply (int a, int b) {
        return a * b;
    }

    public static int multiply (int a, int b, int c) {
        return a * b * c;
    }

    public static double multiply (double a, double b) {
        return a * b;
    }
}
