package edu.maze.model;

/**
 * Теперь задача приняла такой вид:
 * есть множество комнат, между некоторыми из них можно перемещаться.
 * Требуется найти путь из комнаты A в комнату B.
 * В теории графов «комнаты» называются вершинами (node)
 */
public class Node {
    private final int row;
    private final int column;
    public boolean isVisited;
    private Type type;

    public Node(int column, int row, Type type) {
        this.row = row;
        this.column = column;
        this.isVisited = false;
        this.type = type;
    }

    public enum Type {
        WALL,
        EMPTY
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
