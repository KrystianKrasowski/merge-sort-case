package org.kkrasowski.algorithms.sort.merge;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileChunker {

    private final File inputFile;
    private final int maximumLinesForChunk;
    private int counter = 0;
    private List<String> linesPortion = new LinkedList<>();

    public static FileChunker forFile(String path, int maxLines) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("File " + path + " does not exist");
        }

        return new FileChunker(file, maxLines);
    }

    public void chunkFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String lineToAppend = line + "\n";
                linesPortion.add(lineToAppend);

                if (linesPortion.size() == maximumLinesForChunk) {
                    try (FileWriter writer = new FileWriter(new File(createChunkFileName()))) {
                        for (String l : linesPortion) {
                            writer.append(l);
                        }
                    }
                    linesPortion = new LinkedList<>();
                }

                counter++;
            }
        }
    }

    private String createChunkFileName() {
        int chunkNo = (counter / maximumLinesForChunk) + 1;
        return "output/example-chunk-" + chunkNo + ".csv";
    }

    private FileChunker(File inputFile, int maximumLinesForChunk) {
        this.inputFile = inputFile;
        this.maximumLinesForChunk = maximumLinesForChunk;
    }
}
