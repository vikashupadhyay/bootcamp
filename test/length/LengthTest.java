package length;

import exceptions.InvalidUnitException;
import volume.UnitsOfVolume;
import volume.Volume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LengthTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void length_compares_two_different_length_which_are_in_different_unit_feet_and_inch() throws Exception {
        Length lengthOne = new Length(UnitsOfLength.FEET, 1);
        Length lengthTwo = new Length(UnitsOfLength.INCH, 12);
        assertTrue(lengthOne.compare(lengthTwo));
    }

    @Test
    public void length_compares_two_different_length_which_are_in_different_unit_inch_centimeter() throws Exception {
        Length lengthOne = new Length(UnitsOfLength.INCH, 2);
        Length lengthTwo = new Length(UnitsOfLength.CM, 5);
        assertTrue(lengthOne.compare(lengthTwo));
    }

    @Test
    public void length_compares_two_different_length_which_are_in_different_unit_centimeter_and_mm() throws Exception {
        Length lengthOne = new Length(UnitsOfLength.CM, 15);
        Length lengthTwo = new Length(UnitsOfLength.MM, 150);
        assertTrue(lengthOne.compare(lengthTwo));
    }

    @Test
    public void add_should_return_sum_of_two_values_in_inch() throws Exception, InvalidUnitException {
        Length lengthOne = new Length(UnitsOfLength.INCH, 2);
        Length lengthTwo = new Length(UnitsOfLength.INCH, 2);
        Length expected = new Length(UnitsOfLength.INCH, 4);
        assertEquals(lengthOne.add(lengthTwo), expected);
    }

    @Test
    public void add_should_return_sum_in_inch_of_two_values_which_are_in_different_units() throws Exception, InvalidUnitException {
        Length lengthOne = new Length(UnitsOfLength.INCH, 2);
        Length lengthTwo = new Length(UnitsOfLength.CM, 2.5);
        Length expected = new Length(UnitsOfLength.INCH, 3);
        assertEquals(lengthOne.add(lengthTwo), expected);

    }

    @Test
    public void add_should_return_sum_in_inch_of_one_value_in_inch_and_other_in_mm() throws Exception, InvalidUnitException {
        Length lengthOne = new Length(UnitsOfLength.INCH, 2);
        Length lengthTwo = new Length(UnitsOfLength.MM, 25);
        Length expected = new Length(UnitsOfLength.INCH, 3);
        assertEquals(lengthOne.add(lengthTwo), expected);

    }

    @Test
    public void add_should_throw_exception_add_inch_and_liter() throws Exception, InvalidUnitException {
        Length lengthOne = new Length(UnitsOfLength.INCH, 1);
        Volume volume = new Volume(UnitsOfVolume.LITRE, 1);
        thrown.expect(InvalidUnitException.class);
        thrown.expectMessage("scale should be in same type of measurements");
        lengthOne.add(volume);

    }

}