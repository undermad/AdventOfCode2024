package org.example.day06;

import org.example.blocks.Day;
import org.example.blocks.FileParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Day06 implements Day
{

    Input06 input;

    public Day06(Path path)
    {
        FileParser fileParser = new Day06FileParser();
        this.input = (Input06) fileParser.parse(path);
    }

    @Override
    public void solvePartOne()
    {
        var startingPosition = Coordinates.getStartingPosition(input.input());

        var board = input.clone().input();
        var guard = new Guard(startingPosition);

        var startingTime = System.currentTimeMillis();
        while (guard.currentPosition.isInBoundaries(board)) {
            guard.move(board);
        }
        var timeToCompute = System.currentTimeMillis() - startingTime;

        System.out.println(timeToCompute);

        var count = 0;

        for (int i = 0; i < board.getFirst().size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j).equals('X')) count++;
            }
        }
        System.out.println(count);

    }

    @Override
    public void solvePartTwo() throws IOException
    {


        var count = 0;

        for (int i = 0; i < input.input().getFirst().size(); i++) {
            for (int j = 0; j < input.input().get(i).size(); j++) {

                var board = input.clone().input();
                var startingPosition = Coordinates.getStartingPosition(board);
                var guard = new Guard(startingPosition);
                if (board.get(i).get(j).equals('^') || board.get(i).get(j).equals('#')) {
                    continue;
                }

                board.get(i).set(j, 'O');

                var startingTime = System.currentTimeMillis();

                while (guard.currentPosition.isInBoundaries(board)) {
                    guard.move(board);
                    var timeToCompute = System.currentTimeMillis() - startingTime;
                    if (timeToCompute > 10) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);


    }


    ;
}
