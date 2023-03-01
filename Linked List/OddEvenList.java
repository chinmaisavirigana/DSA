/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // Base case: empty list or list with only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize pointers for odd and even lists
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        // Traverse the list and separate odd and even nodes
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        // Connect the odd and even lists
        odd.next = evenHead;
        
        return head;
    }
    
    public static void main(String[] args) {
        // Create a test case linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        // Print the original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);
        
        // Apply the oddEvenList function to the linked list
         OddEvenList list = new OddEvenList();
        ListNode result = list.oddEvenList(head);
        
        // Print the resulting linked list
        System.out.println("Odd even linked list:");
        printLinkedList(result);
    }
    
    // Helper function to print a linked list
    private static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
