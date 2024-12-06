package org.example.day06;

import org.example.blocks.FileParser;
import org.example.blocks.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day06FileParser implements FileParser
{
    
    @Override
    public Input parse(Path path)
    {

        var parsedLines = new ArrayList<List<Character>>();
        
        try {
            var lines = Files.readAllLines(path);
            lines.forEach(line -> {
                char[] choppedLine = line.toCharArray();
                var charList = new ArrayList<Character>();
                for(char c : choppedLine) {
                    charList.add(c);
                }
                parsedLines.add(charList);
            });
            return new Input06(parsedLines);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
