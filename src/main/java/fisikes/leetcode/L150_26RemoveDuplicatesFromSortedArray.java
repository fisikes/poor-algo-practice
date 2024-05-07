package fisikes.leetcode;

/**
 * Given an integer array nums sorted in non-decreasing order ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。 返回 k 。
 */
public class L150_26RemoveDuplicatesFromSortedArray {

  // 方法1: 使用hashmap记录每个元素的出现次数
  // 方法2: 是有序的, 重复的必然相邻.
  public int removeDuplicates(int[] nums) {

    int p = 0;
    int q = 1;

    while (q < nums.length) {
      if (nums[p] == nums[q]) {
        q++;
      } else {
        nums[p + 1] = nums[q];
        p ++;
        q ++;
      }
    }

    return p + 1;

  }

}
