package org.kkrasowski.algorithms.sort.merge;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void shouldSortWords() {
        String[] input = { "h", "b", "g", "d", "c", "e", "a", "d", "f" };
        String[] expected = { "a", "b", "c", "d", "d", "e", "f", "g", "h" };

        MergeSort.sort(input);
        System.out.println(Arrays.toString(input));
        assertArrayEquals(expected, input);
    }
}

/*

bdc eaf

bd c

b d
bd c


i = 0 => 0,1 <=> i*2, i*2 + 1
i = 1 => 2,3
i = 2 => 4,5
i = 3 => 6,7

1st iteration

i = 0
le = b
re = a
a[0] = re = a
a[1] = le = b

2nd iteration

i = 1
le = d
re = c
a[1] = c
a[2] = d
 */
