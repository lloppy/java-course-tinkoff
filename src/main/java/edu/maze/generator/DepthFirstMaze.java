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
public class DepthFirstMaze implements MazeGenerator {
    private Node[][] map;
    private Random random;

    @Override
    public Maze generateMaze(int height, int width) {
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
            List<Node> unvisitedNeighbors = getUnvisitedNeighbors(currentCell, width, height);

            if (!unvisitedNeighbors.isEmpty()) {
                Node neighbor = unvisitedNeighbors.get(random.nextInt(unvisitedNeighbors.size()));
                removeWallBetween(currentCell, neighbor);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }

        exitNode.setType(Node.Type.EMPTY);

        return maze;
    }

    private List<Node> getUnvisitedNeighbors(Node cell, int width, int height) {
        int x = cell.getColumn();
        int y = cell.getRow();
        List<Node> neighbors = new ArrayList<>();

        int[][] directions = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}};

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            int newX = x + dx;
            int newY = y + dy;

            if (isValid(newX, newY, width, height) && map[newY][newX].getType() == Node.Type.WALL) {
                neighbors.add(map[newY][newX]);
            }
        }
        return neighbors;
    }

    private void removeWallBetween(Node cell1, Node cell2) {
        int row1 = cell1.getRow();
        int col1 = cell1.getColumn();
        int row2 = cell2.getRow();
        int col2 = cell2.getColumn();

        int wallRow = (row1 + row2) / 2;
        int wallCol = (col1 + col2) / 2;

        map[wallRow][wallCol].setType(Node.Type.EMPTY);
        cell2.setType(Node.Type.EMPTY);
    }

    private boolean isValid(int x, int y, int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
