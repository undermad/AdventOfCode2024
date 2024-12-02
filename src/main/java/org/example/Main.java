package org.example;

import org.example.blocks.Day;
import org.example.da02.Day02;
import org.example.day01.Day01;

import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
//        Day day01 = new Day01(Path.of());
//        day01.solvePartOne();
//        day01.solvePartTwo();
    
        
        Day day02 = new Day02(Path.of(".\\src\\main\\resources\\day02.txt"));
        day02.solvePartOne();
        day02.solvePartTwo();
    }
}