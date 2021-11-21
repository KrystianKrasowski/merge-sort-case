package org.kkrasowski.algorithms.sort.merge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateLargeFile {

    public static void main(String[] args) throws IOException {
        File file = generateFileOfSizeInMB(512);
        System.out.println(file.length());
    }

    private static File generateFileOfSizeInMB(int mb) throws IOException {
        int counter = (mb * 1000000) / 8;
        File file = new File("input/example.csv");
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < counter; i++) {
            fileWriter.write(getRandomString());
        }
        fileWriter.close();
        return file;
    }

    private static String getRandomString() {
        String[] stringPool = {
            "1111111\n",
            "2222222\n",
            "3333333\n",
            "4444444\n",
            "5555555\n",
            "6666666\n",
            "7777777\n",
            "8888888\n"
        };

        Random random = new Random();
        int randomStringIndex = random.ints(0, stringPool.length - 1)
            .findFirst()
            .getAsInt();

        return stringPool[randomStringIndex];
    }
}
