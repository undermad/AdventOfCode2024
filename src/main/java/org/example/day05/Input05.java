package org.example.day05;

import org.example.blocks.Input;

import java.util.List;

public record Input05(List<Rule> rules, Updates updates) implements Input
{
}
