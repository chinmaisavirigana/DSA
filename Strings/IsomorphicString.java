public class IsomorphicString {
    
public static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    int[] sIndex = new int[256]; // Array to store last index of character in string s
    int[] tIndex = new int[256]; // Array to store last index of character in string t

    for (int i = 0; i < s.length(); i++) {
        char sChar = s.charAt(i);
        char tChar = t.charAt(i);

        // If the last index of the character in both strings is not equal,
        // then the strings are not isomorphic
        if (sIndex[sChar] != tIndex[tChar]) {
            return false;
        }

        // Update the last index of the character in each string
        sIndex[sChar] = i + 1;
        tIndex[tChar] = i + 1;
    }

    return true;
}
public static void main(String[] args) {
    String s1 = "paper";
    String t1 = "title";
    System.out.println(isIsomorphic(s1, t1)); // true
    
    String s2 = "egg";
    String t2 = "add";
    System.out.println(isIsomorphic(s2, t2)); // true
    
    String s3 = "foo";
    String t3 = "bar";
    System.out.println(isIsomorphic(s3, t3)); // false
}

}