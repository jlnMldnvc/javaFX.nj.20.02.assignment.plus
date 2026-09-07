package my.models;

public enum Bandwidth {
    GB1("1"),
    GB5("5"),
    GB10("10"),
    GB100("100"),
    FLAT("Flat");

    private final String label;

    Bandwidth(String label) {
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