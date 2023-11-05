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
 * Удаляет стены между текущей ячейкой и выбранным соседом при обратном ходе (backtracking).
 */
public class RecursiveBacktrackerMaze implements MazeGenerator {
    private Node[][] map;

    @Override
    public Maze generateMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        map = maze.getMap();
        Random random = new Random();
        Stack<Node> stack = new Stack<>();

        Node startNode = map[0][0];
        Node exitNode = map[height - 1][width - 1];
        startNode.setType(Node.Type.EMPTY);
        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node currentCell = stack.peek();
            currentCell.isVisited = true;
            Node[] neighbors = getUnvisitedNeighbors(currentCell, map);

            if (neighbors.length > 0) {
                Node randomNeighbor = neighbors[random.nextInt(neighbors.length)];
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

    private Node[] getUnvisitedNeighbors(Node node, Node[][] map) {
        int row = node.getRow();
        int col = node.getColumn();
        int height = map.length;
        int width = map[0].length;
        Stack<Node> neighbors = new Stack<>();

        if (row > 1 && !map[row - 2][col].isVisited) {
            neighbors.push(map[row - 2][col]);
        }
        if (row < height - 2 && !map[row + 2][col].isVisited) {
            neighbors.push(map[row + 2][col]);
        }
        if (col > 1 && !map[row][col - 2].isVisited) {
            neighbors.push(map[row][col - 2]);
        }
        if (col < width - 2 && !map[row][col + 2].isVisited) {
            neighbors.push(map[row][col + 2]);
        }

        return neighbors.toArray(new Node[0]);
    }

    private void removeWallBetween(Node cell1, Node cell2) {
        int row1 = cell1.getRow();
        int col1 = cell1.getColumn();
        int row2 = cell2.getRow();
        int col2 = cell2.getColumn();

        int wallRow = (row1 + row2) / 2;
        int wallCol = (col1 + col2) / 2;

        cell2.setType(Node.Type.EMPTY);
        map[wallRow][wallCol].setType(Node.Type.EMPTY);
    }
}

