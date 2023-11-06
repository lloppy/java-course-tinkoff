package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.printer.Printer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepthFirstMazeTest {

    @Test
    void generateMaze() {
        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(11, 12);

        assertTrue(maze.getHeight() == 11);
        assertTrue(maze.getWidth() == 12);
        assertTrue(maze.getMap().length != 0);

        Printer.printMaze(maze, "DFS");
    }
}
