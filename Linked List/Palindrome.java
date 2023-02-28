public class Palindrome {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        int length = 0;
        Node slow = head, fast = head;

        // find the middle point of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            length++;
        }

        Node secondHalf = slow;
        if (fast != null) {
            // if the length of the linked list is odd, skip the middle node
            secondHalf = slow.next;
        }

        // reverse the second half of the linked list
        secondHalf = reverse(secondHalf);

        // compare the first half with the reversed second half
        Node p1 = head, p2 = secondHalf;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // reverse the second half of the linked list again to restore the original list
        secondHalf = reverse(secondHalf);

        // connect the first half and the second half of the linked list
        slow.next = secondHalf;

        return isPalindrome;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean isPalindrome = isPalindrome(head);

        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
