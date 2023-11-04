package edu.maze.model;

public class Maze {
    private final int width;
    private final int height;
    private final Node[][] map;

    public Maze(int height, int width) {
        this.width = width;
        this.height = height;
        this.map = new Node[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                map[row][col] = new Node(col, row, Node.Type.WALL);
            }
        }
    }

    public Node getCell(int x, int y) {
        return map[x][y];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Node[][] getMap() {
        return map;
    }
}
