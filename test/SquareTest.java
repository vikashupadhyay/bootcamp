import closeShape.Rectangle;
import closeShape.Square;
import exceptions.InvalidScaleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void squareCanNotBeOfNegativeEdge() throws Exception, InvalidScaleException {
        thrown.expectMessage("square should have positive edge but found: -5.0");
        Square.create(-5);

    }
    @Test
    public void squareCanNotBeOfZeroEdge() throws Exception, InvalidScaleException {
        thrown.expectMessage("square should have positive edge but found: 0.0");
        Square.create(0);

    }

    @Test
    public void testForCalculateAreaOfSquare() throws Exception, InvalidScaleException {
        Square square = Square.create(5);
        assertEquals(square.calculateArea(),25.0,0.5);


    }
    @Test
    public void testForCalculatePerimeterOfSquare() throws Exception, InvalidScaleException {
        Square square = Square.create(5);
        assertEquals(square.calculatePrimeter(),20.0,0.5);

    }
    @Test
    public void testSquareCanBeARectangle() throws Exception, InvalidScaleException {
        Rectangle square = Square.create(5);
        assertEquals(square.calculatePrimeter(),20.0,0.5);

    }
}
