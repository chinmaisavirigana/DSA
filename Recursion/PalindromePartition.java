import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    
       static List<List<String>> ans = new ArrayList<>();
        public static List<List<String>> partition(String s) {
            help(s, 0, new ArrayList<>());
            return ans;
        }
    
      static void help(String s, int idx, List<String> currParts) {
            if (idx == s.length()) {
                ans.add(new ArrayList<>(currParts));
                return;
            }
            for (int i = idx; i < s.length(); i++) {
                if (isPalindrome(s, idx, i)) {
                    currParts.add(s.substring(idx, i + 1));
                    help(s, i + 1, currParts);
                    currParts.remove(currParts.size() - 1);
                }
            }
        }
    
        private static boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
    
            return true;
        }
       
}
