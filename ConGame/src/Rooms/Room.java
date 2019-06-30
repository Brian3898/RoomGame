package Rooms;

import Items.Item;
import Items.ItemSet;

import java.util.ArrayList;
import java.util.Iterator;

public class Room {

    private Room upper;
    private Room lower;
    private Room left;
    private Room right;
    private Room up;
    private Room down;

    private String roomName;
    private ArrayList<ItemSet> items;
    private Item requiredItem;

    public Room(String roomName, Item requiredItem, ArrayList<ItemSet> items, Room upper, Room lower, Room left, Room right, Room up, Room down) {
        if(roomName == null) {
            throw new IllegalArgumentException("Null room name received at Room.");
        }

        this.roomName = roomName;
        this.items = items;
        this.upper = upper;
        this.lower = lower;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.requiredItem = requiredItem;
    }

    public Room(String roomName, Item requiredItem, Room upper, Room lower, Room left, Room right, Room up, Room down) {
        this(roomName, requiredItem, null, upper, lower, left, right, up, down);
        this.items = new ArrayList<>();
    }

    public Room(String roomName, Room upper, Room lower, Room left, Room right, Room up, Room down) {
        this(roomName, null, null, upper, lower, left, right, up, down);
        this.items = new ArrayList<>();
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(Item requiredItem) {
        this.requiredItem = requiredItem;
    }

    public void setUpper(Room upper) {
        this.upper = upper;
    }

    public void setLower(Room lower) {
        this.lower = lower;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    public void setRight(Room right) {
        this.right = right;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room getUpper() {
        return upper;
    }

    public Room getLower() {
        return lower;
    }

    public Room getLeft() {
        return left;
    }

    public Room getRight() {
        return right;
    }

    public Room getUp() {
        return up;
    }

    public Room getDown() {
        return down;
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<ItemSet> getItems() {
        ArrayList<ItemSet> temp = new ArrayList<>();
        for(ItemSet set : items) {
            temp.add(new ItemSet(new Item(set.getItem().getName(), set.getItem().getMaxStack()), set.getQuantity()));
        }
        return temp;
    }

    public void addItem(ItemSet item) {
        if(item == null) return;

        items.add(item);
    }

    public ItemSet removeItem(Item item) {
        ItemSet temp = null;
        Iterator it = items.iterator();
        while(it.hasNext()) {
            ItemSet itTemp = (ItemSet) it.next();
            if(itTemp.getItem().equals(item)) {
                temp = itTemp;
                it.remove();
                break;
            }
        }

        return temp;
    }

    public ItemSet[] takeItems() {
        ItemSet[] took = new ItemSet[items.size()];
        for(int i = 0; i<items.size(); i++) {
            took[i] = items.get(i);
        }

        items.clear();
        return took;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(roomName); sb.append(":\n");
        sb.append("Items:\n");
        if(items.size() == 0) sb.append("None\n");
        for(ItemSet set : items) {
            sb.append("\t"); sb.append(set.toString()); sb.append("\n");
        }

        sb.append("\n");
        sb.append("Left: "); sb.append((left == null) ? "Empty" : left.getRoomName()); sb.append("\n");
        sb.append("Right: "); sb.append((right == null) ? "Empty" : right.getRoomName()); sb.append("\n");
        sb.append("Up: "); sb.append((up == null) ? "Empty" : up.getRoomName()); sb.append("\n");
        sb.append("Down: "); sb.append((down == null) ? "Empty" : down.getRoomName()); sb.append("\n");
        sb.append("Above: "); sb.append((upper == null) ? "Empty" : upper.getRoomName()); sb.append("\n");
        sb.append("Below: "); sb.append((lower == null) ? "Empty" : lower.getRoomName()); sb.append("\n");

        return sb.toString();
    }

    public boolean hasRequiredItem() {
        return requiredItem != null;
    }
}
