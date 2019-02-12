
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private int currentFrame;
    private int currentScore;
    private List<Frame> frameScores;

    private BowlingGame() {
        currentFrame = 0;
        currentScore = 0;
        frameScores = new ArrayList<>();
        frameScores.add(new Frame());
    }

    public static BowlingGame startGame() {
        return new BowlingGame();
    }

    public void throwBall(int score) {
        Frame frame = frameScores.get(currentFrame);
        if (score == 10) {
            frame.firstThrow = score;
            currentFrame++;
        } else {
            if (frame.firstThrow == null) {
                frame.firstThrow = score;
            } else {
                frame.secondThrow = score;
                currentFrame++;
            }
        }
        this.currentScore += score;
    }

    public int currentScore() {
        return currentScore;
    }

    public int currentFrame() {
        return currentFrame + 1;
    }

    public void printResults() {

    }


    private static class Frame {
        private Integer firstThrow;
        private Integer secondThrow;
    }

}
