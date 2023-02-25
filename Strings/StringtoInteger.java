class StringtoInteger{
public static int myAtoi(String s) {
    // Check if input string is null or empty
    if (s == null || s.length() == 0) {
        return 0;
    }

    int index = 0;
    int sign = 1;
    int result = 0;
    int n = s.length();

    // Skip leading whitespace
    while (index < n && s.charAt(index) == ' ') {
        index++;
    }

    // Check if input string is all whitespace
    if (index == n) {
        return 0;
    }

    // Check for sign character
    if (s.charAt(index) == '+' || s.charAt(index) == '-') {
        sign = s.charAt(index) == '+' ? 1 : -1;
        index++;
    }

    // Iterate through digits and convert to integer
    while (index < n && Character.isDigit(s.charAt(index))) {
        int digit = s.charAt(index) - '0';
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        result = result * 10 + digit;
        index++;
    }

    return sign * result;
}

// Example test case
public static void main(String[] args) {
    String s = "42";
    int result = myAtoi(s);
    System.out.println(result); // Output: 42
}
}