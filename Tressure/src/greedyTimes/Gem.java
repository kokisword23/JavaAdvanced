package greedyTimes;

public class Gem  extends BaseEntity{
    private String name;

    public Gem(String name, long value) {
        super(value);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
