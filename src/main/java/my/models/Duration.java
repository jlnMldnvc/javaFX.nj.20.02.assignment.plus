package my.models;

public enum Duration {
    ONE_YEAR("1 year"),
    TWO_YEARS("2 years");

    private final String label;

    Duration(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}