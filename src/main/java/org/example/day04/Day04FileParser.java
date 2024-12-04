package org.example.day04;

import org.example.blocks.FileParser;
import org.example.blocks.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day04FileParser implements FileParser
{
    @Override
    public Input parse(Path path)
    {
        try {
            var lines = Files.readAllLines(path);
            
            char[][] input = new char[lines.size()][lines.getFirst().length()];
            for(int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    input[i][j] = lines.get(i).charAt(j);
                }
            }
            
            return new Input04(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
