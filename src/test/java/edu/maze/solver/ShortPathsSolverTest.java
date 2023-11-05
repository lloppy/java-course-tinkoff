package edu.maze.solver;

import edu.maze.generator.DepthFirstMaze;
import edu.maze.generator.MazeGenerator;
import edu.maze.model.Maze;
import edu.maze.model.Node;
import edu.maze.printer.Printer;
import org.junit.jupiter.api.Test;

class ShortPathsSolverTest {

    @Test
    void solve() {
        int height = 4;
        int width = 10;

        Node start = new Node(1, 1, Node.Type.EMPTY);
        Node exit = new Node(height - 2, width - 2, Node.Type.EMPTY);

        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(
            height,
            width
        );

        Printer.printMaze(maze, "Dij" );
        Printer.printEnd(width, "Dij");

    }
}
