package edu.maze.printer;

import edu.maze.model.Maze;
import edu.maze.model.Node;
import java.util.List;

public final class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[40m";
    private static final String ANSI_WHITE = "\u001B[47m";
    private static final String ANSI_GREEN = "\u001B[42m";
    private static final String ANSI_RED = "\u001B[41m";
    private static final String ANSI_EMPTY = ANSI_WHITE + "  %s  " + ANSI_RESET;

    private Printer() {
    }

    public static void printMaze(final Maze maze, final String algorithmName) {
        Node[][] map = maze.getMap();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int column = 0; column < maze.getWidth(); column++) {
                Node node = map[row][column];

                if (row == 1 && column == 1) {
                    print(ANSI_GREEN + "   " + ANSI_RESET);
                } else if (node.getType() == Node.Type.WALL) {
                    print(ANSI_WHITE + "   " + ANSI_RESET);
                } else {
                    print(ANSI_BLACK + "   " + ANSI_RESET);
                }
            }
            println(String.format(ANSI_EMPTY, algorithmName));
        }
    }

    public static void printEnd(final int width, final String algorithmName) {
        for (int i = 0; i < width; i++) {
            print(ANSI_WHITE + "   " + ANSI_RESET);
        }
        println(String.format(ANSI_EMPTY, algorithmName));
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
                    print(ANSI_RED + "   " + ANSI_RESET);

                } else {
                    if (nodeContainsInArray(path, node)) {
                        print(ANSI_GREEN + "   " + ANSI_RESET);
                    } else {
                        if (node.getType() == Node.Type.WALL) {
                            print(ANSI_WHITE + "   " + ANSI_RESET);
                        } else {
                            print(ANSI_BLACK + "   " + ANSI_RESET);
                        }
                    }
                }
            }
            println(String.format(ANSI_EMPTY, algorithmName));
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

    private static void print(final String line) {
        System.out.print(line);
    }

    private static void println(final String line) {
        System.out.println(line);
    }
}
