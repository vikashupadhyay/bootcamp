package closeShape;

import exceptions.InvalidScaleException;

//It is giving Area and Perimeter Of rectangle.
public class Rectangle {
    private final double height;
    private final double width;

    protected Rectangle(double height, double width) {

        this.height = height;
        this.width = width;
    }

    public static Rectangle create(double height, double width) throws InvalidScaleException {
        if (height<=0)
            throw new InvalidScaleException("Rectangle should have positive height but found:",height);
        if(width<=0)
            throw new InvalidScaleException("Rectangle should have positive width but found:",width);
        return new Rectangle(height, width);
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePrimeter() {
        return 2 * (width + height);
    }
}
