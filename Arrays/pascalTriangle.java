import java.util.ArrayList;

import java.util.List;

public class pascalTriangle {
    public static List<List<Integer>> generate(int r) {
        List<List<Integer>> list1 = new ArrayList<>();
        ArrayList<Integer> last = new ArrayList<>();
        for (int i = 0 ; i < r ; i++){
            ArrayList<Integer> inside = new ArrayList<>();
            for(int j = 0 ; j<=i ; j++){
                if(j==0 || j==i){
                    inside.add(j,1);
                }
                else{
                    inside.add(j,last.get(j) + last.get(j-1));
                }
            }
            last = inside;
            list1.add(i,inside);
        }
        return list1;
    }
    public static void main(String[] args){
        int num = 5;
     
        System.out.println(generate(num));
    }
}
