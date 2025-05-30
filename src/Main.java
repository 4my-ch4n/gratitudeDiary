import java.util.Scanner;

/**
 * Main class to run the Gratitude Journal application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GratitudeJournal journal = new GratitudeJournal();
        int choice;

        do {
            System.out.println("\n1. New Entry\n2. View Entries\n3. Show Mood Graph\n4. Save All\n5. Mood Frequency\n6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter your mood (1-10): ");
                int mood = sc.nextInt();
                sc.nextLine();
                System.out.print("What are you grateful for today? ");
                String note = sc.nextLine();

                if (mood <= 3) {
                    System.out.println("We're sorry you're feeling low. Consider talking to a friend or taking a break!");
                }

                journal.addEntry(new JournalEntry(mood, note));
            } else if (choice == 2) {
                journal.displayEntries();
            } else if (choice == 3) {
                MoodGraph graph = new MoodGraph(journal.getEntries());
                graph.display();
            } else if (choice == 4) {
                journal.saveAllToFile();
            } else if (choice == 5) {
                journal.printMoodFrequency();
            }
        } while (choice != 6);

        System.out.println("Goodbye!");
    }
}
