import utils.*;

public class DroneFlyingExample {

    public static void main(String[] args) {
        System.out.println("Starting 2x Lite Drone");
        operate2xLiteDrone();
        System.out.println("Starting 8x Professional Drone");
        operate8xProfessionalDrone();
    }

    private static void operate8xProfessionalDrone() {
        final OperateDrone droneInterface = new Operate8xProfessionalDrone();
        final RcControllerListener listener = new RcControllerListener(droneInterface);
        listener.listen(RcCommand.UP);
        listener.listen(RcCommand.ACCELERATE);
        listener.listen(RcCommand.LEFT);
        listener.listen(RcCommand.LEFT);
        listener.listen(RcCommand.RIGHT);
        listener.listen(RcCommand.DECELERATE);
        listener.listen(RcCommand.DOWN);
    }

    private static void operate2xLiteDrone() {
        final OperateDrone droneInterface = new Operate2xLiteDrone();
        final RcControllerListener listener = new RcControllerListener(droneInterface);
        listener.listen(RcCommand.UP);
        listener.listen(RcCommand.ACCELERATE);
        listener.listen(RcCommand.LEFT);
        listener.listen(RcCommand.LEFT);
        listener.listen(RcCommand.RIGHT);
        listener.listen(RcCommand.DECELERATE);
        listener.listen(RcCommand.DOWN);
    }
}
