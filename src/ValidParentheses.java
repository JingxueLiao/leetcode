import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> unmatch = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                unmatch.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (unmatch.empty()) {
                    return false;
                }
                switch (c) {
                    case ')' : if (unmatch.pop() != '(') return false; break;
                    case ']' : if (unmatch.pop() != '[') return false; break;
                    case '}' : if (unmatch.pop() != '{') return false; break;
                }
            }
        }
        return unmatch.empty();
    }
}
