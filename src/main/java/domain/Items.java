package domain;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private static final String DELIMITER = ",";

    private final List<Item> items;

    public Items(String itemInput) {
        this.items = initializeItems(itemInput);
    }

    private List<Item> initializeItems(String itemInput) {
        String[] itemNames = itemInput.split(DELIMITER);
        List<Item> items = new ArrayList<>();
        for (String name : itemNames) {
            items.add(new Item(name));
        }
        return items;
    }

    public Item getItem(int index) {
        return items.get(index);
    }
}
