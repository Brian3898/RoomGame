package Character;

import Items.Item;
import Items.ItemSet;

import java.util.HashSet;
import java.util.Iterator;

public class Inventory {

    private HashSet<ItemSet> items;
    private int maxItems;

    public Inventory(int size) {
        if(size < 0) throw new IllegalArgumentException("Invalid parameter received at Inventory.");

        this.maxItems = size;
        this.items = new HashSet<>();
    }

    public HashSet<ItemSet> getItems() {
        return items;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setItems(HashSet<ItemSet> items) {
        this.items = items;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * Adds items to the inventory, will split them into different item slots if the added quantity exceeds the stack limit.
     * @param item
     * @param qnty
     */
    public void addItem(Item item, int qnty) {
        if(item == null) return;
        if(maxItems == items.size()) return;

        ItemSet setToAdd;
        for(ItemSet set : items) {
            if(set.getItem().equals(item)) {
                setToAdd = set;
                while (qnty != 0) {
                    if (setToAdd.isMaxStack()) {
                        if(items.size() == maxItems) return;
                        setToAdd = new ItemSet(item, 0);
                        items.add(setToAdd);
                    }

                    while (!setToAdd.isMaxStack() && qnty > 0) {
                        setToAdd.addOne();
                        qnty--;
                    }
                }
            }
        }

        setToAdd = new ItemSet(item, 0);
        items.add(setToAdd);
        while(qnty != 0) {
            if (setToAdd.isMaxStack()) {
                if(items.size() == maxItems) return;
                setToAdd = new ItemSet(item, 0);
                items.add(setToAdd);
            }

            while (!setToAdd.isMaxStack() && qnty > 0) {
                setToAdd.addOne();
                qnty--;
            }
        }
    }

    /**
     * Removes items from a stack, provided they are the same as the parameter.
     * Will remove from other existing stacks, if they exist.
     * @param item
     * @param qnty
     */
    public void removeItem(Item item, int qnty) {
        if(item == null) return;

        Iterator it = items.iterator();
        while(it.hasNext()) {
            ItemSet set = (ItemSet) it.next();
            if(set.getItem().equals(item)) {
                if (set.getQuantity() > qnty) {
                    set.setQuantity(set.getQuantity() - qnty);
                    break;
                } else {
                    qnty = qnty - set.getQuantity();
                    it.remove();
                }
            }
        }
    }

    public ItemSet getItemSet(Item item) {
        for(ItemSet set : items) if(set.getItem().equals(item)) return set;

        return null;
    }

    @Override
    public String toString() {
        if(items.size() == 0) return "EMPTY";
        else {
            StringBuilder inv = new StringBuilder();
            for(ItemSet set : items) {
                inv.append(set.getItem().getName());
                inv.append(" - ");
                inv.append(set.getQuantity());
                inv.append("\n");
            }

            return inv.toString();
        }
    }


}
