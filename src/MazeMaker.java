import java.util.Random;

public class MazeMaker {

    Random random = new Random();

    /**
     * Recursive function that traverses a Grid object
     * of GridSpaces with SpaceType Wall and transforms
     * some into SpaceType EMPTY to form a maze.
     *
     * @param matrix The grid that is to be converted into a maze
     */
    public void generateMaze(GridSpace[][] matrix, Direction startingDirection, int startingX, int startingY, int bound) {
        //TODO add some input validation

        int moves = 0;
        int x = startingX;
        int y = startingY;
        Direction currentDirection = startingDirection;

        while (moves < bound) {
            matrix[x][y].setType(SpaceType.EMPTY);

            if (moveIsLegal(matrix, currentDirection, x, y)) {
                // move
                switch (currentDirection) {
                    case RIGHT: x++; break;
                    case LEFT: x--; break;
                    case UP: y--; break;
                    default: y++;
                }
                moves++;
            } else return;

            if (moves % 10 == 0) generateMaze(matrix, changeDirection(currentDirection), x, y, bound-moves);
        }
    }

    // fixed jdk issue
    public Direction changeDirection(Direction currentDirection) {
        return switch (currentDirection) {
            case RIGHT, LEFT -> chooseRandomDir(new Direction[]{Direction.UP, Direction.DOWN});
            case UP, DOWN -> chooseRandomDir(new Direction[]{Direction.LEFT, Direction.UP});
        };
    }

    public Direction chooseRandomDir(Direction[] dirs) {
        return dirs[random.nextInt(dirs.length)];
    }

    public Boolean moveIsLegal(GridSpace[][] matrix, Direction direction, int x, int y) {
        switch (direction) {
            case RIGHT:
                if (x == matrix.length - 1) return false;
                else return matrix[x+1][y].getType() != SpaceType.EMPTY;
            case LEFT:
                if (x == 0) return false;
                else return matrix[x-1][y].getType() != SpaceType.EMPTY;
            case UP:
                if (y == 0) return false;
                else return matrix[x][y-1].getType() != SpaceType.EMPTY;
            default:
                if (y == matrix[0].length - 1) return false;
                else return matrix[x][y+1].getType() != SpaceType.EMPTY;
        }
    }

    public Boolean validate() {
        return null;
    }
}
