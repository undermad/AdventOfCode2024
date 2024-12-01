package org.example.day01;

import org.example.Day;
import org.example.FileParser;
import org.example.Input;
import org.w3c.dom.Node;

import javax.swing.*;
import java.nio.file.Path;
import java.util.*;

public class Day01 implements Day
{

    private final Input01 input;
    
    public Day01(Path input)
    {
        FileParser parser = new Day01FileParser();
        this.input = (Input01) parser.parse(input);
    }

    @Override
    public void solvePartOne()
    {
        var right = new ArrayList<>(input.right());
        var left = new ArrayList<>(input.left());


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

    @Override
    public void solvePartTwo()
    {
        var right = input.right();
        var left = input.left();
        
        var result = 0;
        
        for (int i = 0; i < left.size(); i++) {
            
            var current = left.get(i);
            
            int appear = 0;
            
            for(int j = 0; j < right.size(); j++) {
                var rightCurrent = right.get(j);
                
                if(current.equals(rightCurrent)) {
                    appear++;
                }
            }
            
            result += current * appear;
        }

        System.out.println(result);
        
    }


}
