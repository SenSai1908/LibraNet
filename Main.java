package activity2;

import java.util.List;

/**
 * Main class demonstrating the refactored LibraNet system with a LibraryService.
 */
public class Main {
    public static void main(String[] args) {
        Library libraNet = new Library();
        LibraryService service = new LibraryService(); // Create the service

        // --- Add items to the library ---
        System.out.println("--- Populating Library ---");
        try {
            libraNet.addItem(new Book("The Hobbit", "J.R.R. Tolkien", 101, 310));
            libraNet.addItem(new Audiobook("Dune", "Frank Herbert", 201, "1260 minutes"));
            libraNet.addItem(new EMagazine("National Geographic", "NatGeo Society", 301, 202409));
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating item: " + e.getMessage());
        }

        libraNet.listAllItems();

        // --- Demonstrate Operations using the Service ---
        System.out.println("\n--- Demonstrating Operations ---");

        LibraryItem hobbit = libraNet.findItemById(101);
        if (hobbit != null) {
            service.borrowItem(hobbit); // Use service to borrow
        }

        // Trying to borrow an already borrowed item
        if (hobbit != null) {
            service.borrowItem(hobbit);
        }

        // Returning an item
        if (hobbit != null) {
            service.returnItem(hobbit); // Use service to return
        }

        libraNet.listAllItems();

        // --- Demonstrate Specialized Behaviors (These remain on the objects) ---
        System.out.println("\n--- Demonstrating Specialized Behaviors ---");
        LibraryItem dune = libraNet.findItemById(201);
        if (dune instanceof Playable) {
            ((Playable) dune).play();
        }
    }
}

