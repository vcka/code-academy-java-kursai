
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private boolean multiply = false;
    private int multiplyTimes = 0;
    private int currentFrame;
    private int throwNumber;
    private int currentScore;
    private int[] scores;

    private BowlingGame() {
        currentFrame = 0;
        currentScore = 0;
        throwNumber = 1;
        scores = new int[21];
    }

    public static BowlingGame startGame() {
        return new BowlingGame();
    }

    public void throwBall(int score) {
        int multipliedScore = score;
        if (multiply) {
            multipliedScore *= 2;
            multiplyTimes--;
            if (multiplyTimes == 0) {
                multiply = false;
            }
        }

        scores[throwNumber - 1] = multipliedScore;
        if (score == 10) {
            multiply = true;
            multiplyTimes += 2;
            currentFrame++;
            throwNumber += 2;
        } else {
            if (throwNumber % 2 == 0) {
                currentFrame++;
            }
            throwNumber++;
        }
        this.currentScore += multipliedScore;
    }

    public int currentScore() {
        return currentScore;
    }

    public int currentFrame() {
        return currentFrame + 1;
    }

    public void printResults() {

    }


}
