package Input;

import Commands.Commands;
import Rooms.Map;
import java.util.Scanner;


public class CommandParser {

    private Scanner scanner;
    private Map map;

    public CommandParser(Map map) {
        if(map == null) throw new IllegalArgumentException("Null parameter received at CommandParser.");

        this.scanner = new Scanner(System.in);
        this.map = map;
    }

    public void start() {
        System.out.println("You're in the " + map.getCurrentRoom().getRoomName());
        while(true) {
            System.out.print("Insert a command:\n> ");
            act(scanner.nextLine());
        }
    }

    //TO-DO: Implement Player class.
    private void act(String command) {
        switch(Commands.toCommand(command.toLowerCase())) {
            case LEFT:
                if(map.getCurrentRoom().hasRequiredItem()) {
                    if(!map.moveLeft()) System.out.println("Nothing in that direction...");
                    if(!player.hasItem(map.getCurrentRoom().getRequiredItem())) {
                        System.out.println("You need a(n) " + map.getCurrentRoom().getRequiredItem().getName() + "!");
                        map.moveRight();
                        return;
                    }

                    System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                } else {
                    if(map.moveLeft()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                    else System.out.println("Nothing in that direction...");
                }
                break;
            case RIGHT:
                if(map.moveRight()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                else System.out.println("Nothing in that direction...");
                break;
            case UP:
                if(map.moveUpper()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                else System.out.println("Nothing in that direction...");
                break;
            case DOWN:
                if(map.moveLower()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                else System.out.println("Nothing in that direction...");
                break;
            case CLIMB:
                if(map.moveUp()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                else System.out.println("Nothing in that direction...");
                break;
            case DESC:
                if(map.moveDown()) System.out.println("You've entered the " + map.getCurrentRoom().getRoomName());
                else System.out.println("Nothing in that direction...");
                break;
            case DIG:
                System.out.println("DIGGING");
                break;
            case TAKE:
                System.out.println("TAKING");
                break;
            case INSPECT:
                System.out.println(map.getCurrentRoom().toString());
                break;
            case EXIT:
                System.out.println("EXITING");
                System.exit(0);
                break;
            case UNKNOWN:
                System.out.println("I'M NOT SURE...");
                break;
        }
    }

}
