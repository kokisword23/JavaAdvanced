package app;

public class Repair {
    private String name;
    private int hoursWorked;

    public Repair(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",this.getName(), this.hoursWorked).trim();
    }
}
