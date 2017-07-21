import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static char[][] mapper = { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'} };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> combinations = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(digits, 0, cur, combinations);
        return combinations;
    }

    private void dfs(String digits, int position, StringBuilder cur, List<String> combinations) {
        if (position == digits.length()) {
            combinations.add(cur.toString());
            return;
        }
        int digit = digits.charAt(position) - '0';
        for (int i = 0; i < mapper[digit].length; ++i) {
            cur.append(mapper[digit][i]);
            dfs(digits,position + 1, cur, combinations);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
