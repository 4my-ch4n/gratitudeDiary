import java.util.Scanner;

/**
 * Main app to interact with user and run journal.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GratitudeJournal journal = new GratitudeJournal();

        while (true) {
            System.out.println("\n1. New Entry\n2. View Journal\n3. Show Mood Graph\n4. Save to File\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Rate your mood (1-10): ");
                int mood = sc.nextInt();
                sc.nextLine();
                System.out.print("What are you grateful for today? ");
                String note = sc.nextLine();
                journal.addEntry(new JournalEntry(mood, note));
            } else if (choice == 2) {
                journal.displayEntries();
                System.out.println("Average Mood: " + journal.calculateAverageMood());
            } else if (choice == 3) {
                MoodGraph graph = new MoodGraph(journal.getEntries());
                graph.display();
            } else if (choice == 4) {
                try {
                    journal.saveAllToFile();
                    System.out.println("Journal saved!");
                } catch (Exception e) {
                    System.out.println("Error saving journal.");
                }
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }

        sc.close();
    }
}