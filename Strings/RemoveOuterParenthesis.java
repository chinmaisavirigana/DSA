class RemoveOuterParenthesis{
    static String removeOuterParentheses(String s){
StringBuilder sb = new StringBuilder();
        int opened = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(' && opened++ > 0) sb.append(ch);
// As soon as we find closing bracket, we are searching for "("
//Appending only immediate opening and closing
            if(ch == ')' && opened-- > 1) sb.append(ch);
        }
        return sb.toString();
    }
        public static void main(String[] args) {
        String s = "(()())(())";
    String result = removeOuterParentheses(s);
    System.out.println(result); // Outputs: ()()()
    
        }
}        
