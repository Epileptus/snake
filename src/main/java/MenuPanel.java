import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {
    private JLabel score;
    private JCheckBox impassableWalls;
    private JLabel impassableWallsDescription;

    MenuPanel() {
        setMaximumSize(new Dimension(400, 100));
        setPreferredSize(new Dimension(400, 100));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        impassableWalls = new JCheckBox();
        this.add(impassableWalls);

        impassableWallsDescription = new JLabel("Impassable walls");
        this.add(impassableWallsDescription);
        layout.putConstraint(SpringLayout.WEST, impassableWallsDescription, 0, SpringLayout.EAST, impassableWalls);

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
    JLabel getImpassableWallsDescription() {
        return impassableWallsDescription;
    }
}
