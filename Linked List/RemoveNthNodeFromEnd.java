class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveNthNodeFromEnd {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Find the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Calculate the index of the node to be removed from the beginning
        int index = length - n;
        
        // Handle the case where the first node needs to be removed
        if (index == 0) {
            return head.next;
        }
        
        // Remove the node at the given index
        current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        
        return head;
    }
    
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        // Print the original linked list
        System.out.println("Original linked list:");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
        
        // Remove the 2nd node from the end of the linked list
        int n = 4;
        head = removeNthFromEnd(head, n);
        
        // Print the modified linked list
        System.out.println("Modified linked list (after removing the " + n + "nd node from the end):");
        current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
