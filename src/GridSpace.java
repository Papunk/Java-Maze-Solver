import java.awt.Rectangle;

public class GridSpace extends Rectangle{

    private SpaceType type;
    private int squareSize;

    public GridSpace(int x, int y, int squareSize, SpaceType type) {
        super(x, y, squareSize, squareSize);
        this.type = type;
        this.squareSize = squareSize;
    }

    public SpaceType getType() {
        return type;
    }
    public void setType(SpaceType type) {
        this.type = type;
    }
    public int getSquareSize() {
        return squareSize;
    }
}
