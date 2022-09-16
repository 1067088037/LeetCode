package completed.code17;

import java.util.*;

class Solution {

    private final HashMap<Character, Character[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")) return new ArrayList<>();
        init();
        List<StringBuilder> list = new LinkedList<>();
        list.add(new StringBuilder());

        for (char c : digits.toCharArray()) {
            var chars = map.get(c);
            int n = list.size();
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < chars.length; i++) {
                    StringBuilder builder = new StringBuilder(list.get(j));
                    builder.append(chars[i]);
                    list.add(builder);
                }
                list.get(j).append(chars[0]);
            }
        }

        List<String> ans = new LinkedList<>();
        for (StringBuilder builder : list) {
            ans.add(builder.toString());
        }

        return ans;
    }

    private void init() {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }
}