/**
 * Represents a single entry in the gratitude journal.
 */
public class JournalEntry {
    private int mood;
    private String gratitudeNote;

    /**
     * Constructs a journal entry with mood and note.
     * @param mood the mood level (1-10)
     * @param note the gratitude note
     */
    public JournalEntry(int mood, String note) {
        this.mood = mood;
        this.gratitudeNote = note;
    }

    public int getMood() {
        return mood;
    }

    public String getNote() {
        return gratitudeNote;
    }

    @Override
    public String toString() {
        return "Mood: " + mood + " | Note: " + gratitudeNote;
    }
}