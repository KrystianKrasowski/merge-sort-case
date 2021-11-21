package org.kkrasowski.algorithms.sort.merge;

import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException {
        FileChunker fileChunker = FileChunker.forFile("input/example.csv", 8000000);
        fileChunker.chunkFile();
    }
}
