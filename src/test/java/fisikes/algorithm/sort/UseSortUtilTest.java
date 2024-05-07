package fisikes.algorithm.sort;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UseSortUtilTest {



  /**
   * 使用java的堆排
   */


  /**
   * array
   */
  @Test
  void arraySortTest() {
    int[] arr = {5, 2, 8, 1, 6};
    Arrays.sort(arr); // 对数组进行升序排序
    Assertions.assertArrayEquals(new int[]{1, 2, 5, 6, 8}, arr);


  }

}