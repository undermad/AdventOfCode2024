package org.example.day06;

public enum Direction
{
    UP,
    RIGHT,
    DOWN,
    LEFT,
    NONE;

    public Direction rotateRight(char c)
    {
        return switch (c) {
            case '^' -> Direction.RIGHT;
            case '>' -> Direction.DOWN;
            case 'v' -> Direction.LEFT;
            case '<' -> Direction.UP;
            default -> Direction.NONE;
        };
    }
}
