package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.Random;
import java.util.Stack;

/**
 * RecursiveBacktrackerMaze.
 * Использует рекурсивный метод для генерации лабиринта.
 * Рекурсивно перемещается от текущей ячейки к случайному непосещенному соседу,
 * пока не будет достигнута конечная ячейка.
 * Удаляет стены между текущей ячейкой и выбранным соседом
 * при обратном ходе (backtracking).
 */
public final class RecursiveBacktrackerMaze implements MazeGenerator {
    private Node[][] map;

    @Override
    public Maze generateMaze(final int height, final int width) {
        Maze maze = new Maze(height, width);
        this.map = maze.getMap();
        Random random = new Random();
        Stack<Node> stack = new Stack<>();

        Node startNode = map[0][0];
        Node exitNode = map[height - 1][width - 1];
        startNode.setType(Node.Type.EMPTY);
        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node currentCell = stack.peek();
            currentCell.setIsVisited();
            Node[] neighbors = getUnvisitedNeighbors(currentCell);

            if (neighbors.length > 0) {
                Node randomNeighbor =
                    neighbors[random.nextInt(neighbors.length)];
                removeWallBetween(currentCell, randomNeighbor);
                stack.push(randomNeighbor);
            } else {
                stack.pop();
            }
        }

        startNode.setType(Node.Type.EMPTY);
        exitNode.setType(Node.Type.EMPTY);

        return maze;
    }

    private Node[] getUnvisitedNeighbors(final Node node) {
        int row = node.getRow();
        int column = node.getColumn();
        int height = map.length;
        int width = map[0].length;
        Stack<Node> neighbors = new Stack<>();

        if (row > 1 && !map[row - 2][column].isVisited()) {
            neighbors.push(map[row - 2][column]);
        }
        if (row < height - 2 && !map[row + 2][column].isVisited()) {
            neighbors.push(map[row + 2][column]);
        }
        if (column > 1 && !map[row][column - 2].isVisited()) {
            neighbors.push(map[row][column - 2]);
        }
        if (column < width - 2 && !map[row][column + 2].isVisited()) {
            neighbors.push(map[row][column + 2]);
        }

        return neighbors.toArray(new Node[0]);
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

        secondCell.setType(Node.Type.EMPTY);
        map[wallRow][wallColumn].setType(Node.Type.EMPTY);
    }
}
