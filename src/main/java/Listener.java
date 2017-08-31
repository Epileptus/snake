import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class Listener implements KeyListener {

    private MainFrame frame;
    private SnakeHead snakeHead;
     Listener(MainFrame frame){
        this.frame=frame;
        snakeHead = frame.getGamePanel().getSnakeHead();
    }
    Date delay = new Date();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        Date newDelay = new Date();
//        while(newDelay.getTime()-delay.getTime()<frame.getDelay()){
//            newDelay = new Date();
//        }
            delay=newDelay;
            if (e.getKeyCode() == KeyEvent.VK_UP && snakeHead.getYSpeed() != 1) {
                snakeHead.setXSpeed(0);
                snakeHead.setYSpeed(-1);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && snakeHead.getYSpeed() != -1) {
                snakeHead.setXSpeed(0);
                snakeHead.setYSpeed(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && snakeHead.getXSpeed() != 1) {
                snakeHead.setXSpeed(-1);
                snakeHead.setYSpeed(0);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snakeHead.getXSpeed() != -1) {
                snakeHead.setXSpeed(1);
                snakeHead.setYSpeed(0);
            }
    }

    public void keyReleased(KeyEvent e) {

    }
}
