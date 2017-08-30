
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

 class MainFrame extends JFrame {
    private GamePanel gamePanel;


     MainFrame(){
        setPreferredSize(new Dimension(400,500));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snek");
        setResizable(false);


        JPanel container = new JPanel();
        setContentPane(container);
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);


        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setBorder(new LineBorder(Color.RED, 5));


        gamePanel = new GamePanel();
        gamePanel.setMenuPanel(menuPanel);
        container.add(gamePanel);
        container.add(menuPanel);

        Listener listener = new Listener(this);
        addKeyListener(listener);

        pack();
    }
     GamePanel getGamePanel(){
        return gamePanel;
    }
}
