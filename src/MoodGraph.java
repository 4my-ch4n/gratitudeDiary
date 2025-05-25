import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Visualizes mood trends using bar chart.
 */
public class MoodGraph extends JPanel implements Displayable {
    private ArrayList<JournalEntry> data;

    public MoodGraph(ArrayList<JournalEntry> data) {
        this.data = data;
    }

    public void display() {
        JFrame frame = new JFrame("Mood Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        for (JournalEntry e : data) {
            g.setColor(Color.CYAN);
            g.fillRect(x, 250 - e.getMood() * 20, 20, e.getMood() * 20);
            x += 30;
        }
    }
}