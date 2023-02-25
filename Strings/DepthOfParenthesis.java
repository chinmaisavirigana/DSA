public class DepthOfParenthesis {
        public static int maxDepth(String s) {
            int ans=0, res=0;
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch=='(')
                    res++;
                else if(ch==')')
                    res--;
                ans= Math.max(res,ans);
            }
            return ans;
        }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int ans = maxDepth(s);
        System.out.print(ans);
    }
}
