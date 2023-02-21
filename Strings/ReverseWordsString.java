public class ReverseWordsString {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                reversed.append(words[i]).append(" ");
            }
        }
        return reversed.toString().trim();
    }
    public static void main(String[] args) {
        String s = "Hello world, how are you?";
        String ans = reverseWords(s);
        System.out.println(ans);

    }
    
}
