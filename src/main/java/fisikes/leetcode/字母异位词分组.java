package fisikes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
  示例 1:

  输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
  输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
  示例 2:

  输入: strs = [""]
  输出: [[""]]
  示例 3:

  输入: strs = ["a"]
  输出: [["a"]]
 */
public class 字母异位词分组 {


  public static List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();
    Arrays.stream(strs).map(String::toLowerCase).forEach(str -> {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      final String ordered = String.valueOf(chars);
      if (!map.containsKey(ordered)) {
        map.put(ordered, new ArrayList<>());
      }
      map.get(ordered).add(str);
    });

    return map.values().stream().toList();
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
  }


}
