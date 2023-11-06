package edu.maze.solver;

import edu.maze.model.Node;
import java.util.List;

public interface MazeSolver {
    List<Node> solve(Node start, Node end);
}
