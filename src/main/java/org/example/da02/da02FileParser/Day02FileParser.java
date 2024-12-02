package org.example.da02.da02FileParser;

import org.example.blocks.FileParser;
import org.example.blocks.Input;
import org.example.da02.data.Report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day02FileParser implements FileParser
{
    @Override
    public Input parse(Path path)
    {
        try {
            var lines = Files.readAllLines(path);
            var reports = lines.stream()
                    .map(Report::createReport)
                    .toList();
            return new Input02(reports);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
