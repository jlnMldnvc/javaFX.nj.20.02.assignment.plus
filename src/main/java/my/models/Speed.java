package my.models;

public enum Speed {
    S2(2),
    S5(5),
    S10(10),
    S20(20),
    S50(50),
    S100(100);

    private final int value;

    Speed(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}