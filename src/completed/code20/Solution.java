package completed.code20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (isLeft(c)) stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (!fit(pop, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean fit(char left, char right) {
        return switch (left) {
            case '(' -> right == ')';
            case '[' -> right == ']';
            case '{' -> right == '}';
            default -> false;
        };
    }

    public boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}