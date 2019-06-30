package Items;

import java.util.Objects;

public class Item {

    private final int MAX_STACK;
    private String name;

    public Item(String name, int MAX_STACK) {
        if(name == null || MAX_STACK <= 0) throw new IllegalArgumentException("Invalid parameter received at Item.");

        this.name = name;
        this.MAX_STACK = MAX_STACK;
    }

    public int getMaxStack() {
        return MAX_STACK;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
