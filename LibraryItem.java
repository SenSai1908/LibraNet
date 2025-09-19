package activity2;

import java.time.LocalDate;

/**
 * Abstract base class representing a generic library item.
 * Now acts as a simpler data container, with logic handled by LibraryService.
 */
public abstract class LibraryItem {
    private String title;
    private String author;
    private int itemId;
    private boolean isAvailable;
    private LocalDate borrowDate;

    public LibraryItem(String title, String author, int itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
        this.isAvailable = true;
    }

    // --- Getters and Setters for state management ---

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getItemId() { return itemId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }

    @Override
    public String toString() {
        return "ID: " + itemId + ", Title: '" + title + "', Author: '" + author + "', Available: " + isAvailable;
    }
}

