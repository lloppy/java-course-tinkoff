package edu.maze.model;

/**
 * Теперь задача приняла такой вид:
 * есть множество комнат, между некоторыми из них можно перемещаться.
 * Требуется найти путь из комнаты A в комнату B.
 * В теории графов «комнаты» называются вершинами (node)
 */
public final class Node {
    private final int row;
    private final int column;
    private boolean isVisited;
    private Type type;
    private Node parent;

    public Node(final int nodeColumn, final int nodeRow, final Type nodeType) {
        this.column = nodeColumn;
        this.row = nodeRow;
        this.isVisited = false;
        this.type = nodeType;
        this.parent = null;
    }

    public enum Type {
        WALL,
        EMPTY
    }

    public void setType(final Type anotherType) {
        type = anotherType;
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

    public boolean isVisited() {
        return isVisited;
    }

    public void setIsVisited() {
        this.isVisited = true;
    }

    public void setParent(final Node newParentNode) {
        parent = newParentNode;
    }

    public Node getParent() {
        return parent;
    }

}
