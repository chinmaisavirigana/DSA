public class SumBeautySubstrings {
    public static int beautySum(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int freq[] = new int[26];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                int maxF = 0, minF = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){                
                        maxF = Math.max(maxF, freq[k]);
                    if(freq[k] > 0){
                        minF = Math.min(minF, freq[k]);
                    }
                }
                sum += maxF - minF;
            }

        }
    return sum;
    }
    public static void main(String[] args) {
        String s = "aabcbaa";
        int sum = beautySum(s);
        System.out.println("Sum of beauty of all substrings of " + s + ": " + sum);
    }
    
}
