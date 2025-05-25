/**
 * Represents a single journal entry with mood and gratitude message.
 */
public class JournalEntry {
    private int mood; // Mood scale 1–10
    private String gratitudeNote;

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

    public String toString() {
        return "Mood: " + mood + "\nGratitude: " + gratitudeNote;
    }
}