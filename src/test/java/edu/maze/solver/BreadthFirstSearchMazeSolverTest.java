package edu.maze.solver;

import edu.maze.generator.DepthFirstMaze;
import edu.maze.generator.MazeGenerator;
import edu.maze.model.Maze;
import edu.maze.model.Node;
import edu.maze.printer.Printer;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadthFirstSearchMazeSolverTest {
    @Test
    public void testSolve() {
        Maze maze = createTestMaze();
        BreadthFirstSearchMazeSolver solver = new BreadthFirstSearchMazeSolver(maze);

        Node start = maze.getCell(1, 1);
        Node end = maze.getCell(2, 2);

        List<Node> path = solver.solve(start, end);

        assertFalse(path.isEmpty());

        assertEquals(2, path.get(0).getColumn());
        assertEquals(2, path.get(path.size() - 2).getColumn());
        assertEquals(1, path.get(path.size() - 1).getColumn());

    }

    private Maze createTestMaze() {
        Maze maze = new Maze(3, 3);
        maze.getCell(1, 1).setType(Node.Type.EMPTY);
        maze.getCell(1, 2).setType(Node.Type.EMPTY);
        maze.getCell(2, 2).setType(Node.Type.EMPTY);
        return maze;

     /*   0   1   2
      * +---+---+---+
      0 |   |   |   |
        +---+---+---+
      1 |   |---|---|
        +---+---+---+
      2 |   |   |---|
        +---+---+---+
     */

    }

    @Test
    public void testSolveDepthFirst() {
        int height = 21;
        int wight = 36;
        MazeGenerator generator = new DepthFirstMaze();
        Maze maze = generator.generateMaze(height, wight);

        Printer.printMaze(maze, "DFS");

        Node start = maze.getCell(1, 1);
        Node end = maze.getCell(height - 2, wight - 2);

        MazeSolver solver = new BreadthFirstSearchMazeSolver(maze);
        List<Node> path = solver.solve(start, end);

        assertFalse(path.isEmpty());
        assertTrue(maze.getMap().length != 0);

        Printer.printSolveMaze(maze, path, "BreadthFirstSearch");
    }
}

