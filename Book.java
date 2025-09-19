package activity2;

/**
 * Represents a physical book, extending the base LibraryItem.
 * Includes specialized properties like page count.
 */
public class Book extends LibraryItem {
    private int pageCount;

    /**
     * Constructor for Book.
     *
     * @param title     The title of the book.
     * @param author    The author of the book.
     * @param itemId    The unique integer ID of the book.
     * @param pageCount The number of pages in the book.
     */
    public Book(String title, String author, int itemId, int pageCount) {
        super(title, author, itemId);
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive.");
        }
        this.pageCount = pageCount;
    }

    /**
     * Gets the page count of the book.
     *
     * @return The total number of pages.
     */
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "[Book] " + super.toString() + ", Pages: " + pageCount;
    }
}
