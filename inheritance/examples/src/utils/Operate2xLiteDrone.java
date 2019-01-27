package utils;

public class Operate2xLiteDrone implements OperateDrone {
    public void up() {
        System.out.println("Drone 2x Lite goes up");
    }

    public void down() {
        System.out.println("Drone 2x Lite goes down");
    }

    public void left(int angle) {
        System.out.println(String.format("Drone 2x Lite turns left by %s degrees", angle));
    }

    public void right(int angle) {
        System.out.println(String.format("Drone 2x Lite turns right by %s degrees", angle));
    }

    public void accelerate() {
        System.out.println("Drone 2x Lite accelerates");

    }

    public void decelerate() {
        System.out.println("Drone 2x Lite decelerates");

    }
}
