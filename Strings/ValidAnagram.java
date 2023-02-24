//import java.util.Arrays;

public class ValidAnagram {
    /*
     * 
     * public static boolean isAnagram(String s, String t) {
        char s1[] = s.toCharArray();
        Arrays.sort(s1);

        char t1[] = t.toCharArray();
        Arrays.sort(t1);

        s1.toString();
        t1.toString();
        
        System.out.println(s1);
        System.out.println(t1);
        if(Arrays.equals(s1,t1))return true;
        else return false;
    }
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static void main(String[] args) {
         boolean ans = isAnagram("anagram","nagaram");
         System.out.println(ans);
         
    }
    
}
