package measurement;

import exceptions.InvalidComparisonException;
import exceptions.InvalidUnitException;

public class Measurement {
    private  double value;
    private  Unit unit;

    public Measurement( Unit unit,double value) {
        this.value = value;
        this.unit = unit;
    }
    private double roundUpToTwoDecimalPlaces(double value) {
        return  (Math.round(value*100.0))/100.0;
    }
    private Measurement convertToStandard() {
        double value = roundUpToTwoDecimalPlaces(this.value  * unit.getConversionFactorForInch());
        Unit unit = this.unit.standardUnit();
        return new Measurement(unit,value);
    }
    private Measurement convert(Unit unit) {
        double newValue = roundUpToTwoDecimalPlaces(convertToStandard().value / unit.getConversionFactorForInch());
        return  new Measurement(unit,newValue);
    }
    public  Measurement add (Measurement measurement) throws InvalidUnitException {
        if(!isPerformable(measurement))
            throw new InvalidUnitException("scale should be in same type of measurements");
        double sum = roundUpToTwoDecimalPlaces(convertToStandard().value + measurement.convertToStandard().value);
        return new Measurement(unit.standardUnit(),sum);
    }
    public boolean compare ( Measurement measurement) throws InvalidComparisonException {
        if(!isPerformable(measurement))
            throw new InvalidComparisonException();
        return  equals(measurement);
    }
    private boolean isPerformable(Measurement measurement) {
        return  (measurement == null || unit.getClass() == measurement.unit.getClass());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;
        Measurement measurementForCompare = that.convert(unit);

        return Double.compare(value, measurementForCompare.value) == 0 && unit == measurementForCompare.unit;
    }
    @Override
    public String toString() {
        return String.format("%s %s" ,value,unit);
    }
}
