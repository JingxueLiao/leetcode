import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> needed = new HashMap<>();
        for (String word : words) {
            needed.put(word, needed.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        for (int i = 0; i < s.length() && i < len; ++i) {
            Map<String, Integer> appeared = new HashMap<>();
            int begin = i, count = 0;
            for (int j = i; j <= s.length() - len; j += len) {
                String word = s.substring(j, j + len);
                if (needed.containsKey(word)) {
                    int times = appeared.getOrDefault(word, 0);
                    if (times == needed.get(word)) {
                        while (!s.substring(begin, begin + len).equals(word)) {
                            appeared.replace(s.substring(begin, begin + len), appeared.get(s.substring(begin, begin + len)) - 1);
                            begin += len;
                            --count;
                        }
                        begin += len;
                    } else {
                        appeared.put(word, times + 1);
                        ++count;
                    }
                    if (count == words.length) {
                        result.add(begin);
                    }
                } else {
                    appeared.clear();
                    begin = j + len;
                    count = 0;
                }
            }
        }
        return result;
    }
}
