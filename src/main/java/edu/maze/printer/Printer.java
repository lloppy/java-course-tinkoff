package edu.maze.printer;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import edu.maze.utils.Ansi;
import java.util.List;

public final class Printer {
    private Printer() {
    }

    public static void printMaze(final Maze maze, final String algorithmName) {
        Node[][] map = maze.getMap();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int column = 0; column < maze.getWidth(); column++) {
                Node node = map[row][column];

                if (row == 1 && column == 1) {
                    print(Ansi.GREEN_BLOCK);
                } else if (node.getType() == Node.Type.WALL) {
                    print(Ansi.WHITE_BLOCK);
                } else {
                    print(Ansi.BLACK_BLOCK);
                }
            }
            println(String.format(Ansi.EMPTY_BLOCK, algorithmName));
        }
    }

    public static void printEnd(final int width, final String algorithmName) {
        for (int i = 0; i < width; i++) {
            print(Ansi.WHITE_BLOCK);
        }
        println(String.format(Ansi.EMPTY_BLOCK, algorithmName));
    }

    public static void printSolveMaze(
        final Maze maze,
        final List<Node> path,
        final String algorithmName
    ) {
        int i = path.size() - 1;
        Node[][] map = maze.getMap();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int column = 0; column < maze.getWidth(); column++) {
                Node node = map[row][column];

                if (node.getRow() == path.get(0).getRow()
                    && node.getColumn() == path.get(0).getColumn()) {
                    print(Ansi.RED_BLOCK);

                } else {
                    if (nodeContainsInArray(path, node)) {
                        print(Ansi.GREEN_BLOCK);
                    } else {
                        if (node.getType() == Node.Type.WALL) {
                            print(Ansi.WHITE_BLOCK);
                        } else {
                            print(Ansi.BLACK_BLOCK);
                        }
                    }
                }
            }
            println(String.format(Ansi.EMPTY_BLOCK, algorithmName));
        }
    }

    private static boolean nodeContainsInArray(
        final List<Node> path,
        final Node node
    ) {
        boolean isContains = false;
        for (Node nodeInPath : path) {
            if (nodeInPath.getColumn() == node.getColumn()
                && nodeInPath.getRow() == node.getRow()) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void print(final String line) {
        System.out.print(line);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void println(final String line) {
        System.out.println(line);
    }
}
