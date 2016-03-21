package measurement;

import exceptions.InvalidComparisonException;
import exceptions.InvalidUnitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MeasurementTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void one_feet_should_be_equalsTo_twelve_inches() throws  InvalidComparisonException {
        Measurement feet= new Measurement(UnitsOfLength.FEET,2);
        Measurement inch = new Measurement( UnitsOfLength.INCH,24.0);
        assertEquals(feet.compare(inch) ,true);
    }
    @Test
    public void one_inch_should_be_equalsTo_five_cm() throws InvalidComparisonException {
        Measurement inch= new Measurement( UnitsOfLength.INCH,2);
        Measurement centimeter = new Measurement(UnitsOfLength.CM,5);
        assertEquals( true,inch.compare(centimeter));
    }
    @Test
    public void five_cm_should_be_equalsTo_fifty_mm() throws InvalidComparisonException {
        Measurement centimeter = new Measurement(UnitsOfLength.CM,5);
        Measurement milimeter = new Measurement(UnitsOfLength.MM,50);
        assertEquals( true,centimeter.compare(milimeter));
    }

    @Test
    public void one_gallon_should_be_equalsTo_three_point_seven_eight_litres() throws Exception, InvalidComparisonException {
        Measurement gallon = new Measurement(UnitsOfVolume.GALLON,1);
        Measurement litre = new Measurement(UnitsOfVolume.LITRE,3.78);
        assertEquals(true ,gallon.compare(litre));

    }
    @Test
    public void two_inch_added_with_two_inches_gives_four_inches() throws Exception, InvalidUnitException {
        Measurement firstMeasurementInInch= new Measurement( UnitsOfLength.INCH,2);
        Measurement secondMeasurementInInch = new Measurement( UnitsOfLength.INCH,2);
        Measurement expected = new Measurement(UnitsOfLength.INCH,4);
        assertEquals(expected ,firstMeasurementInInch.add(secondMeasurementInInch));
    }
//
    @Test
    public void two_inch_added_with_two_and_half_cm_gives_three_inches() throws Exception, InvalidUnitException {
        Measurement twoInch= new Measurement(UnitsOfLength.INCH,2);
        Measurement twoAndHalfCemtimeter = new Measurement(UnitsOfLength.CM,2.5);
        Measurement expected = new Measurement(UnitsOfLength.INCH,3);
        assertEquals(expected ,twoInch.add(twoAndHalfCemtimeter));
    }

    @Test
    public void should_throw_exception_for_unequal_units_comparison() throws Exception, InvalidComparisonException {
        thrown.expect(InvalidComparisonException.class);
        thrown.expectMessage("Can't compare volume with measurement");
        Measurement inch = new Measurement(UnitsOfLength.INCH,1);
        Measurement gallon = new Measurement(UnitsOfVolume.GALLON,1 );
        inch.compare(gallon);
    }

    @Test
    public void one_gallon_added_with_one_litre_should_be_equal_to_four_point_seven_eight() throws Exception, InvalidUnitException {
        Measurement gallon= new Measurement(UnitsOfVolume.GALLON,1);
        Measurement litre = new Measurement(UnitsOfVolume.LITRE,1);
        Measurement expected = new Measurement(UnitsOfVolume.LITRE,4.78);
        assertEquals(expected ,gallon.add(litre));
    }

    @Test
    public void should_throw_exception_for_unequal_unit_addition() throws Exception, InvalidUnitException {
        thrown.expect(InvalidUnitException.class);
        thrown.expectMessage("scale should be in same type of measurements");

        Measurement inch = new Measurement(UnitsOfLength.INCH,1);
        Measurement gallon = new Measurement(UnitsOfVolume.GALLON,1);
        inch.add(gallon);
    }

}