package Commands;

public enum Commands {

    LEFT,
    RIGHT,
    UP,
    DOWN,
    CLIMB,
    DESC,
    DIG,
    TAKE,
    INSPECT,
    EXIT,
    UNKNOWN;

    @Override
    public String toString() {
        switch(this) {
            case LEFT:
                return "left";
            case RIGHT:
                return "right";
            case UP:
                return "up";
            case DOWN:
                return "down";
            case CLIMB:
                return "climb";
            case DESC:
                return "desc";
            case DIG:
                return "dig";
            case TAKE:
                return "take";
            case INSPECT:
                return "inspect";
            case EXIT:
                return "exit";
            default:
                return "unknown command";
        }
    }

    public static Commands toCommand(String command) {
        switch(command) {
            case "left":
                return LEFT;
            case "right":
                return RIGHT;
            case "up":
                return UP;
            case "down":
                return DOWN;
            case "climb":
                return CLIMB;
            case "desc":
                return DESC;
            case "dig":
                return DIG;
            case "take":
                return TAKE;
            case "inspect":
                return INSPECT;
            case "exit":
                return EXIT;
            default:
                return UNKNOWN;
        }
    }
}
