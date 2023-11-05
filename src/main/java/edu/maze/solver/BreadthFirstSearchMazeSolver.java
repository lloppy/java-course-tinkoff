package edu.maze.solver;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchMazeSolver implements MazeSolver {
    private final Maze maze;

    public BreadthFirstSearchMazeSolver(Maze maze) {
        this.maze = maze;
    }

    @Override
    public List<Node> solve(Node start, Node end) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getRow() == end.getRow() && current.getColumn() == end.getColumn()) {
                return reconstructPath(current);
            }
            current.isVisited = true;

            for (Node neighbor : getNeighbors(current)) {
                if (!neighbor.isVisited && neighbor.getType() != Node.Type.WALL) {
                    neighbor.parent = current;
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Node> getNeighbors(Node node) {
        int row = node.getRow();
        int col = node.getColumn();
        List<Node> neighbors = new ArrayList<>();

        if (isValidLocation(row - 1, col)) {
            neighbors.add(maze.getCell(row - 1, col));
        }
        if (isValidLocation(row + 1, col)) {
            neighbors.add(maze.getCell(row + 1, col));
        }
        if (isValidLocation(row, col - 1)) {
            neighbors.add(maze.getCell(row, col - 1));
        }
        if (isValidLocation(row, col + 1)) {
            neighbors.add(maze.getCell(row, col + 1));
        }

        return neighbors;
    }

    private boolean isValidLocation(int x, int y) {
        if (x >= 0 && x < maze.getHeight() && y >= 0 && y < maze.getWidth() ) {
            Node cell = maze.getCell(x, y);
            return cell.getType() == Node.Type.EMPTY;
        }
        return false;
    }

    private List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        return path;
    }
}
