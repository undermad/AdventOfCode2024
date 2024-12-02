package org.example.da02.da02FileParser;

import org.example.blocks.Input;
import org.example.da02.data.Report;

import java.util.List;

public record Input02(List<Report> reports) implements Input
{
}
