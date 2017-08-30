import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    private MainFrame frame;
    private SnakeHead snakeHead;
     Listener(MainFrame frame){
        this.frame=frame;
        snakeHead = frame.getGamePanel().getSnakeHead();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP && snakeHead.getYSpeed()!=1){
            snakeHead.setXSpeed(0);
            snakeHead.setYSpeed(-1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && snakeHead.getYSpeed()!=-1){
            snakeHead.setXSpeed(0);
            snakeHead.setYSpeed(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && snakeHead.getXSpeed()!=1){
            snakeHead.setXSpeed(-1);
            snakeHead.setYSpeed(0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT && snakeHead.getXSpeed()!=-1){
            snakeHead.setXSpeed(1);
            snakeHead.setYSpeed(0);
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
