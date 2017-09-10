import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SnakeHead implements SnakePart {
    private int xSpeed;
    private int ySpeed;
    private int x;
    private int y;
    private int previousX;
    private int previousY;
    private final List<SnakePart> parts = new ArrayList<>();

    SnakeHead() {
        x = 19;
        y = 19;
        parts.add(this);
    }

    public void setX(int x) {
        if (x > 38)
            this.x = 0;
        else if (x < 0)
            this.x = 38;
        else
            this.x = x;
    }

    public void setY(int y) {
        if (y > 36)
            this.y = 0;
        else if (y < 0)
            this.y = 36;
        else
            this.y = y;
    }

    void moveAll() {
        for (SnakePart part : parts) {
            part.move();
        }
    }

    @Override
    public void move() {
        previousX = x;
        previousY = y;
        setX(x + xSpeed);
        setY(y + ySpeed);
    }
}
