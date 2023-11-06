package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.printer.Printer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursiveBacktrackerMazeTest {

    @Test
    void generateMap() {
        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(21,31);

        Printer.printMaze(maze, "RecursiveBacktracker");
        Printer.printEnd(31, "RecursiveBacktracker");

        assertTrue(maze.getHeight() == 21);
        assertTrue(maze.getWidth() == 31);
        assertTrue(maze.getMap().length != 0);
    }

}
