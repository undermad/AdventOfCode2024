package org.example.day05;

import org.example.blocks.Day;
import org.example.blocks.FileParser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Day05 implements Day
{

    private Input05 input;

    public Day05(Path path)
    {
        FileParser fileParser = new Day05FileParser();
        this.input = (Input05) fileParser.parse(path);
    }

    @Override
    public void solvePartOne()
    {
        var validUpdates = new ArrayList<int[]>();

        input.updates().updates().forEach(ints ->
        {

            AtomicBoolean valid = new AtomicBoolean(true);

            for (int i = 0; i < ints.length - 1; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    var first = ints[i];
                    var second = ints[j];

                    input.rules().forEach(rule ->
                    {
                        if (!rule.canBeBefore(first, second)) {
                            valid.set(false);
                        }
                    });
                }
            }

            if (valid.get()) validUpdates.add(ints);
        });


        var sum = new AtomicInteger(0);
        validUpdates.forEach(update -> sum.addAndGet(update[update.length / 2]));

        System.out.println(sum.get());
    }

    @Override
    public void solvePartTwo()
    {

    }
}
