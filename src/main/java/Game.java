import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public class Game {


    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        MainFrame mainFrame;
        while (true) {
            mainFrame = new MainFrame();
            GamePanel gamePanel = mainFrame.getGamePanel();
            SnakeHead snakeHead = gamePanel.getSnakeHead();
            while (!gamePanel.isDead()) {
                Thread.sleep(100);
                snakeHead.setPreviousX(snakeHead.getX());
                snakeHead.setPreviousY(snakeHead.getY());
                snakeHead.setX(snakeHead.getX() + snakeHead.getXSpeed());
                snakeHead.setY(snakeHead.getY() + snakeHead.getYSpeed());
                if (gamePanel.canEatFood())
                    gamePanel.eatFood();
                gamePanel.canDie();
                for (int i = 1; i < snakeHead.getParts().size(); i++) {
                    SnakePart part = snakeHead.getParts().get(i);
                    part.setPreviousX(part.getX());
                    part.setPreviousY(part.getY());
                    part.setX(snakeHead.getParts().get(i - 1).getPreviousX());
                    part.setY(snakeHead.getParts().get(i - 1).getPreviousY());
                }

                gamePanel.repaint();
            }

            String filePath = new File("").getAbsolutePath();
            filePath+="\\src\\main\\resources\\dedsnek.jpg";
            final ImageIcon icon = new ImageIcon(filePath);
            JOptionPane.showMessageDialog(mainFrame,"             GAME OVER","",JOptionPane.INFORMATION_MESSAGE,icon);
            mainFrame.dispose();

        }

    }
}
