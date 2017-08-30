import java.util.List;

public interface SnakePart {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    int getPreviousX();
    int getPreviousY();
    void setPreviousX(int x);
    void setPreviousY(int y);
    int getYSpeed();
    int getXSpeed();
    List<SnakePart> getParts();
}
