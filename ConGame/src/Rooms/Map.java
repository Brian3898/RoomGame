package Rooms;

import java.util.HashSet;

public class Map {

    private Room currRoom;
    private HashSet<Room> rooms;

    public Map(Room room, HashSet<Room> rooms) {
        if(rooms == null || room == null) throw new IllegalArgumentException("Null parameter received at Map.");

        this.rooms = rooms;
        this.currRoom = room;
    }

    public Room getCurrentRoom() {
        return currRoom;
    }

    public boolean moveLeft() {
        if(currRoom.getLeft() == null) return false;
        currRoom = currRoom.getLeft();
        return true;
    }

    public boolean moveRight() {
        if(currRoom.getRight() == null) return false;
        currRoom = currRoom.getRight();
        return true;
    }

    public boolean moveUp() {
        if(currRoom.getUp() == null) return false;
        currRoom = currRoom.getUp();
        return true;
    }

    public boolean moveDown() {
        if(currRoom.getDown() == null) return false;
        currRoom = currRoom.getDown();
        return true;
    }

    public boolean moveUpper() {
        if(currRoom.getUpper() == null) return false;
        currRoom = currRoom.getUpper();
        return true;
    }

    public boolean moveLower() {
        if(currRoom.getLower() == null) return false;
        currRoom = currRoom.getLower();
        return true;
    }
}
