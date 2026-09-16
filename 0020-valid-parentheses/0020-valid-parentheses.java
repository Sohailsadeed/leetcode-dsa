import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        char latest = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() && (ch == ']' || ch == '}' || ch == ')'))
                return false;
            if (!stack.isEmpty()) {
                if ((ch == '}' && latest != '{') || (ch == ')' && latest != '(') || (ch == ']' && latest != '['))
                    return false;
                if ((ch == '}' && latest == '{') || (ch == ')' && latest == '(') || (ch == ']' && latest == '[')) {
                    stack.pop();
                    if (!stack.isEmpty())
                        latest = stack.peek();
                    continue;
                }
            }
            stack.push(s.charAt(i));
            if (s.charAt(i) == '(')
                latest = '(';
            if (s.charAt(i) == '[')
                latest = '[';
            if (s.charAt(i) == '{')
                latest = '{';
        }
        return stack.isEmpty();
    }
}