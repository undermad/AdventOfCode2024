package org.example.day01;

import org.example.Day;
import org.example.FileParser;
import org.example.Input;

import javax.swing.*;
import java.nio.file.Path;
import java.util.*;

public class Day01 implements Day
{
    
    private FileParser parser;
    private Input01 input;
    
    public Day01(Path input)
    {
        this.parser = new Day01FileParser();
        this.input = (Input01) parser.parse(input);
    }

    @Override
    public void solve()
    {
        var right = input.right();
        var left = input.left();


        Collections.sort(left);
        Collections.sort(right);
        
        List<Integer> distances = new ArrayList<>();
        
        for (int i = 0; i < left.size(); i++) {
            var leftNode = left.get(i);
            var rightNode = right.get(i);
            if (leftNode >= rightNode) {
                distances.add(leftNode - rightNode); 
            } else {
                distances.add(rightNode - leftNode);
            }
        }
        
        var result = distances.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }
    
    
    
}
