package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * DepthFirstMaze.
 * Использует стек для отслеживания текущей ячейки и выполнения генерации.
 * Стартует с одной начальной ячейки и случайно выбирает
 * непосещенных соседей для создания пути.
 * Удаляет стены между текущей ячейкой и выбранным соседом.
 */
public final class DepthFirstMaze implements MazeGenerator {
    private static final int MOVE_UP = -2;
    private static final int MOVE_DOWN = 2;
    private static final int MOVE_LEFT = -2;
    private static final int MOVE_RIGHT = 2;
    private Node[][] map;
    private Random random;

    /**
     * Generates a maze of the specified height and width
     * using the depth-first algorithm.
     * Subclasses may override this method
     * to customize the maze generation process.
     *
     * @param height The height of the maze.
     * @param width  The width of the maze.
     * @return The generated maze.
     */
    @Override
    public Maze generateMaze(final int height, final int width) {
        Maze maze = new Maze(height, width);
        map = maze.getMap();
        random = new Random();

        int startX = 1;
        int startY = 1;
        Node startNode = map[startY][startX];
        Node exitNode = map[height - 2][width - 2];

        startNode.setType(Node.Type.EMPTY);

        Stack<Node> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node currentCell = stack.peek();
            List<Node> unvisitedNeighbors = getUnvisitedNeighbors(
                currentCell, width, height
            );

            if (!unvisitedNeighbors.isEmpty()) {
                Node neighbor = unvisitedNeighbors.get(
                    random.nextInt(unvisitedNeighbors.size())
                );
                removeWallBetween(currentCell, neighbor);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }

        exitNode.setType(Node.Type.EMPTY);

        return maze;
    }

    private List<Node> getUnvisitedNeighbors(
        final Node cell,
        final int width,
        final int height
    ) {
        int x = cell.getColumn();
        int y = cell.getRow();
        List<Node> neighbors = new ArrayList<>();

        int[][] directions = {
            {0, MOVE_UP}, {0, MOVE_DOWN}, {MOVE_LEFT, 0}, {MOVE_RIGHT, 0}
        };

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int newX = x + dx;
            int newY = y + dy;

            if (isValid(newX, newY, width, height)
                && map[newY][newX].getType() == Node.Type.WALL) {
                neighbors.add(map[newY][newX]);
            }
        }
        return neighbors;
    }

    private void removeWallBetween(
        final Node firstCell,
        final Node secondCell
    ) {
        int firstRow = firstCell.getRow();
        int firstColumn = firstCell.getColumn();
        int secondRow = secondCell.getRow();
        int secondColumn = secondCell.getColumn();

        int wallRow = (firstRow + secondRow) / 2;
        int wallColumn = (firstColumn + secondColumn) / 2;

        map[wallRow][wallColumn].setType(Node.Type.EMPTY);
        secondCell.setType(Node.Type.EMPTY);
    }

    private boolean isValid(
        final int x,
        final int y,
        final int width,
        final int height
    ) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
