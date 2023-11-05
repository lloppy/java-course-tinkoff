package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.printer.Printer;
import org.junit.jupiter.api.Test;

class DepthFirstMazeTest {

    @Test
    void generateMaze() {
        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(25,30);

        Printer.printMaze(maze, "DFS");
    }
}
