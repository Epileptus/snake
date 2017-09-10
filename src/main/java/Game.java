import javax.swing.*;
import java.net.MalformedURLException;

public class Game {


    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        MainFrame mainFrame = new MainFrame(100);
        GamePanel gamePanel = mainFrame.getGamePanel();
        while (!mainFrame.isOver()) {
            while (!gamePanel.isDead()) {

                Thread.sleep(mainFrame.getDelay());

                mainFrame.requestFocus();

                mainFrame.getListener().setReady();

                gamePanel.canEatFood();

                gamePanel.getSnakeHead().moveAll();

                gamePanel.canDie();

                gamePanel.repaint();
            }
            if (!mainFrame.isOver()) {
                JOptionPane.showMessageDialog(mainFrame, "Game over");
                mainFrame.dispose();
                mainFrame = new MainFrame(100);
                gamePanel = mainFrame.getGamePanel();
                gamePanel.getMenuPanel().getImpassableWalls().setEnabled(true);
                gamePanel.getMenuPanel().getImpassableWallsDescription().setEnabled(true);
            }
        }
        mainFrame.dispose();
    }
}
