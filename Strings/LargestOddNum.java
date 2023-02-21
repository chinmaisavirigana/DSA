public class LargestOddNum {
    public static void main(String[] args) {
        String str = "583471";
        System.out.println("Largest odd number in the string is: " + largestOddNumber(str));
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
