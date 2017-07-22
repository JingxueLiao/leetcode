import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(result,cur ,n, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder cur, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(cur.toString());
            return;
        }
        if (left != 0) {
            cur.append('(');
            dfs(result, cur, left - 1, right + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right != 0) {
            cur.append(')');
            dfs(result, cur, left, right -1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
