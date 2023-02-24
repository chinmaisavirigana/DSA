class StringRotation {
    //Best and optimised approach

  public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        String s1s1 = s1 + s1;
        int n = s2.length();
        int j = 0;
        
        for (int i = 0; i < s1s1.length(); i++) {
            if (j == n) {
                return true;
            }
            
            if (s1s1.charAt(i) == s2.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
        }
        
        return false;
    }  
  
    public static void main(String[] args) {
        boolean ans = isRotation("hello","elloh");
        System.out.println(ans);
    }



}

/* --> Contains() function
class Solution {
    public boolean rotateString(String s, String goal) {
     return (s.length() == goal.length() && (s+s).contains(goal));   
    }
}
*/

/* --> Time - O(n^2) - because of using substring function
public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        
        char c = goal.charAt(0);
        int it = s.indexOf(c);
        boolean check = false;

        while(it!=-1){
            String sub1 = s.substring(0,it);
            String sub2 = s.substring(it);
            String result = sub2+sub1;
            if(goal.equals(result)) return true;
            it = s.indexOf(c,it+1);
        }
    return check;
    }
*/
