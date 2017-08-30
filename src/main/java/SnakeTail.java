import lombok.Data;

import java.util.List;

@Data
public class SnakeTail implements SnakePart{
    private int y;
    private int x;
    private int previousX;
    private int previousY;

    SnakeTail(SnakePart snakePart){
        x=snakePart.getPreviousX();
        y=snakePart.getPreviousY();
    }

    @Override
    public int getYSpeed() {
        return 0;
    }
    @Override
    public int getXSpeed() {
        return 0;
    }
    @Override
    public List<SnakePart> getParts() {
        return null;
    }
}
