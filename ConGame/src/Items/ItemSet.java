package Items;

public class ItemSet {

    private Item item;
    private int qnty;

    public ItemSet(Item item, int qnty) {
        if(item == null || qnty < 0) throw new IllegalArgumentException("Invalid parameters received at ItemSet.");

        this.item = item;
        this.qnty = qnty;
    }

    public ItemSet(Item item) {
        this(item, 1);
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return qnty;
    }

    public int setQuantity(int qnty) {
        if(qnty < 0) return -1;
        if(qnty > item.getMaxStack()) {
            this.qnty = item.getMaxStack();
            return qnty - item.getMaxStack();
        }

        this.qnty = qnty;
        return -1;
    }

    public int addOne() {
        if(!isMaxStack()) {
            this.qnty++;
            return 0;
        }

        return 1;
    }

    public void removeOne() {
        if(qnty > 0) this.qnty--;
    }

    public boolean isMaxStack() {
        return this.qnty == item.getMaxStack();
    }

    @Override
    public String toString() {
        return item.getName() + "(" + qnty + ")";
    }
}
