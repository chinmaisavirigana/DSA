import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequenctSory {
    /* O(Nlogk)
        public static String frequencySort(String s) {
            int[]freq=new int[128];
            for(char ch:s.toCharArray()){
                freq[ch]++;
            }
            char[]c=new char[s.length()];
            for(int i=0;i<s.length();){
                int max=0;
                int index=0;
                for(int j=0;j<128;j++){
                    if(freq[j]>max){
                        max=freq[j];
                        index=j;
                    }
                }
                while(freq[index]>0){
                    c[i++]=(char)index;
                    freq[index]--;
                }
            }
            return new String(c);
        }
    */
    
        public static String frequencySort(String s) {
            if(s == null || s.isEmpty()) return s;
    
            // Created Frequency Map
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            }
    
            List<Character>[] bucket = new List[s.length() + 1];
            for(char key : map.keySet()){
                int freq = map.get(key);
                if(bucket[freq] ==null) {
                bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }
    
            StringBuilder sb = new StringBuilder();
            for(int i = bucket.length - 1; i > 0; i--){
                if(bucket[i]!=null){
                    for(char ch : bucket[i]){
                        for(int j = 0; j < i; j++){
                            sb.append(ch);
                        }
                    }
                }
            }
            return sb.toString();
        }
    
    
    public static void main(String[] args) {
        String s = "tree";
        String sorted = frequencySort(s);
        System.out.println(sorted); // prints "eert"
    }
}

/*In the code snippet int[] freq = new int[128],

ASCII is a widely used character encoding standard that represents each character using a unique integer between 0 and 127. 
Since there are 128 possible ASCII characters(letters,digits,control chars such as \n which are non printable),

we are creating an integer array of size 128. 
The frequency of each character will be stored at the index corresponding to its ASCII value in this array.

For example, the ASCII value of the character 'a' is 97. 
Therefore, the frequency of 'a' will be stored in the freq array at index 97. 
Similarly, the frequency of 'b' will be stored at index 98, and so on.

By using this array, we can keep track of the frequency of each character in s in O(n) time complexity, where n is the length of the input string s.

 */


 /*
  *
Create a frequency map to store the frequency of each character in the input string.
Create an array of strings (or a list of strings) to store the characters that have the same frequency. 
The index of the array corresponds to the frequency of the characters.
Iterate through the frequency map and populate the array of strings.
Iterate through the array of strings from the highest index to the lowest index 
(i.e., from the highest frequency to the lowest frequency) and append each character to the output string 
the number of times equal to its frequency.
  */


/* Using HashMap and priority queue
 * public String frequencySort(String s) {
    if (s == null || s.isEmpty()) {
        return s;
    }
    
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    queue.addAll(map.keySet());
    
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
        char c = queue.poll();
        int count = map.get(c);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }
    
    return sb.toString();
}

 */

 /*
  * he time complexity of the last implementation to sort characters by frequency in Java using a Map and a PriorityQueue is O(N log k), 
  where N is the length of the input string and 
  k is the number of unique characters in the string. 
 because the PriorityQueue operations of insertion and removal take O(log k) time complexity each and are performed N times. 
  The map operations take O(1) time complexity on average, 
  but iterating over the map takes O(k) time complexity, which is less than N, so it doesn't affect the overall time complexity.
  */