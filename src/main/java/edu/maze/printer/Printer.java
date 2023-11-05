package edu.maze.printer;

import edu.maze.model.Maze;
import edu.maze.model.Node;

public class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[40m";
    private static final String ANSI_WHITE = "\u001B[47m";
    private static final String ANSI_GREEN = "\u001B[42m";

    public static void printMaze(Maze maze, String algorithmName) {
        Node[][] map = maze.getMap();
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Node node = map[row][col];

                if (row == 1 && col == 1) {
                    System.out.print(ANSI_GREEN + "   " + ANSI_RESET);
                } else if (node.getType() == Node.Type.WALL) {
                    System.out.print(ANSI_WHITE + "   " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_BLACK + "   " + ANSI_RESET);
                }
            }
            System.out.println(String.format(ANSI_WHITE + "  %s  " + ANSI_RESET, algorithmName));
        }
    }

    public static void printEnd(int width, String algorithmName) {
        for (int i = 0; i < width; i++) {
            System.out.print(ANSI_WHITE + "   " + ANSI_RESET);
        }
        System.out.println(String.format(ANSI_WHITE + "  %s  " + ANSI_RESET, algorithmName));
    }
}
