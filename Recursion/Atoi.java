public class Atoi {
    public static int recursion(int i,int sign, String s,int num) {
        
        if(i>=s.length() || !Character.isDigit(s.charAt(i))  ){
               return sign*num;
        }
        
        int val=s.charAt(i)-'0';

        if(num>Integer.MAX_VALUE/10 || num==Integer.MAX_VALUE/10 && val>7  ){
            if(sign==-1)
              return (Integer.MIN_VALUE);
            else
              return Integer.MAX_VALUE;
        }
        
        num=(num*10)+val;

        return recursion(i+1,sign,s,num);
    }  

 
    public static int myAtoi(String s) {
        //return solve1(s);

        int len=s.length();
        int sign=1;
        int i=0;
        int num=0;
        if(len<1){return 0;}
        while(i<len && s.charAt(i)==' '){
           i++;
        }
        if(i<len && s.charAt(i)=='-' || i<len && s.charAt(i)=='+'){
          if(s.charAt(i)=='-')
             sign=-1;
          i++;
        }

        return recursion(i,sign,s,num);

    }
    public static void main(String[] args) {
        String str = "12345";
        
        System.out.println(myAtoi(str));
    }
}
