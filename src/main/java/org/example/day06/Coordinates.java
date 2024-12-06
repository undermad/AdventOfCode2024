package org.example.day06;

import java.util.List;

public record Coordinates(int x, int y)
{
    public static Coordinates getStartingPosition(List<List<Character>> input)
    {
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                if (input.get(i).get(j).equals('^')) {
                    return new Coordinates(j, i);
                }
            }
        }
        return new Coordinates(0, 0);
    }

    public boolean isInBoundaries(List<List<Character>> board)
    {
        if (y >= board.size() || y < 0) return false;
        if (x >= board.getFirst().size() || x < 0) return false;
        return true;
    }


    public boolean isObstruction(List<List<Character>> board)
    {
        if (!isInBoundaries(board)) return false;
        var current = board.get(y).get(x);
        if (current.equals('O')) return true;
        return !current.equals('X') && !current.equals('.');
    }
}
