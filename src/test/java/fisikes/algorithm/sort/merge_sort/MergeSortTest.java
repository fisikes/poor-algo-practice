package fisikes.algorithm.sort.merge_sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void mergeSort() {

    MergeSort.mergeSort(new int[]{5, 4, 3, 2, 1});
  }
}