package measurement;

public enum UnitsOfLength implements Unit {
    FEET(30),
    INCH(2.5),
    CM(1),
    MM(0.1);

    private  double conversionFactorForInch;

    UnitsOfLength(double conversionFactorForInch) {
        this.conversionFactorForInch = conversionFactorForInch;
    }

    public double getConversionFactorForInch() {
        return conversionFactorForInch;
    }

    @Override
    public Unit standardUnit() {
        return UnitsOfLength.CM;
    }

}
