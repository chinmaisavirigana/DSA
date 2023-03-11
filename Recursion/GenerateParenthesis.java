import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: we have used up all the available parentheses
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Try adding an opening parenthesis if we haven't used up all the available ones
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Try adding a closing parenthesis if we haven't used up all the available ones
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> parentheses = generateParenthesis(n);
        System.out.println("All possible combinations of valid parentheses with n = " + n + ":");
        System.out.println(parentheses);
    }
}
