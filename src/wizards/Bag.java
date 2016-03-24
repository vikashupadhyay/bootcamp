package wizards;

import exceptions.IllegalBallInsertionException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Bag {
    private final int maxSize;
    private int totalBalls = 0;
    private final int MAX_GREEN_BALLS = 3;
    private ArrayList<Ball> balls;
    private LinkedHashMap<Color, Integer> colors = new LinkedHashMap<Color, Integer>();
    public Bag(int maxSize) {
        this.maxSize = maxSize;
        balls = new ArrayList<Ball>();
    }

    private int getLimitOf(Ball ball) {
        int limit = 0;
        if (ball.isSameColor(Color.RED)) {
            limit = (getCountOfBalls(Color.GREEN) * 2) - 1;
        }
        return limit;
    }

    private int getCountOfBalls(Color color){
        int count = 0;
        for (Ball ball : balls) {
            if(ball.isSameColor(color)){
                count++;
            }
        }
        return count;
    }

    public void putBall(Ball ball) throws IllegalBallInsertionException {
        if(totalBalls >= maxSize){
            throw new IllegalBallInsertionException();
        }
        add(ball);
    }

    private void add(Ball ball) {
        balls.add(ball);
        totalBalls++;
        int greenBalls = getBallsOf(Color.GREEN);
        colors.put(Color.GREEN,3);
        colors.put(Color.RED,getLimitOf(ball));
        double floor = Math.floor(balls.size() * 0.4);
        colors.put(Color.YELLOW,(int)floor);

    }

    public int getBallsOf(Color color) {
        return getCountOfBalls(color);
    }

    public String ShowSummary() {
        String summary = "Balls :" + balls.size() + "\n";
        int green = getCountOfBalls(Color.GREEN);
        int red = getCountOfBalls(Color.RED);
        int blue = getCountOfBalls(Color.BLUE);
        int yellow = getCountOfBalls(Color.YELLOW);

        return String.format("%sgreen: %d red: %d blue: %d yellow: %d", summary, green, red, blue, yellow);
    }
}
