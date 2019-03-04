import java.util.*;

public class Str {
    /**
     * 求字符串中无重复字符的最长子串
     */
    //滑动窗口：使用HashMap.我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口
    //如果s[j]在 [i, j)范围内有与 j′重复的字符,我们不需要逐渐增加i。 我们可以直接跳过[i，j′]范围内的所有元素，并将i变为j′+1

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            //如果存在重复字符，将窗口滑到重复字符的地方
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);

        }
        return ans;
    }




    public void maxTimeChar() {
        /**
         * 求字符串中出现次数最多的字符串以及出现次数
         */
        String str = "abcdefabdsf";

        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int k = 0; k < str.length(); k++) {
            String atr = "";
            for (int j = 0; j < str.length(); j++) {
                if (k < j) {
                    atr = str.substring(k, j + 1);
                    if (map.containsKey(atr)) {
                        int num = map.get(atr);
                        map.put(atr, num + 1);
                        list.add(num + 1);
                    } else {
                        map.put(atr, 1);
                        list.add(1);
                    }
                    System.out.println(atr);
                } else if (k > j) {
//                    System.out.println("");
                } else if (k == j) {
//                    System.out.println("");
                }
            }
        }

        Collections.sort(list);
        System.out.println(list);

        System.out.println("--------" + list.get(list.size() - 1));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(list.get(list.size() - 1))) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Str str = new Str();
        String ss = "abcabcbb";
        System.out.println(str.lengthOfLongestSubstring(ss));
    }
}
