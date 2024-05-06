package fisikes.leetcode;

/**
 *
 */
public class MergeSortArray {

  // 将最终数据合并到nums1中, nums1的长度为m+n
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    // |--------m-----i| |---n------| 数组nums1
    // |---n------j|   数组nums2

    int i = m - 1;
    int j = n - 1;
    int x = m + n - 1;

    while (i >= 0 && j >= 0) {
      nums1[x--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }

    while (i >= 0) {
      nums1[x--] = nums1[i--];
    }

    while (j >= 0) {
      nums1[x--] = nums2[j--];
    }

  }
}
