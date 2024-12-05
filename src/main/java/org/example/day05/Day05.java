package org.example.day05;

import org.example.blocks.Day;
import org.example.blocks.FileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Day05 implements Day
{

    private Input05 input;

    public Day05(Path path)
    {
        FileParser fileParser = new Day05FileParser();
        this.input = (Input05) fileParser.parse(path);
    }

    public static void main(String[] args) throws IOException
    {

    }

    @Override
    public void solvePartOne()
    {
        var validUpdates = extractTheList(true);
        var sum = new AtomicInteger(0);
        validUpdates.forEach(update -> sum.addAndGet(update[update.length / 2]));

        System.out.println(sum.get());
    }

    @Override
    public void solvePartTwo() throws IOException
    {

        HashMap<Integer, ArrayList<Integer>> rules = new HashMap<>();
        ArrayList<List<Integer>> updates = new ArrayList<>();

        try (BufferedReader bin = new BufferedReader(new FileReader(".\\src\\main\\resources\\day05.txt"))) {
            boolean separation = false;
            while (bin.ready()) {
                String line = bin.readLine();
                if (line.isEmpty()) {
                    separation = true;
                    continue;
                }

                if (!separation) {
                    String[] tokens = line.split("\\|");
                    if (!rules.containsKey(Integer.parseInt(tokens[0]))) {
                        rules.put(Integer.parseInt(tokens[0]), new ArrayList<Integer>());
                    }
                    rules.get(Integer.parseInt(tokens[0])).add(Integer.parseInt(tokens[1]));
                } else {
                    ArrayList<Integer> update = new ArrayList<Integer>();
                    String[] tokens = line.split(",");
                    for (String string : tokens) {
                        update.add(Integer.parseInt(string));
                    }
                    updates.add(update);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        boolean OK;
        int result = 0;
        for (List<Integer> list : updates) {
            OK = true;
            for (int i = 0; i < list.size(); i++) {
                if (rules.containsKey(list.get(i))) {
                    for (int j = 0; j < i; j++) {
                        if (rules.get(list.get(i)).contains(list.get(j))) {
                            OK = false;
                            list.add(j, list.get(i));
                            list.remove(i + 1);
                            i = 0;
                        }
                    }
                }
            }
            if (!OK) {
                result += list.get(list.size() / 2);
            }
        }
        System.out.println(result);
    }


    private List<int[]> extractTheList(boolean correct)
    {
        var validUpdates = new ArrayList<int[]>();
        input.updates().updates().forEach(ints ->
        {
            AtomicBoolean valid = new AtomicBoolean(true);
            for (int i = 0; i < ints.length - 1; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    var first = ints[i];
                    var second = ints[j];

                    input.rules().forEach(rule ->
                    {
                        if (!rule.canBeBefore(first, second)) {
                            valid.set(false);
                        }
                    });
                }
            }

            if (correct == valid.get()) {
                validUpdates.add(ints);
            }
        });

        return validUpdates;
    }
}
