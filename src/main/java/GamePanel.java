import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GamePanel extends JPanel {


    private int foodX;
    private int foodY;
    private List<Integer> obstacleX = new ArrayList<>();
    private List<Integer> obstacleY = new ArrayList<>();
    private Field[][] fields = new Field[40][37];
    private final SnakeHead snakeHead = new SnakeHead();
    private MenuPanel menuPanel;
    private boolean dead;

    GamePanel() {
        setMaximumSize(new Dimension(400, 400));
        for (Field[] field : fields) {
            Arrays.fill(field, new Field(""));
        }
        fields[19][19] = new Field("snake");
        createFood();
    }


    void canDie() {
        for (int i = 1; i < snakeHead.getParts().size(); i++) {
            if (snakeHead.getX() == snakeHead.getParts().get(i).getX() && snakeHead.getY() == snakeHead.getParts().get(i).getY())
                die();
        }
        if (menuPanel.getImpassableWalls().isSelected()) {
            if (snakeHead.getX() == 0 || snakeHead.getY() == 0)
                die();
        }
        for (int i = 0; i < obstacleX.size(); i++) {
            if (snakeHead.getX() == obstacleX.get(i) && snakeHead.getY() == obstacleY.get(i))
                die();
        }

    }

    boolean isDead() {
        return dead;
    }

    void die() {
        dead = true;
    }

    void canEatFood() {
        if (snakeHead.getX() == foodX && snakeHead.getY() == foodY)
            eatFood();

    }

    void eatFood() {
        snakeHead.getParts().add(new SnakeTail(snakeHead.getParts().get(snakeHead.getParts().size() - 1)));
        menuPanel.getScore().setText("Score : " + (snakeHead.getParts().size() - 1));
        createFood();
        canCreateObstacle();
    }

    private void createFood() {
        Random generator = new Random();
        foodX = generator.nextInt(39);
        foodY = generator.nextInt(36);
        if (!fields[foodX][foodY].isEmpty())
            createFood();
    }


    private void canCreateObstacle() {
        if ((snakeHead.getParts().size() - 1) % 5 == 0) {
            createObstacle();
        }
    }

    private void createObstacle() {
        Random generator = new Random();
        int newX = generator.nextInt(39);
        int newY = generator.nextInt(36);
        if (fields[newX][newY].isEmpty() && newX != snakeHead.getX() && newY != snakeHead.getY()) {
            obstacleX.add(newX);
            obstacleY.add(newY);
        } else
            createObstacle();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        for (Field[] field : fields) {
            Arrays.fill(field, new Field(""));
        }

        fields[foodX][foodY] = new Field("food");

        if (!obstacleX.isEmpty()) {
            for (int i = 0; i < obstacleX.size(); i++) {
                fields[obstacleX.get(i)][obstacleY.get(i)] = new Field("obstacle");
            }
        }

        for (SnakePart part : snakeHead.getParts()) {
            fields[part.getX()][part.getY()] = new Field("snake");
        }


        for (int i = 0; i < 40; i++) {
            for (int k = 0; k < 37; k++) {
                switch (fields[i][k].getContent()) {
                    case "snake":
                        if (!menuPanel.getEpilepsyMode().isSelected())
                            g.setColor(Color.WHITE);
                        else {
                            Random generator = new Random();
                            int x = generator.nextInt(2);
                            int y = generator.nextInt(155) + 100;
                            int z = generator.nextInt(155) + 100;
                            switch (x) {
                                case 0:
                                    g.setColor(new Color(0, y, z));
                                    break;
                                case 1:
                                    g.setColor(new Color(y, 0, z));
                                    break;
                                default:
                                    g.setColor(new Color(y, z, 0));
                                    break;
                            }
                        }
                        break;
                    case "food":
                        g.setColor(Color.GREEN);
                        break;
                    case "obstacle":
                        g.setColor(Color.RED);
                        break;
                    default:
                        g.setColor(Color.BLACK);
                        break;
                }
                g.fillRect(i * 10, k * 10, 10, 10);
            }
        }
    }

    SnakeHead getSnakeHead() {
        return snakeHead;
    }

    void setMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
