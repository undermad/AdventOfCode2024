package org.example.day06;

import org.example.blocks.Input;

import java.util.ArrayList;
import java.util.List;

public record Input06(List<List<Character>> input) implements Input
{
    public Input06 clone() {
        // Deep copy the nested List<List<Character>>
        List<List<Character>> clonedInput = new ArrayList<>();
        for (List<Character> innerList : input) {
            // Create a new list for each inner list and copy its contents
            clonedInput.add(new ArrayList<>(innerList));
        }
        // Return a new Input06 instance with the cloned data
        return new Input06(clonedInput);
    }
}
