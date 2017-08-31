import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public class Game {


    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        MainFrame mainFrame;
        while (true) {
            mainFrame = new MainFrame(100);
            GamePanel gamePanel = mainFrame.getGamePanel();
            SnakeHead snakeHead = gamePanel.getSnakeHead();
            while (!gamePanel.isDead()) {
                Thread.sleep(mainFrame.getDelay());
                if(snakeHead.getDirX()==0 && snakeHead.getXSpeed()!=0){
                    snakeHead.setDirX(snakeHead.getXSpeed());
                    snakeHead.setDirY(0);
                }
                else if(snakeHead.getDirY()==0 && snakeHead.getYSpeed()!=0) {
                    snakeHead.setDirX(0);
                    snakeHead.setDirY(snakeHead.getYSpeed());
                }
                snakeHead.setPreviousX(snakeHead.getX());
                snakeHead.setPreviousY(snakeHead.getY());
                snakeHead.setX(snakeHead.getX() + snakeHead.getDirX());
                snakeHead.setY(snakeHead.getY() + snakeHead.getDirY());
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
