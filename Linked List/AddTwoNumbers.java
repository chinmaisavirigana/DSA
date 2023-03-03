public class AddTwoNumbers {
    
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize the result list with a dummy node
        ListNode result = new ListNode(0);
        ListNode curr = result;
        
        int carry = 0;
        
        // Traverse both input lists until we reach the end of both
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Add the values of the current nodes, along with any carry from the previous sum
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            
            // Move the current node pointer to the next node
            curr = curr.next;
            
            // Move the pointers for both input lists to the next node, if they exist
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        // If there is a final carry after adding the last digits, add a new node to the result list for it
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        // Return the next node after the dummy node in the result list, which is the start of the actual result
        return result.next;
    }
    
    public static void main(String[] args) {
        // Create the input lists for testing
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        // Call the addTwoNumbers function and print the result
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}

/*
 * Initialize a dummy node dummy and a current node current, both pointing to the dummy node. 
 * The dummy node is used as a starting point to build the result linked list.
 * Initialize carry variable to 0. This variable keeps track of the carry over from the previous addition of two digits.
 * Traverse the input linked lists simultaneously, until either one of them reaches its end. At each iteration:
    * a. Get the values of the current nodes of both input linked lists, or 0 if one of the input linked lists has ended.
    * b. Compute the sum of the two values and the carry from the previous addition, and store it in a new node newNode.
      c. Update the carry variable to be 1 if the sum is greater than or equal to 10, and 0 otherwise.
      d. Append the newNode to the result linked list and move the current pointer to the next node.
* After one of the input linked lists has ended, continue traversing the other input linked list until its end. At each iteration:
    a. Compute the sum of the current value and the carry from the previous addition, and store it in a new node newNode.
    b. Update the carry variable to be 1 if the sum is greater than or equal to 10, and 0 otherwise.
    c. Append the newNode to the result linked list and move the current pointer to the next node.
    If there is a carry after all the digits have been added, append a new node with the value of carry to the result linked list.
    Return the result linked list, which starts at dummy.next.
 */