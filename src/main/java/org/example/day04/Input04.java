package org.example.day04;

import org.example.blocks.Input;


public record Input04(char[][] input) implements Input
{

    public char[] getHorizontalLine(int index)
    {
        var line = new char[input[index].length];

        for (int i = 0; i < input[index].length; i++) {
            line[i] = input[index][i];
        }
        
        return line;
    }

    public char[] getVerticalLine(int index)
    {
        var line = new char[input.length];

        for (int i = 0; i < input.length; i++) {
            line[i] = input[i][index];
        }
        return line;
    }
    
    public char[] getVerticalPrimaryDiag(int index) {
        char[] line = new char[200];
        
        // 1 1 1
        // 1 1 1
        // 1 1 1
        
        int j = 0;
        int h = 0;
        for(int i = index; i < input.length; i++) {
            line[h] = input[i][j];
            j++;
            h++;
        }
        
        return line;
    }
    
    public char[] getHorizontalPrimaryDiag(int index) {
        char[] line = new char[200];

        // 1 1 1
        // 1 1 1
        // 1 1 1
        
        int j = 0;
        int h = 0;
        for(int i = index; i < input[0].length; i++) {
            line[j] = input[h][i];
            j++;
            h++;
        }
        return line;
    }
    
    public char[] getVerticalSecondaryDiag(int index) {
        char[] line = new char[200];
        
        // 1 1 1
        // 1 1 1
        // 1 1 1
        
        int j = 0;
        int w = input[0].length - 1;
        for(int h = index; h < input.length; h++) {
            line[j] = input[h][w];
            j++;
            w--;
        }
        
        return line;
    }
    
    
    public char[] getHorizontalSecondaryDiag(int index) {
        char[] line = new char[200];
        
        // 1 1 1
        // 1 1 1
        // 1 1 1
        
        int j = 0;
        int w = index;
        for (int h = 0; w >= 0; h++) {
            line[j] = input[h][w];
            w--;
            j++;
        }
        
        return line;
    }


}
