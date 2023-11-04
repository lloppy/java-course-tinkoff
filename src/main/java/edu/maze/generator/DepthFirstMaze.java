package edu.maze.generator;

import edu.maze.model.Maze;
import edu.maze.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DepthFirstMaze implements MazeGenerator {
    @Override
    public Maze generateMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        Node[][] map = maze.getMap();
        Random random = new Random();

        int startX = 1;
        int startY = 1;
        map[startY][startX].setType(Node.Type.EMPTY);

        Stack<Node> stack = new Stack<>();
        stack.push(map[startY][startX]);

        while (!stack.isEmpty()) {
            Node currentCell = stack.peek();
            List<Node> unvisitedNeighbors = getUnvisitedNeighbors(currentCell, map, width, height);

            if (!unvisitedNeighbors.isEmpty()) {
                Node neighbor = unvisitedNeighbors.get(random.nextInt(unvisitedNeighbors.size()));
                connectCells(currentCell, neighbor, map);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }
        return maze;
    }

    private List<Node> getUnvisitedNeighbors(Node cell, Node[][] map, int width, int height) {
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

    private void connectCells(Node cell1, Node cell2, Node[][] map) {
        int x1 = cell1.getColumn();
        int y1 = cell1.getRow();
        int x2 = cell2.getColumn();
        int y2 = cell2.getRow();
        int middleX = (x1 + x2) / 2;
        int middleY = (y1 + y2) / 2;

        map[middleY][middleX].setType(Node.Type.EMPTY);
        cell2.setType(Node.Type.EMPTY);
    }

    private boolean isValid(int x, int y, int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
