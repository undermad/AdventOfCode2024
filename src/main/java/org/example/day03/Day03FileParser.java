package org.example.day03;

import org.example.blocks.FileParser;
import org.example.blocks.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day03FileParser implements FileParser
{
    @Override
    public Input parse(Path path)
    {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Input03(lines);
    }
}
