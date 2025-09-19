package activity2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages a collection of LibraryItems.
 * Supports adding, finding, and listing items.
 */
public class Library {
    private List<LibraryItem> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a new item to the library's collection.
     *
     * @param item The LibraryItem to add.
     */
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added to library: " + item.getTitle());
    }

    /**
     * Finds a library item by its unique ID.
     *
     * @param itemId The ID of the item to find.
     * @return The LibraryItem if found, otherwise null.
     */
    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    /**
     * Lists all items currently in the library's collection.
     */
    public void listAllItems() {
        System.out.println("\n--- Library Inventory ---");
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            for (LibraryItem item : items) {
                System.out.println(item);
            }
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Searches for items of a specific class type (e.g., Book.class).
     *
     * @param type The class type to search for.
     * @return A list of items matching the specified type.
     */
    public <T extends LibraryItem> List<T> findItemsByType(Class<T> type) {
        return items.stream()
                    .filter(type::isInstance)
                    .map(type::cast)
                    .collect(Collectors.toList());
    }
}

