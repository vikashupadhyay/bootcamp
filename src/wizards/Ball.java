package wizards;

public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        return color == ball.color;

    }

    public boolean isSameColor(Color other){
        return color.equals(other);
    }
}
