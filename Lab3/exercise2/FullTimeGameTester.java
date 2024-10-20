package exercise2;

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name, true);  // Full-time is always true
    }

    @Override
    public double salary() {
        return 3000;  // Base salary for full-time testers
    }
}
