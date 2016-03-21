package length;

public enum UnitsOfLength {
    FEET(30),   //  Base unit is Meter...
    INCH(2.5),
    CM(1),
    MM(0.1);

    private double value;

     UnitsOfLength(double value) {
        this.value = value;
    }
    public double value(){
        return value;
    }
}
