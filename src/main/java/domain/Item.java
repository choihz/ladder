package domain;

import exception.InvalidItemException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Item {
    private static final int MIN_ITEM_LENGTH = 1;
    private static final int MAX_ITEM_LENGTH = 5;

    private final String item;

    public Item(String item) {
        validateItem(item);
        this.item = item;
    }

    private void validateItem(String item) {
        if (item.length() < MIN_ITEM_LENGTH || item.length() > MAX_ITEM_LENGTH
                || StringUtils.isBlank(item)) {
            throw new InvalidItemException("1~5자만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item1 = (Item) o;
        return Objects.equals(item, item1.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return item;
    }
}
