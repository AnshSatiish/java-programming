package exercise2;

public class PartTimeGameTester extends GameTester {
    private int hoursWorked;
    private final double hourlyRate = 20.0;  // Part-time hourly rate

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);  // Part-time is always false
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double salary() {
        return hoursWorked * hourlyRate;
    }
}
