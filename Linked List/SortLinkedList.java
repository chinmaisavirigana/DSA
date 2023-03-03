class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortLinkedList {
    public static ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Divide the list into two halves using the slow-fast pointer technique
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Merge the sorted halves
        return merge(left, right);
    }
    
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        
        if (left != null) {
            curr.next = left;
        }
        
        if (right != null) {
            curr.next = right;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        // Create an example linked list
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        
        // Sort the linked list
        ListNode sortedHead = sortList(head);
        
        // Print the sorted linked list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
        System.out.println(); // Output: 1 2 3 4
    }
}

/*
 * /** Using arrays. sort() function
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode sortList(ListNode head) {
        
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        int a[]=new int[count];
        count=0;
        while(temp!=null){
            a[count++]=temp.val;
            temp=temp.next;
        }
        temp=head;
        Arrays.sort(a);
        int k=0;
        while(temp!=null){
            temp.val=a[k++];
            temp=temp.next;
        }
        return head;
        
    }
}
 */

 /* Using for loop
  *  public ListNode sortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode [] list = new ListNode[2];
    boolean done = (null == head);
    // Keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
    for (int step = 1; !done; step *= 2) {
      done = true;
      ListNode prev = dummy;
      ListNode remaining = prev.next;
      do {
        // Split off two sublists of size step
        for (int i = 0; i < 2; ++i) {
          list[i] = remaining;
          ListNode tail = null;
          for (int j = 0; j < step && null != remaining; ++j, remaining = remaining.next) {
            tail = remaining;
          }
          // Terminate our sublist
          if (null != tail) {
            tail.next = null;
          }
        }

        // We're done if these are the first two sublists in this pass and they
        // encompass the entire primary list
        done &= (null == remaining);

        // If we have two sublists, merge them into one
        if (null != list[1]) {
          while (null != list[0] || null != list[1]) {
            int idx = (null == list[1] || null != list[0] && list[0].val <= list[1].val) ? 0 : 1;
            prev.next = list[idx];
            list[idx] = list[idx].next;
            prev = prev.next;
          }

          // Terminate our new sublist
          prev.next = null;
        } else {
          // Only a single sublist, no need to merge, just attach to the end
          prev.next = list[0];
        }
      } while (null != remaining);
    }
    return dummy.next;
  }
  */

/*
class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
    ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode temp = dummy;
        while (list1!=null && list2!=null) {
            if (list1.val<list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if (list1==null) {
            temp.next = list2;
            return dummy.next;
        }
        temp.next = list1;
        return dummy.next;
    }
}

*/
