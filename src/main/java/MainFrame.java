import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

class MainFrame extends JFrame {
    private GamePanel gamePanel;
    private int delay;
    private boolean over;
    private Listener listener;

    MainFrame(int delay) {
        this.delay = delay;
        setPreferredSize(new Dimension(400, 500));
        setSize(new Dimension(400, 500));
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snek (press escape to quit)");
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
        this.listener = listener;

        pack();
    }

    GamePanel getGamePanel() {
        return gamePanel;
    }

    int getDelay() {
        return delay;
    }

    boolean isOver() {
        return over;
    }

    void setOver() {
        this.over = true;
    }

    Listener getListener() {
        return listener;
    }
}
