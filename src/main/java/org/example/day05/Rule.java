package org.example.day05;

public record Rule(Integer before, Integer after)
{
    public boolean canBeBefore(int b, int a) {
        return b != after || a != before;
    }
    
}
