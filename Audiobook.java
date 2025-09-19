package activity2;

/**
 * Represents an audiobook. It implements the Playable interface for playback functionality.
 */
public class Audiobook extends LibraryItem implements Playable {
    private int durationInMinutes;

    /**
     * Constructor for Audiobook.
     *
     * @param title            The title of the audiobook.
     * @param author           The author of the audiobook.
     * @param itemId           The unique integer ID of the audiobook.
     * @param durationString   The duration of the audiobook as a string (e.g., "120 minutes").
     */
    public Audiobook(String title, String author, int itemId, String durationString) {
        super(title, author, itemId);
        this.durationInMinutes = parseDuration(durationString);
    }
    
    /**
     * Parses the duration string to extract the number of minutes.
     *
     * @param durationString A string representing the duration.
     * @return The duration in minutes as an integer.
     * @throws IllegalArgumentException if the string is not in a valid format.
     */
    private int parseDuration(String durationString) {
        try {
            String numericPart = durationString.replaceAll("[^0-9]", "").trim();
            if (numericPart.isEmpty()) {
                 throw new NumberFormatException("No numeric value found in duration string.");
            }
            int duration = Integer.parseInt(numericPart);
            if (duration <= 0) {
                throw new IllegalArgumentException("Duration must be a positive value.");
            }
            return duration;
        } catch (NumberFormatException e) {
            // This catches parsing errors or empty strings after filtering
            System.err.println("Error parsing duration: '" + durationString + "'. Setting duration to 0.");
            // Or throw a more specific exception for robust error handling
            // throw new IllegalArgumentException("Invalid duration format: " + durationString, e);
            return 0; // Default value in case of error
        }
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: '" + getTitle() + "'.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping audiobook: '" + getTitle() + "'.");
    }

    @Override
    public String toString() {
        return "[Audiobook] " + super.toString() + ", Duration: " + durationInMinutes + " mins";
    }
}
