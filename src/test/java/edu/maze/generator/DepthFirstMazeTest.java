package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.printer.Printer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepthFirstMazeTest {

    @Test
    void generateMaze() {
        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(30, 40);

        Printer.printMaze(maze, "DFS");

        assertTrue(maze.getHeight() == 30);
        assertTrue(maze.getWidth() == 40);
        assertTrue(maze.getMap().length != 0);
    }
}
