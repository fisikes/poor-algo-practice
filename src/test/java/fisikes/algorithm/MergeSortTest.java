package fisikes.algorithm;

import fisikes.algorithm.sort.merge_sort.MergeSort;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void mergeSort() {

    int[] arr = {9, 6, 10, 5, 20, 1};

    MergeSort.mergeSort(arr);
    
  }
}