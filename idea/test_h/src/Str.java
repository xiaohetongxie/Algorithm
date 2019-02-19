import java.util.*;

public class Str {
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
        str.maxTimeChar();
    }
}
