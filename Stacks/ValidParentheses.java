import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // Create a stack to store opening parentheses
        Stack<Character> stack = new Stack<Character>();
        
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the current character is an opening parenthesis, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the current character is a closing parenthesis, pop the top element from the stack and check if it matches the current character
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty at the end of the iteration, all parentheses are valid
        return stack.isEmpty();
    }
    public static void main(String[] args) {
    String[] examples = {"()", "()[]{}", "(]", "([)]", "{[]}"};
    for (String s : examples) {
        System.out.println(s + " is " + (isValid(s) ? "valid" : "not valid"));
    }
}

}
