import closeShape.Rectangle;
import exceptions.InvalidScaleException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void retangleShouldHaveArea() throws InvalidScaleException {
        Rectangle rectangle = Rectangle.create(2, 3);
        Assert.assertEquals(rectangle.calculateArea(), 6, 0.5);

    }

    @Test
    public void retangleShouldThrowInvalidDimensionExceptionForNegativeHeight() throws InvalidScaleException {
        thrown.expect(InvalidScaleException.class);
        thrown.expectMessage("Rectangle should have positive height but found: -2.0");
        Rectangle.create(-2, 3);

    }

    @Test
    public void retangleShouldThrowInvalidDimensionExceptionForNegativeWidth() throws InvalidScaleException {
        thrown.expect(InvalidScaleException.class);
        thrown.expectMessage("Rectangle should have positive width but found: -3.0");
        Rectangle.create(2, -3);

    }

    @Test
    public void retangleShouldThrowInvalidDimensionExceptionForNegativeWidthAndHeight() throws InvalidScaleException {
        thrown.expect(InvalidScaleException.class);
        thrown.expectMessage("Rectangle should have positive height but found: -2.0");
        Rectangle.create(-2, -3);

    }

    @Test
    public void retangleShouldHavePerimeter() throws Exception, InvalidScaleException {
        Rectangle rectangle = Rectangle.create(2, 3);
        Assert.assertEquals(rectangle.calculatePrimeter(), 10, 0.5);

    }

}
