

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;


public class GamePanel extends JPanel{


    private int foodX;
    private int foodY;
    private Field[][] fields = new Field[40][37];
    private final SnakePart snakeHead = new SnakeHead();
    private MenuPanel menuPanel;
    private boolean dead;

     GamePanel(){
        setMaximumSize(new Dimension(400,400));
        for(Field[] field : fields){
            Arrays.fill(field,new Field(""));
        }
        fields[19][19] = new Field("snake");
        createFood();
    }


     boolean canEatFood(){
        return snakeHead.getX() == foodX && snakeHead.getY() == foodY;
    }
     private void createFood(){
        Random generator = new Random();
        foodX = generator.nextInt(39);
        foodY = generator.nextInt(36);
        if(!fields[foodX][foodY].getContent().equals(""))
            createFood();
    }
     void canDie(){
        for(int i=1 ; i<snakeHead.getParts().size() ; i++){
            if(snakeHead.getX()==snakeHead.getParts().get(i).getX() && snakeHead.getY()==snakeHead.getParts().get(i).getY()){

                dead=true;
            }

        }
    }
     boolean isDead(){
        return dead;
    }
     void eatFood(){
        snakeHead.getParts().add(new SnakeTail(snakeHead.getParts().get(snakeHead.getParts().size()-1)));
        //fields[snakeHead.getParts().get(snakeHead.getParts().size()-1).getX()][snakeHead.getParts().get(snakeHead.getParts().size()-1).getY()] = new Field("snake");
        menuPanel.getScore().setText("Score : " +(snakeHead.getParts().size()-1));
        createFood();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        for(Field[] field : fields){
            Arrays.fill(field,new Field(""));
        }
        fields[foodX][foodY] = new Field("food");

        for(SnakePart part : snakeHead.getParts()){
            fields[part.getX()][part.getY()]=new Field("snake");
        }


        for(int i=0 ; i<40 ;i++){
            for(int k=0 ; k<37 ; k++){
                switch (fields[i][k].getContent()) {
                    case "snake":
                        g.setColor(Color.WHITE);
                        break;
                    case "food":
                        g.setColor(Color.GREEN);
                        break;
                    default:
                        g.setColor(Color.BLACK);
                        break;
                }

                g.fillRect(i*10,k*10,10,10);
            }
        }
    }
     SnakeHead getSnakeHead(){
        return (SnakeHead) snakeHead;
    }
     void setMenuPanel(MenuPanel menuPanel){
        this.menuPanel=menuPanel;
    }
}
