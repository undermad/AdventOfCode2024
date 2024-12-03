package org.example.day03;

import org.example.blocks.Day;
import org.example.blocks.FileParser;

import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Day03 implements Day
{

    private Input03 input;

    public Day03(Path path)
    {
        FileParser fileParser = new Day03FileParser();
        this.input = (Input03) fileParser.parse(path);
    }

    @Override
    public void solvePartOne()
    {

        long result = 0;
        String regex = "^mul\\(\\d{1,3},\\d{1,3}\\).*";

        for (int y = 0; y < input.lines().size(); y++) {
            var line = input.lines().get(y);
            var choppedLine = line.toCharArray();
            for (int i = 0; i < choppedLine.length; i++) {
                var length = 12;
                if (choppedLine.length - i < 12) {
                    length = choppedLine.length - i;
                }
                var matchingString = String.copyValueOf(choppedLine, i, length);


                if (matchingString.matches(regex)) {
                    var choppedMatch = matchingString.split(",");
                    var left = Long.valueOf(choppedMatch[0].split("\\(")[1]);
                    var right = Long.valueOf(choppedMatch[1].split("\\)")[0]);

                    result += mul(left, right);
                }
            }
        }

        System.out.println(result);
    }

    private long mul(long a, long b)
    {
        return a * b;
    }

    @Override
    public void solvePartTwo()
    {
        boolean enabled = true;
        long result = 0;
        String mulRegex = "^mul\\(\\d{1,3},\\d{1,3}\\).*";
        String dontRegex = "^don't\\(\\).*";
        String doRegex = "^do\\(\\).*";


        for (int y = 0; y < input.lines().size(); y++) {
            var line = input.lines().get(y);
            var choppedLine = line.toCharArray();
            for (int i = 0; i < choppedLine.length; i++) {
                var length = 12;
                if (choppedLine.length - i < 12) {
                    length = choppedLine.length - i;
                }
                var matchingString = String.copyValueOf(choppedLine, i, length);

                if (matchingString.matches(doRegex)) {
                    enabled = true;
                }
                
                if(matchingString.matches(dontRegex)) {
                    enabled = false;
                }

                if (matchingString.matches(mulRegex)) {
                    var choppedMatch = matchingString.split(",");
                    var left = Long.valueOf(choppedMatch[0].split("\\(")[1]);
                    var right = Long.valueOf(choppedMatch[1].split("\\)")[0]);

                    if (enabled) {
                        result += mul(left, right);
                    }
                }
            }
        }

        System.out.println(result);

    }
}
