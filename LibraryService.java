package activity2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Handles business logic for library operations like borrowing, returning, and fines.
 * This centralizes logic, making the item classes simpler data holders.
 */
public class LibraryService {

    private static final double FINE_PER_DAY = 10.0;
    private static final int BORROWING_PERIOD_DAYS = 14;

    /**
     * Borrows a library item, updating its state.
     * @param item The item to be borrowed.
     */
    public void borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            item.setAvailable(false);
            item.setBorrowDate(LocalDate.now());
            System.out.println("'" + item.getTitle() + "' has been borrowed.");
        } else {
            System.out.println("'" + item.getTitle() + "' is currently unavailable.");
        }
    }

    /**
     * Returns a library item, updating its state and reporting fines.
     * @param item The item to be returned.
     */
    public void returnItem(LibraryItem item) {
        if (!item.isAvailable()) {
            item.setAvailable(true);
            double fine = calculateFine(item);
            if (fine > 0) {
                System.out.println("'" + item.getTitle() + "' has been returned. Fine incurred: ₹" + fine);
            } else {
                System.out.println("'" + item.getTitle() + "' has been returned. No fine.");
            }
            item.setBorrowDate(null); // Reset borrow date
        } else {
            System.out.println("'" + item.getTitle() + "' was not borrowed.");
        }
    }

    /**
     * Calculates the fine for a given item based on its borrow date.
     * @param item The item to calculate the fine for.
     * @return The calculated fine amount.
     */
    private double calculateFine(LibraryItem item) {
        if (item.getBorrowDate() == null) {
            return 0;
        }
        long daysBorrowed = ChronoUnit.DAYS.between(item.getBorrowDate(), LocalDate.now());
        long overdueDays = daysBorrowed - BORROWING_PERIOD_DAYS;
        if (overdueDays > 0) {
            return overdueDays * FINE_PER_DAY;
        }
        return 0;
    }
}
