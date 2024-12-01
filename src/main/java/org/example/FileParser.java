package org.example;

import java.nio.file.Path;

public interface FileParser
{
    Input parse(Path path);
}
