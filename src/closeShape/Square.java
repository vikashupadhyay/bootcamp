package closeShape;
// it is creating a square using Rectangle and calculating area and perimeter.
import exceptions.InvalidScaleException;

public class Square extends Rectangle {
    private Square(double edge) {
        super(edge,edge);
    }

    public static Square create(double edge) throws InvalidScaleException {
        if(edge<=0)
            throw new InvalidScaleException("square should have positive edge but found:",edge);
        return new Square(edge);
    }
}

