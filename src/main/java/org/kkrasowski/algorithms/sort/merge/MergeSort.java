package org.kkrasowski.algorithms.sort.merge;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {

    public static void sort(String[] words) {
        if (words.length == 1) {
            return;
        }

        String[] left = getLeftHalfFrom(words);
        String[] right = getRightHalfFrom(words);

        sort(left);
        sort(right);

        merge(left, right, words);
    }

    private static String[] getLeftHalfFrom(String[] words) {
        int mid = getMiddleIndexOf(words);
        return Arrays.copyOfRange(words, 0, mid);
    }

    private static String[] getRightHalfFrom(String[] words) {
        int mid = getMiddleIndexOf(words);
        return Arrays.copyOfRange(words, mid, words.length);
    }

    private static void merge(String[] left, String[] right, String[] array) {
        LinkedList<String> leftList = listOf(left);
        LinkedList<String> rightList = listOf(right);

        for (int i = 0; i < array.length; i++) {
            array[i] = pollElement(leftList, rightList);
        }
    }

    private static int getMiddleIndexOf(String[] words) {
        return words.length - words.length / 2;
    }

    private static LinkedList<String> listOf(String[] words) {
        return new LinkedList<>(Arrays.asList(words));
    }

    private static String pollElement(LinkedList<String> left, LinkedList<String> right) {
        if (left.isEmpty()) {
            return right.pollFirst();
        }

        if (right.isEmpty()) {
            return left.pollFirst();
        }

        String firstLeft = left.getFirst();
        String firstRight = right.getFirst();

        if (firstLeft.compareTo(firstRight) <= 0) {
            return left.pollFirst();
        } else {
            return right.pollFirst();
        }
    }
}
