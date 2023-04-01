import java.util.ArrayList;
import java.util.List;

/*
++ offer into stack
-- offer into stack
-+ offer into stack
+- compare

array with index as stack(top as top of stack, inclusive):
top  = -1    : empty
top >= 0     : not empty
array[++top] : offer new guy onto top of stack
top--        : pop
array[top]   : peek
*/
/*
class Solution {
    public int[] asteroidCollision(int[] a) {
        int top = -1;
        for (int x : a) {
            boolean stillAlive = true; // new guys is still alive
            while (stillAlive && x < 0 && top >= 0 && a[top] > 0) {
                stillAlive = a[top] + x < 0;
                if (a[top] + x <= 0) top--; // die young or die together
            }
            if (stillAlive) a[++top] = x; // if new guys is still alive, put it on top of stack
        }
        
        return Arrays.copyOf(a, top+1); // return whats in stack as array
    }
}
*/

class Solution {
    public int[] asteroidCollision(int[] a) {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<a.length; i++){
            list.add(a[i]);
            int j=list.size()-1;


            /*
            It will collide only when Last element is negative and 2nd last element is positive
            Note:- Vice-versa of above statement will not cause collision
            because if last element if positive then it will go towards right side and if 2nd last
            is negative then it will go towards left side and hence it'll not collide
            e.g:- 
            Case 1:- If last is +ve and 2nd last is +ve:-

             <---- 2nd last  last---->  Hence not collide

            Case 2:- If last is -ve and 2nd last is +ve:

            2nd last ---->   <----last  Hence it'll collide

            */

            // This is the condition for collision
            while(j>0 && (list.get(j)<0 && list.get(j-1)>=0)){
                int first = list.remove(list.size()-1);
                int second = list.remove(list.size()-1);
                //int third;
                if(Math.abs(first)==Math.abs(second)){
                    //If both have same value then both will destory
                    j=j-2;
                    continue;
                }else if(Math.abs(first)>Math.abs(second)){
                    //If first have greater value then 2nd will destory
                    j--;
                    list.add(first);
                }else{
                    //If 2nd have greater value then 1st will destory
                    j--;
                    list.add(second);
                }
            }
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
        
    }
}