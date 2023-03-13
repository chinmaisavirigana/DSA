import java.util.ArrayList;
import java.util.List;

public class KeyPadSequence {
    /*
    static String arr[] = {"", "abc","def",
    "ghi","jkl","mno",
    "pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,digits,0);     
        return res;
    }
    private static void backtrack(List<String> res,StringBuilder sb, String digits, int index){
        //Base case
        if(digits.length() == sb.length()){
            res.add(sb.toString());
            return;
        }

        int val = digits.charAt(index) - '0';
        for(int i = 0; i < arr[val - 1].length(); i++){
            sb.append(arr[val - 1].charAt(i));
            backtrack(res, sb, digits, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    */
    
    
static String codes[] = {"","abc","def", "ghi","jkl","mno", "pqrs","tuv","wxyz"};

public static List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
        return res;
    }
    helper(res, digits, "", 0);
    return res;
}

private static void helper(List<String> res, String digits, String current, int index) {
    if (index == digits.length()) {
        res.add(current);
        return;
    }
    String letters = codes[digits.charAt(index) - '0'- 1];
    for (int i = 0; i < letters.length(); i++) {
        helper(res, digits, current + letters.charAt(i), index + 1);
    }
}

    /*
    static String codes[] = {"","abc","def", "ghi","jkl","mno", "pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> mres = new ArrayList<>();
        if(digits.length() == 0){
            return mres; // return an empty list when digits is empty
        }
        char ch = digits.charAt(0);
        String ros = digits.substring(1); 
        List<String> rres = letterCombinations(ros);
        
        if (rres.isEmpty()) { // base case: when there are no remaining digits, return the letters corresponding to the current digit
            String codeforch = codes[ch - '0'];
            for(int i = 0; i < codeforch.length(); i++){
                char chcode = codeforch.charAt(i);
                mres.add(Character.toString(chcode));
            }
        } else { // recursive case: generate combinations of the current digit with the combinations of remaining digits
            String codeforch = codes[ch - '0' - 1];
            for(int i = 0; i < codeforch.length(); i++){
                char chcode = codeforch.charAt(i);
                for(String rstr: rres){
                    mres.add(chcode + rstr);
                }
            }
        }
        return mres;
    }
    
    */
    public static void main(String[] args) {
        String digits = "";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations of phone number " + digits + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

}

/*
 * import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    
    // Create an array to store the mapping of digits to their corresponding letters
    static String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    // Function to generate all possible letter combinations of a phone number
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        generateCombinations(digits, "", result);
        return result;
    }
    
    // Helper function to generate letter combinations recursively
    public static void generateCombinations(String digits, String current, List<String> result) {
        // Base case: if we have processed all digits, add the current combination to the result list
        if (digits.length() == 0) {
            result.add(current);
            return;
        }
        // Recursive case: append each possible letter for the current digit to the current combination and recursively call the function with the remaining digits
        int digit = digits.charAt(0) - '0';
        for (int i = 0; i < mapping[digit].length(); i++) {
            char letter = mapping[digit].charAt(i);
            generateCombinations(digits.substring(1), current + letter, result);
        }
    }
    
    // Main function to test the program
    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations of phone number " + digits + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}

// Time complexity: O(3^N x 4^M), where N is the number of digits that map to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits that map to 4 letters (e.g. 7, 9). This is because each digit can map to up to 4 letters and we have to generate all possible combinations of these letters.

// Space complexity: O(3^N x 4^M), since we have to store all possible letter combinations in the result list and the call stack for the recursive function can have up to 3^N x 4^M frames.

 */