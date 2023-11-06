package edu.maze.model;

public final class Maze {
    private final int width;
    private final int height;
    private final Node[][] map;

    public Maze(final int mazeHeight, final int mazeWidth) {
        this.width = mazeWidth;
        this.height = mazeHeight;
        this.map = new Node[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                map[row][column] = new Node(column, row, Node.Type.WALL);
            }
        }
    }

    public Node getCell(final int x, final int y) {
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
