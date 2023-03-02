public class DeleteMiddle {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, there is no middle node to delete
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            // Slow pointer moves one step at a time, while fast pointer moves two steps at a time
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // When the fast pointer reaches the end of the list, the slow pointer is at the middle node
        prev.next = slow.next;

        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list with 5 nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("Original list:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("List after deleting middle node:");
        printList(head);
    }
}
