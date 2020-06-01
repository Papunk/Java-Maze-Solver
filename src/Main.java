import javax.swing.*;


public class Main {

    public static int squareSize = 1, windowSize = 200;

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(windowSize,windowSize);
        window.setTitle("Maze");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        Grid grid = new Grid(windowSize/squareSize, windowSize/squareSize, squareSize);
        MazeMaker mazeMaker = new MazeMaker();
        mazeMaker.generateMaze(grid.getGrid(), Direction.RIGHT, 0, 0, windowSize / 8);

        window.add(grid);
        window.setVisible(true);

    }
}
