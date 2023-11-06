package edu.maze.generator;

import edu.maze.model.Maze;

public interface MazeGenerator {
    Maze generateMaze(int height, int width);
}
