package edu.hw9.task3;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class MultiThreadedDepthFirst {
    private static final int MOVE_UP = -2;
    private static final int MOVE_DOWN = 2;
    private static final int MOVE_LEFT = -2;
    private static final int MOVE_RIGHT = 2;

    private Node[][] map;
    private Random random;
    private ExecutorService executor;

    public Maze generateMaze(final int height, final int width, final int numberOfThreads) {
        Maze maze = new Maze(height, width);
        map = maze.getMap();
        random = new Random();
        executor = Executors.newFixedThreadPool(numberOfThreads);

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
                executor.execute(() -> removeWallBetween(currentCell, neighbor));
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }

        exitNode.setType(Node.Type.EMPTY);

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

