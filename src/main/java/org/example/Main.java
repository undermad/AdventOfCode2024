package org.example;

import org.example.blocks.Day;
import org.example.da02.Day02;
import org.example.day01.Day01;
import org.example.day03.Day03;
import org.example.day04.Day04;
import org.example.day05.Day05;
import org.example.day06.Day06;

import java.io.IOException;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args) throws IOException
    {
//        Day day01 = new Day01(Path.of(".\\src\\main\\resources\\day01.txt"));
//        day01.solvePartOne();
//        day01.solvePartTwo();
//    
//        
//        Day day02 = new Day02(Path.of(".\\src\\main\\resources\\day02.txt"));
//        day02.solvePartOne();
//        day02.solvePartTwo();
//
//        Day day03 = new Day03(Path.of(".\\src\\main\\resources\\day03.txt"));
//        day03.solvePartOne();
//        day03.solvePartTwo();
//        
//        Day day04 = new Day04(Path.of(".\\src\\main\\resources\\day04.txt"));
//        day04.solvePartOne();
//        day04.solvePartTwo();
//
//        Day day05 = new Day05(Path.of(".\\src\\main\\resources\\day05.txt"));
//        day05.solvePartOne();
//        day05.solvePartTwo();

        Day day06 = new Day06(Path.of(".\\src\\main\\resources\\day06.txt"));
        day06.solvePartOne();
        day06.solvePartTwo();
    
    }
}