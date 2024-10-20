package exercise1;

import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Insurance[] insuranceArray = new Insurance[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the type of insurance (Health/Life):");
            String type = System.console().readLine();

            if (type.equalsIgnoreCase("Health")) {
                insuranceArray[i] = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                insuranceArray[i] = new Life(type);
            }

            insuranceArray[i].setInsuranceCost();
            System.out.println();
        }

        // Polymorphic screen manager
        System.out.println("Insurance Information:");
        for (Insurance insurance : insuranceArray) {
            insurance.displayInfo();
            System.out.println();
        }
        scanner.close();
    }
}
