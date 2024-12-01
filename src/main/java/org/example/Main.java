package org.example;

import org.example.day01.Day01;

import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        Day day01 = new Day01(Path.of(".\\src\\main\\resources\\day01.txt"));
        day01.solve();
    }
}