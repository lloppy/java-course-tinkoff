package edu.maze.solver;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class BreadthFirstSearchMazeSolver implements MazeSolver {
    private final Maze maze;

    public BreadthFirstSearchMazeSolver(final Maze generatedMaze) {
        this.maze = generatedMaze;
    }

    @Override
    public List<Node> solve(final Node start, final Node end) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getRow() == end.getRow()
                && current.getColumn() == end.getColumn()
            ) {
                return reconstructPath(current);
            }
            current.setIsVisited();

            for (Node neighbor : getNeighbors(current)) {
                if (!neighbor.isVisited()
                    && neighbor.getType() != Node.Type.WALL
                ) {
                    neighbor.setParent(current);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Node> getNeighbors(final Node node) {
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

    private boolean isValidLocation(final int x, final int y) {
        if (x >= 0 && x < maze.getHeight() && y >= 0 && y < maze.getWidth()) {
            Node cell = maze.getCell(x, y);
            return cell.getType() == Node.Type.EMPTY;
        }
        return false;
    }

    private List<Node> reconstructPath(final Node currentNode) {
        Node current = currentNode;
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.getParent();
        }
        return path;
    }
}
