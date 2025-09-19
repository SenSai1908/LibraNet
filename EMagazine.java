package activity2;

/**
 * Represents an electronic magazine with an issue number.
 */
public class EMagazine extends LibraryItem {
    private int issueNumber;

    /**
     * Constructor for EMagazine.
     *
     * @param title       The title of the e-magazine.
     * @param author      The publisher of the e-magazine.
     * @param itemId      The unique integer ID of the e-magazine.
     * @param issueNumber The issue number of the e-magazine.
     */
    public EMagazine(String title, String author, int itemId, int issueNumber) {
        super(title, author, itemId);
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be positive.");
        }
        this.issueNumber = issueNumber;
    }

    /**
     * Archives the specific issue of the e-magazine.
     */
    public void archiveIssue() {
        System.out.println("Archiving e-magazine issue #" + issueNumber + " of '" + getTitle() + "'.");
    }
    
    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "[E-Magazine] " + super.toString() + ", Issue: " + issueNumber;
    }
}

