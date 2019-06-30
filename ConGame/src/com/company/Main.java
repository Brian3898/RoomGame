package com.company;

import Input.*;
import Items.Item;
import Items.ItemSet;
import Rooms.Map;
import Rooms.Room;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	    Room liv = new Room("Living Room", null, null, null, null, null, null);
        Room garden = new Room("Garden", null, null, null, null, null, null);
        Room hall = new Room("Hall", null, null, null, null, null, null);
        Room attic = new Room("Attic", null, null, null, null, null, null);
        Room kitchen = new Room("Kitchen", null, null, null, null, null, null);
        Room bath = new Room("Bathroom", null, null, null, null, null, null);
        Room bed = new Room("Bedroom", null, null, null, null, null, null);

        liv.setLeft(hall);
        liv.setRight(kitchen);
        liv.setUpper(bath);
        liv.setLower(bed);

        hall.setLeft(garden);
        hall.setRight(liv);
        hall.setUp(attic);

        attic.setDown(hall);
        garden.setRight(hall);

        kitchen.setLeft(liv);
        bath.setLower(liv);
        bed.setUpper(liv);

        HashSet<Room> rooms = new HashSet<>();
        rooms.add(liv);
        rooms.add(garden);
        rooms.add(hall);
        rooms.add(attic);
        rooms.add(kitchen);
        rooms.add(bath);
        rooms.add(bed);

        Map map = new Map(garden, rooms);

        CommandParser parser = new CommandParser(map);
        parser.start();
    }
}
