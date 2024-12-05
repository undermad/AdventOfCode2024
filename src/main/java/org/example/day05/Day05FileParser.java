package org.example.day05;

import org.example.blocks.FileParser;
import org.example.blocks.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day05FileParser implements FileParser
{
    @Override
    public Input parse(Path path)
    {

        try {
            var lines = Files.readAllLines(path);

            String line;


            var rules = new ArrayList<Rule>();
            int j = 0;

            for (int i = 0; i < lines.size(); i++) {
                line = lines.get(i);
                if (line.isEmpty()) {
                    break;
                }
                j++;
                var choppedLine = line.split("\\|");
                var rule = new Rule(Integer.valueOf(choppedLine[0]), Integer.valueOf(choppedLine[1]));
                rules.add(rule);
            }

            var updateList = new ArrayList<int[]>();
            
            j++;
            for (; j < lines.size(); j++) {
                line = lines.get(j);
                var choppedLine = line.split(",");
                int[] pages = new int[choppedLine.length];
                for (int i = 0; i < choppedLine.length; i++) {
                    pages[i] = Integer.parseInt(choppedLine[i]);
                }
                
                updateList.add(pages);
            }
            
            var updates = new Updates(updateList);
            
            return new Input05(rules, updates);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
