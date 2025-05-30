import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Displays a mood graph using a bar chart.
 */
public class MoodGraph extends JPanel implements Displayable {
    private ArrayList<JournalEntry> entries;

    public MoodGraph(ArrayList<JournalEntry> entries) {
        this.entries = entries;
    }

    public void display() {
        JFrame frame = new JFrame("Mood Graph");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        for (JournalEntry e : entries) {
            g.setColor(Color.BLUE);
            g.fillRect(x, 250 - e.getMood() * 20, 20, e.getMood() * 20);
            x += 30;
        }
    }
}
