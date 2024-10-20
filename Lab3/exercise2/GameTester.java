package exercise2;

abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean fullTime) {
        this.name = name;
        this.isFullTime = fullTime;
    }



    abstract double salary();
}
