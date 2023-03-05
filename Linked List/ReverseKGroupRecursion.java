class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseKGroupRecursion {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while (current != null && count != k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            current = reverseKGroup(current, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ReverseKGroupRecursion solution = new ReverseKGroupRecursion();
        ListNode reversed = solution.reverseKGroup(head, 2);
        
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
/*
 *  public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        while (length >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummy.next;
    }
 */

/*
 public int length(ListNode node){
        ListNode temp = node;
        int len = 0;
        
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    ListNode th = null, tt = null;
    public void addFirst(ListNode node){
        if(th == null){
            th = tt = node;
        }
        else{
            node.next = th;
            th = node;
        }
        //return th;
    } 

    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null) return head;

        int len = length(head);
        ListNode oh =null, ot = null;
        ListNode curr = head;
        while(len >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }

            th = tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }   
    
   */
