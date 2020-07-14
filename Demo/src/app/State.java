package app;

public enum State {
    INPROGRESS("inProgress"), FINISHED("Finished");

    private String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
