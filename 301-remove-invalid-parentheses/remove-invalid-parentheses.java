class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        // Find minimum number of '(' and ')' that must be removed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        backtrack(s, 0, left, right, result);
        return result;
    }

    private void backtrack(String s, int index, int leftRemove, int rightRemove, List<String> result) {
        // No more parentheses need to be removed
        if (leftRemove == 0 && rightRemove == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // Avoid generating duplicate strings
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            char c = s.charAt(i);
            // Remove an extra '('
            if (c == '(' && leftRemove > 0) {
                String next = s.substring(0, i) + s.substring(i + 1);
                backtrack(next, i, leftRemove - 1, rightRemove, result);
            }
            // Remove an extra ')'
            if (c == ')' && rightRemove > 0) {
                String next = s.substring(0, i) + s.substring(i + 1);
                backtrack(next, i, leftRemove, rightRemove - 1, result);
            }
        }
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
}