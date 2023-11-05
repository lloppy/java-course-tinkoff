package edu.maze.solver;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.List;

public interface MazeSolver {
    List<Node> solve(Maze maze, Node start, Node end);
}
