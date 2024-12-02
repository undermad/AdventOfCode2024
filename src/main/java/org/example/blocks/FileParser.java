package org.example.blocks;

import java.nio.file.Path;

public interface FileParser
{
    Input parse(Path path);
}
