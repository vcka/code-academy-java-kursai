package utils;

public class RcControllerListener {

    private final OperateDrone droneInterface;

    public RcControllerListener(OperateDrone droneInterface) {
        this.droneInterface = droneInterface;
    }

    public void listen(RcCommand command) {
        switch (command) {
            case UP: {
                droneInterface.up();
                break;
            }
            case DOWN: {
                droneInterface.down();
                break;
            }
            case LEFT: {
                droneInterface.left(3);
                break;
            }
            case RIGHT: {
                droneInterface.right(3);
                break;
            }
            case ACCELERATE: {
                droneInterface.accelerate();
                break;
            }
            case DECELERATE: {
                droneInterface.decelerate();
                break;
            }
        }
    }

}
