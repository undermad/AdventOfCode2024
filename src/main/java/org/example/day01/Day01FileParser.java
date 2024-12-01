package org.example.day01;

import org.example.FileParser;
import org.example.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day01FileParser implements FileParser
{
    @Override
    public Input parse(Path path)
    {
        var input = Input01.createInput();
        
        try {
            var lines = Files.readAllLines(path);


            lines.forEach(line ->
                    {
                        var values = line.split(" {3}");
                        
                        var left = values[0];
                        var right = values[1];
                        
                        input.left().add(Integer.valueOf(left));
                        input.right().add(Integer.valueOf(right));
                    }
            );
            
            return input;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
