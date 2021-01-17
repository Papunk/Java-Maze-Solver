public class MazeBlock {

    private final int x, y;
    private final SpaceType spaceType;

    public MazeBlock(int x, int y, SpaceType spaceType) {
        this.x = x;
        this.y = y;
        this.spaceType = spaceType;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public SpaceType getSpaceType() {
        return this.spaceType;
    }
}
