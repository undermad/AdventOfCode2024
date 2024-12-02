package org.example.day01;

import org.example.blocks.Input;

import java.util.ArrayList;
import java.util.List;

public record Input01(List<Integer> left, List<Integer> right) implements Input
{
    
    public static Input01 createInput()
    {
        return new Input01(new ArrayList<>(), new ArrayList<>());
    }
}
