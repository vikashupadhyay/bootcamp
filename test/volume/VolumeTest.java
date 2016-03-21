package volume;
import exceptions.InvalidComparisonException;
import length.Length;
import length.UnitsOfLength;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;



public class VolumeTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void compare_gallon_with_litre() throws Exception, InvalidComparisonException {
        Volume volumeOne = new Volume(UnitsOfVolume.LITRE, 7.56);
        Volume volumeTwo = new Volume(UnitsOfVolume.GALLON, 2);
        Assert.assertTrue(volumeOne.compare(volumeTwo));

    }

    @Test
    public void compare_should_throw_exception_comparison_between_gallon_and_inch() throws Exception, InvalidComparisonException {
        Volume volume = new Volume(UnitsOfVolume.GALLON, 1);
        Length length = new Length(UnitsOfLength.INCH, 1);
        thrown.expect(InvalidComparisonException.class);
        thrown.expectMessage("Can't compare volume with length");
        volume.compare(length);

    }

    @Test
    public void add_should_return_sum_in_litre_of_one_value_in_gallon_and_other_in_litre() throws Exception {
        Volume volumeOne = new Volume(UnitsOfVolume.LITRE,2);
        Volume volumeTwo = new Volume(UnitsOfVolume.GALLON,1);
        Volume expected = new Volume(UnitsOfVolume.LITRE,5.78);
        assertEquals(volumeOne.add(volumeTwo),expected);
    }

    @Test
    public void add_should_return_sum_in_litre_when_both_units_in_gallon() throws Exception {
        Volume volumeOne = new Volume(UnitsOfVolume.GALLON,2);
        Volume volumeTwo = new Volume(UnitsOfVolume.GALLON,2);
        Volume expected = new Volume(UnitsOfVolume.LITRE,15.12);
        assertEquals(volumeOne.add(volumeTwo),expected);
    }
}