package length;

import exceptions.InvalidUnitException;

public class Length {
    private final UnitsOfLength unit;
    private final double value;

    public Length(UnitsOfLength unit, double value) {
        this.value = value;
        this.unit = unit;
    }


    public boolean compare(Length lengthTwo) {
        return ((value*unit.value())==lengthTwo.value*lengthTwo.unit.value());
    }

    public Length add(Object lengthTwo) throws InvalidUnitException {
        if(!(lengthTwo instanceof  Length)) throw new InvalidUnitException("scale should be in same type of measurements");
        Length otherLength = (Length) lengthTwo;
        double addedValueInCM = value*unit.value()+otherLength.value*otherLength.unit.value();
        return new Length(UnitsOfLength.INCH,addedValueInCM/UnitsOfLength.INCH.value());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 && unit == length.unit;

    }

}
