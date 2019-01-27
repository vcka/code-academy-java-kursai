package utils;

public class Operate8xProfessionalDrone implements OperateDrone {
    public void up() {
        System.out.println("Drone 8x Professional Lite goes up");
    }

    public void down() {
        System.out.println("Drone 8x Professional goes down");
    }

    public void left(int angle) {
        System.out.println(String.format("Drone 8x Professional turns left by %s degrees", angle));
    }

    public void right(int angle) {
        System.out.println(String.format("Drone 8x Professional turns right by %s degrees", angle));
    }

    public void accelerate() {
        System.out.println("Drone 8x Professional accelerates");
    }

    public void decelerate() {
        System.out.println("Drone 8x Professional decelerates");
    }
}
