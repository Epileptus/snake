import javax.swing.*;

public class Game {


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(100);
        GamePanel gamePanel = mainFrame.getGamePanel();
        while (!mainFrame.isOver()) {
            while (!gamePanel.isDead()) {

                try {
                    Thread.sleep(mainFrame.getDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
                gamePanel.getMenuPanel().enableOptions();
            }
        }
        mainFrame.dispose();
    }
}
