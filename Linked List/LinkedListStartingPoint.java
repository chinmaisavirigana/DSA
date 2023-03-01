public class LinkedListStartingPoint {
    
    static class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
            next = null;
        }
    }
    
    // This function finds the starting point of the loop in the linked list
    static Node findStartingPoint(Node head) {
        Node slow = head, fast = head;
        boolean loopExists = false;
        
        // Check if loop exists in the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        
        // If loop does not exist, return null
        if (!loopExists) {
            return null;
        }
        
        // Move slow to head and increment both slow and fast pointers by one until they meet at the starting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Return the starting point
        return slow;
    }
    
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = head.next; // Creating a loop at node with value 4
        
        Node startingPoint = findStartingPoint(head);
        
        // Print the starting point of the loop in the linked list
        if (startingPoint == null) {
            System.out.println("No loop exists in the linked list.");
        } else {
            System.out.println("Starting point of the loop in the linked list is " + startingPoint.value);
        }
    }
}
