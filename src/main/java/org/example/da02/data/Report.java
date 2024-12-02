package org.example.da02.data;

import java.util.LinkedList;

public record Report(LinkedList<Integer> codes, Direction initialDirection)
{


    public static Report createReport(String line)
    {
        LinkedList<Integer> code = new LinkedList<>();
        var choppedLine = line.split(" ");

        for (int i = 0; i < choppedLine.length; i++) {
            code.add(Integer.valueOf(choppedLine[i]));
        }

        return new Report(code, checkDirection(code, 0, 1));
    }

    public boolean isValid()
    {
        boolean isOneDirection;
        boolean isValidRange;

        for (int i = 0; i < codes.size() - 1; i++) {
            var direction = checkDirection(codes, i, i + 1);
            if (direction.equals(Direction.FLAT)) {
                isOneDirection = false;
            } else {
                isOneDirection = direction.equals(initialDirection);
            }

            isValidRange = checkAdjacentLevels(i);
            
            if(!isOneDirection || !isValidRange) {
                return false;
            }
            
        }

        return true;
    }

    private boolean checkAdjacentLevels(int index)
    {

        var current = codes.get(index);
        var right = codes.get(index + 1);

        var direction = checkDirection(codes, index, index + 1);
        var difference = calculateDifference(current, right, direction);
        if (index == 0) {
            return difference <= 3 && difference >= 1;
        }

        var left = codes.get(index - 1);
        var direction2 = checkDirection(codes, index - 1, index);
        var difference2 = calculateDifference(left, current, direction2);

        return (difference <= 3 && difference >= 1) && (difference2 <= 3 && difference2 >= 1);
    }

    private int calculateDifference(int first, int second, Direction direction)
    {
        if (direction.equals(Direction.ASC)) {
            return second - first;
        } else if (direction.equals(Direction.DESC)) {
            return first - second;
        } else {
            return 0;
        }
    }


    private static Direction checkDirection(LinkedList<Integer> codes, int firstIndex, int secondIndex)
    {
        var first = codes.get(firstIndex);
        var second = codes.get(secondIndex);

        if (first > second) {
            return Direction.DESC;
        } else if (second > first) {
            return Direction.ASC;
        } else {
            return Direction.FLAT;
        }
    }


}
