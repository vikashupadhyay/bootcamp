package measurement;

public enum UnitsOfVolume implements Unit{
    LITRE(1.0),
    GALLON(3.78);

    private double conversionFactorForLitre;

    UnitsOfVolume(double conversionFactorForLitre) {
        this.conversionFactorForLitre = conversionFactorForLitre;
    }

    public double getConversionFactorForInch() {
        return this.conversionFactorForLitre;
    }

    @Override
    public Unit standardUnit() {
        return UnitsOfVolume.LITRE;
    }
}
