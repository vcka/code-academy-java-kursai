package utils;


public interface OperateDrone {
    void up();

    void down();

    void left(int angle);

    void right(int angle);

    void accelerate();

    void decelerate();
}
