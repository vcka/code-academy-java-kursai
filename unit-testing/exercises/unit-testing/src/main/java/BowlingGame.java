
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private int currentFrame;
    private int score;
    private List<Frame> frameScores;

    private BowlingGame() {
        currentFrame = 1;
        score = 0;
        frameScores = new ArrayList<>();

    }

    public static BowlingGame startGame() {
        return new BowlingGame();
    }

    public void throwBall(int score) {

    }

    public int curreentScore() {
        return 0;
    }

    public int currentFrame() {
        return 0;
    }

    public void printResults() {

    }


    private static class Frame {

    }

}
