import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Stores and manages journal entries.
 */
public class GratitudeJournal {
    private ArrayList<JournalEntry> entries;

    public GratitudeJournal() {
        entries = new ArrayList<>();
    }

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
        try {
            saveEntryToFile(entry); // Automatically save each new entry
        } catch (IOException e) {
            System.out.println("Failed to save entry to file.");
        }
    }

    public void saveEntryToFile(JournalEntry entry) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("gratitude_journal.txt", true));
        writer.write("Date: " + java.time.LocalDate.now() + "\n");
        writer.write("Mood: " + entry.getMood() + "\n");
        writer.write("Gratitude: " + entry.getNote() + "\n");
        writer.write("------\n");
        writer.close();
    }

    public void saveAllToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("gratitude_journal.txt"));
        for (JournalEntry entry : entries) {
            writer.write("Date: " + java.time.LocalDate.now() + "\n");
            writer.write("Mood: " + entry.getMood() + "\n");
            writer.write("Gratitude: " + entry.getNote() + "\n");
            writer.write("------\n");
        }
        double average = calculateAverageMood();
        writer.write("\nAverage Mood: " + String.format("%.2f", average) + "\n");
        writer.close();
    }

    public double calculateAverageMood() {
        if (entries.isEmpty()) return 0;
        int sum = 0;
        for (JournalEntry e : entries) {
            sum += e.getMood();
        }
        return (double) sum / entries.size();
    }

    public ArrayList<JournalEntry> getEntries() {
        return entries;
    }

    public void displayEntries() {
        for (JournalEntry e : entries) {
            System.out.println(e);
            System.out.println("------");
        }
    }
}
