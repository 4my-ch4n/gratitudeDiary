import java.io.*;
import java.util.ArrayList;

/**
 * Manages a collection of journal entries and file storage.
 */
public class GratitudeJournal {
    private ArrayList<JournalEntry> entries;
    private int[][] moodFrequencies; // [mood level][count]

    public GratitudeJournal() {
        entries = new ArrayList<>();
        moodFrequencies = new int[11][1]; // mood 1-10 (index 0 unused)
    }

    /**
     * Adds a journal entry and updates frequency tracker.
     * @param entry the JournalEntry to add
     */
    public void addEntry(JournalEntry entry) {
        entries.add(entry);
        if (entry.getMood() >= 1 && entry.getMood() <= 10) {
            moodFrequencies[entry.getMood()][0]++;
        }
        saveEntryToFile(entry);
    }

    /**
     * Saves a single entry to the file.
     * @param entry the entry to write
     */
    public void saveEntryToFile(JournalEntry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("gratitude_journal.txt", true))) {
            writer.write(entry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    /**
     * Saves all entries and average mood to the file.
     */
    public void saveAllToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("gratitude_journal.txt"))) {
            for (JournalEntry e : entries) {
                writer.write(e.toString());
                writer.newLine();
            }
            writer.write("Average Mood: " + calculateAverageMood());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write all entries.");
        }
    }

    /**
     * Calculates and returns the average mood.
     * @return average mood as double
     */
    public double calculateAverageMood() {
        if (entries.isEmpty()) return 0;
        int sum = 0;
        for (JournalEntry e : entries) {
            sum += e.getMood();
        }
        return (double) sum / entries.size();
    }

    /**
     * Prints all journal entries.
     */
    public void displayEntries() {
        for (JournalEntry e : entries) {
            System.out.println(e);
        }
    }

    /**
     * Displays mood frequency analysis.
     */
    public void printMoodFrequency() {
        System.out.println("Mood Frequency:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Mood " + i + ": " + moodFrequencies[i][0]);
        }
    }

    public ArrayList<JournalEntry> getEntries() {
        return entries;
    }
}
