import javax.swing.JComponent;
import java.awt.*;

public class Grid extends JComponent {

    private int numOfSquaresHor, numOfSquaresVer;
    private int squareSize;

    private GridSpace[][] grid;

    public Grid(int width, int height, int squareSize) {
        this.numOfSquaresHor = width;
        this.numOfSquaresVer = height;
        this.squareSize = squareSize;
        this.grid = new GridSpace[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new GridSpace(x * squareSize, y * squareSize, squareSize, SpaceType.WALL);
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        //TODO separate this from grid class?? maybe make a gridDrawer
        Graphics2D g2 = (Graphics2D) g;
        for (int x = 0; x < numOfSquaresHor; x++) {
            for (int y = 0; y < numOfSquaresVer; y++) {
                GridSpace space = grid[x][y];
                g2.setColor(space.getType().equals(SpaceType.WALL) ? Color.BLACK : Color.WHITE);
                g2.fill(space);
                g2.draw(space);
            }
        }
    }

    public int getNumOfSquaresHor() {
        return numOfSquaresHor;
    }
    public int getNumOfSquaresVer() {
        return numOfSquaresVer;
    }
    public GridSpace[][] getGrid() {
        return grid;
    }
}
