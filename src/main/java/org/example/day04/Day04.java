package org.example.day04;

import org.example.blocks.Day;
import org.example.blocks.FileParser;

import java.nio.file.Path;

public class Day04 implements Day
{
    private Input04 input;

    public Day04(Path path)
    {
        FileParser fileParser = new Day04FileParser();
        this.input = (Input04) fileParser.parse(path);
    }

    @Override
    public void solvePartOne()
    {
        var totalCount = 0;
        totalCount += calculateHorizontal();
        totalCount += calculateVertical();
        totalCount += calculatePrimaryDiag();
        totalCount += calculateSecondaryDiag();

        System.out.println(totalCount);
    }

    @Override
    public void solvePartTwo()
    {
        int count = 0;

        for (int h = 1; h < input.input().length - 1; h++) {
            for (int w = 1; w < input.input()[0].length - 1; w++) {
                count += isXmas(h, w) ? 1 : 0;
            }
        }
        System.out.println(count);
    }

    public boolean isXmas(int h, int w)
    {
        if (input.input()[h][w] != 'A') return false;

        var i = input.input();


        var masOne = new char[3];
        var masTwo = new char[3];

        // x x x
        // x x x
        // x x x


        masOne[0] = i[h - 1][w - 1];
        masOne[1] = i[h][w];
        masOne[2] = i[h + 1][w + 1];

        masTwo[0] = i[h + 1][w - 1];
        masTwo[1] = i[h][w];
        masTwo[2] = i[h - 1][w + 1];

        var regex = "^MAS";

        var firstMatch = String.valueOf(masOne).matches(regex) || new StringBuilder(String.valueOf(masOne))
                .reverse().toString().matches(regex);
        var secondMatch = String.valueOf(masTwo).matches(regex) || new StringBuilder(String.valueOf(masTwo))
                .reverse().toString().matches(regex);


        return firstMatch && secondMatch;
    }


    private int calculateSecondaryDiag()
    {
        var count = 0;

        for (int i = 0; i < input.input().length; i++) {
            var line = input.getVerticalSecondaryDiag(i);
            count += calculateTwoDirectionXMAS(line);
        }

        for (int i = input.input().length - 2; i >= 0; i--) {
            var line = input.getHorizontalSecondaryDiag(i);
            count += calculateTwoDirectionXMAS(line);
        }

        return count;
    }

    private int calculatePrimaryDiag()
    {
        var count = 0;

        for (int i = 0; i < input.input().length; i++) {
            var line = input.getVerticalPrimaryDiag(i);
            count += calculateTwoDirectionXMAS(line);
        }

        for (int i = 1; i < input.input().length; i++) {
            var line = input.getHorizontalPrimaryDiag(i);
            count += calculateTwoDirectionXMAS(line);
        }

        return count;
    }

    private int calculateVertical()
    {
        var count = 0;

        for (int i = 0; i < input.input()[0].length; i++) {
            var line = input.getVerticalLine(i);
            count += calculateTwoDirectionXMAS(line);
        }

        return count;
    }


    private int calculateHorizontal()
    {
        var count = 0;
        for (int i = 0; i < input.input().length; i++) {
            var line = input.getHorizontalLine(i);
            count += calculateTwoDirectionXMAS(line);
        }

        return count;
    }

    private int calculateTwoDirectionXMAS(char[] line)
    {
        var count = 0;

        count += calculateOneDirectionXMAS(line);
        var reversedLine = new StringBuilder(String.valueOf(line)).reverse().toString();
        count += calculateOneDirectionXMAS(reversedLine.toCharArray());
        return count;
    }

    private int calculateOneDirectionXMAS(char[] line)
    {
        var regex = "^XMAS";
        var count = 0;

        for (int i = 0; i < line.length; i++) {
            var offset = Math.min(line.length - i, 4);

            if (String.copyValueOf(line, i, offset).matches(regex)) {
                count++;
            }
        }

        return count;
    }


}
