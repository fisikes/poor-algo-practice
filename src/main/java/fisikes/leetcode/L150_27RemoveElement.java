package fisikes.leetcode;


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 注意: 此题需要对原数组进行修改, 题目有误导, 不仅仅是返回新长度. 元素的顺序可以改变
 */
public class L150_27RemoveElement {

  public static int removeElement(int[] nums, int val) {

    // |---v---v--v---|
    //   |         | 指针a和b, ab指针相遇时完成所有操作
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      if (nums[j] == val) {
        j = j - 1;
        continue;
      }
      if (nums[i] == val) {
        // i和j位置对调
        swap(nums,i,j);
        j --;
        i ++;
      } else {
        i ++;
      }
    }

    return j + 1;
  }

  public static void swap(int[] arr, int index1, int index2) {

    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;

  }

}
