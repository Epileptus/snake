import lombok.Data;

@Data
public class SnakeTail implements SnakePart {
    private int y;
    private int x;
    private int previousX;
    private int previousY;
    private SnakePart snakePart;

    SnakeTail(SnakePart snakePart) {
        x = snakePart.getPreviousX();
        y = snakePart.getPreviousY();
        this.snakePart = snakePart;
    }

    @Override
    public void move() {
        previousX = x;
        previousY = y;
        x = snakePart.getPreviousX();
        y = snakePart.getPreviousY();
    }
}
