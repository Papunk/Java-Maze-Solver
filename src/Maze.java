import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Maze {

    private MazeBlock[][] maze;

    public Maze() {
//        this.maze = new MazeBlock[height][width];
    }


    /**
     * This method turns loads an image as a Maze
     */
    public void getFromImage(String name, int emptyColor, int wallColor, int entranceColor, int exitColor) {
        BufferedImage image = null;
        // try to load image
        try {
            image = ImageIO.read(new File(name));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // make sure image was loaded
        if (image == null) {
            System.out.println("image is null");
            return;
        }

        // initialize necessary values
        int width = image.getWidth();
        int height = image.getHeight();
        maze = new MazeBlock[height][width];

        // TODO hold tally of entrances and (maybe) exits

        // generate a maze object based on the image
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (image.getRGB(i, j) == emptyColor) {
                    maze[i][j] = new MazeBlock(j, i, SpaceType.EMPTY);
                }
                else if (image.getRGB(i, j) == wallColor) {
                    maze[i][j] = new MazeBlock(j, i, SpaceType.WALL);
                }
                else if (image.getRGB(i, j) == entranceColor) {
                    maze[i][j] = new MazeBlock(j, i, SpaceType.ENTRANCE);
                }
                else if (image.getRGB(i, j) == exitColor) {
                    maze[i][j] = new MazeBlock(j, i, SpaceType.EXIT);
                }
//                System.out.println(image.getRGB(i, j));
            }
        }









    }


}
