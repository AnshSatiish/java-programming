package exercise2;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of game tester (F or P): ");
        String testerType = scanner.nextLine();

        System.out.print("Enter the name of the game tester: ");
        String name = scanner.nextLine();

        GameTester gameTester = null;

        if (testerType.equals("F")) {
            gameTester = new FullTimeGameTester(name);
        } else if (testerType.equals("P")) {
            System.out.print("Enter the number of hours worked: ");
            int hoursWorked = scanner.nextInt();

            gameTester = new PartTimeGameTester(name, hoursWorked);
        } else {
            System.out.println("Invalid game tester type.");
            scanner.close();
            return;
        }
        System.out.println("Game Tester: " + gameTester.name);
        System.out.println("Salary: $" + gameTester.salary());

        scanner.close();
    }
}
