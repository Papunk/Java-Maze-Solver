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
    public void getFromImage(String name) {
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

        //
        image.getRaster().getDataBuffer();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(image.getRGB(i, j));
            }
        }









    }


}
