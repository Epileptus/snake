import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    private MainFrame frame;
    private SnakeHead snakeHead;
    private boolean ready = true;

    Listener(MainFrame frame) {
        this.frame = frame;
        snakeHead = frame.getGamePanel().getSnakeHead();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int event = e.getKeyCode();
        if (ready) {
            if (event == KeyEvent.VK_UP && snakeHead.getYSpeed() != 1) {
                snakeHead.setXSpeed(0);
                snakeHead.setYSpeed(-1);
            } else if (event == KeyEvent.VK_DOWN && snakeHead.getYSpeed() != -1) {
                snakeHead.setXSpeed(0);
                snakeHead.setYSpeed(1);
            } else if (event == KeyEvent.VK_LEFT && snakeHead.getXSpeed() != 1) {
                snakeHead.setXSpeed(-1);
                snakeHead.setYSpeed(0);
            } else if (event == KeyEvent.VK_RIGHT && snakeHead.getXSpeed() != -1) {
                snakeHead.setXSpeed(1);
                snakeHead.setYSpeed(0);
            }
            else if (event == KeyEvent.VK_SPACE) {
                frame.getGamePanel().eatFood();
            }
            ready = false;
        }
        if (event == KeyEvent.VK_ESCAPE) {
            frame.getGamePanel().die();
            frame.setOver();
        }
        frame.getGamePanel().getMenuPanel().disableOptions();
    }

    void setReady() {
        ready = true;
    }

    public void keyReleased(KeyEvent e) {

    }
}
