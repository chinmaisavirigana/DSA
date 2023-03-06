public class RotateList {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = getLength(head);
        k %= length;
        
        if (k == 0) {
            return head;
        }
        
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
    
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    /*
     * public ListNode rotateRight(ListNode head, int k) {
    // Handle edge cases
    if (head == null || head.next == null || k == 0) {
        return head;
    }
    
    // Find the length of the list and the tail node
    int len = 1;
    ListNode tail = head;
    while (tail.next != null) {
        tail = tail.next;
        len++;
    }
    
    // Calculate the actual number of places to rotate
    k %= len;
    if (k == 0) {
        return head;
    }
    
    // Find the new tail node and the new head node
    ListNode newTail = head;
    for (int i = 0; i < len - k - 1; i++) {
        newTail = newTail.next;
    }
    ListNode newHead = newTail.next;
    
    // Detach the tail node from the original list and attach it to the head node
    newTail.next = null;
    tail.next = head;
    
    return newHead;
}
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        
        System.out.print("Original List: ");
        printList(head);
        
        ListNode newHead = rotateRight(head, k);
        
        System.out.print("List after rotation by " + k + " places: ");
        printList(newHead);
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}
