import javax.swing.*;
import java.awt.*;

 class MenuPanel extends JPanel{
    private JLabel score;
     MenuPanel(){
        setMaximumSize(new Dimension(400,100));
        setPreferredSize(new Dimension(400,100));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

         JCheckBox passableWalls = new JCheckBox("Impassable walls");
        this.add(passableWalls);
        passableWalls.setEnabled(false);

        score = new JLabel("Score : 0");
        this.add(score);
        layout.putConstraint(SpringLayout.EAST,score,0,SpringLayout.EAST,this);
    }

     JLabel getScore(){
        return score;
    }
}
