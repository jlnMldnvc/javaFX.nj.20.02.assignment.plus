package my.models;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String label;

    Gender(String label) {
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