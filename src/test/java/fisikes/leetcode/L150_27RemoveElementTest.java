package fisikes.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L150_27RemoveElementTest {

  @Test
  void removeElement() {

    final int[] arr = {3, 2, 2, 3};

    L150_27RemoveElement.removeElement(arr, 2);
    Assertions.assertArrayEquals(new int[]{3, 3, 2, 2}, arr);
  }

  @Test
  void removeElement2() {

    final int[] arr = {1};

    L150_27RemoveElement.removeElement(arr, 1);
    Assertions.assertArrayEquals(new int[]{1}, arr);
  }
}