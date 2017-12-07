import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {
    private JLabel score;
    private JCheckBox impassableWalls;
    private JCheckBox epilepsyMode;

    MenuPanel() {
        setMaximumSize(new Dimension(400, 100));
        setPreferredSize(new Dimension(400, 100));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        impassableWalls = new JCheckBox("Impassable walls");
        this.add(impassableWalls);


        epilepsyMode = new JCheckBox("Epilepsy mode");
        this.add(epilepsyMode);
        layout.putConstraint(SpringLayout.NORTH, epilepsyMode, 0, SpringLayout.SOUTH, impassableWalls);


        score = new JLabel("Score : 0");
        this.add(score);
        layout.putConstraint(SpringLayout.EAST, score, 0, SpringLayout.EAST, this);
    }

    JLabel getScore() {
        return score;
    }

    JCheckBox getImpassableWalls() {
        return impassableWalls;
    }

    JCheckBox getEpilepsyMode() {
        return epilepsyMode;
    }

    void enableOptions() {
        impassableWalls.setEnabled(true);
        epilepsyMode.setEnabled(true);
    }

    void disableOptions() {
        impassableWalls.setEnabled(false);
        epilepsyMode.setEnabled(false);
    }
}
