package fisikes.util;

public class MyArrays {


  // 交换数组中指定位置的两个元素
  public static void swap(int[] arr, int index1, int index2) {

    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;

  }
}
