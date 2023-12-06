package edu.hw9.task3;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiThreadedDepthFirstTest {

    @Test
    void generateMaze_ValidDimensions_MazeHasCorrectDimensions() {
        MultiThreadedDepthFirst generator = new MultiThreadedDepthFirst();
        int height = 10;
        int width = 10;
        int numberOfThreads = 3;

        Maze maze = generator.generateMaze(height, width, numberOfThreads);

        assertEquals(height, maze.getHeight());
        assertEquals(width, maze.getWidth());
    }

    @Test
    void generateMaze_AllCellsAreWallsOrEmpty() {
        MultiThreadedDepthFirst generator = new MultiThreadedDepthFirst();
        int height = 10;
        int width = 10;
        int numberOfThreads = 4;

        Maze maze = generator.generateMaze(height, width, numberOfThreads);

        Node[][] map = maze.getMap();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Node.Type type = map[i][j].getType();
                assertTrue(type == Node.Type.WALL || type == Node.Type.EMPTY);
            }
        }
    }

}
