package greedyTimes;

public abstract class BaseEntity {
    private long value;

    protected BaseEntity(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
