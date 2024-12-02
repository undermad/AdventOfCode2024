package org.example.da02;

import org.example.blocks.Day;
import org.example.blocks.FileParser;
import org.example.da02.da02FileParser.Day02FileParser;
import org.example.da02.da02FileParser.Input02;
import org.example.da02.data.Report;

import java.nio.file.Path;

public class Day02 implements Day
{
    Input02 input;

    public Day02(Path inputPath)
    {
        FileParser parser = new Day02FileParser();
        this.input = (Input02) parser.parse(inputPath);
    }

    @Override
    public void solvePartOne()
    {
        var safeReports = input.reports()
                .stream()
                .filter(Report::isValid)
                .toList()
                .size();
        System.out.println(safeReports);
    }

    @Override
    public void solvePartTwo()
    {

    }
}
