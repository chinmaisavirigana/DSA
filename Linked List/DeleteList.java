import java.util.NoSuchElementException;

public class DeleteList {

    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;
    }

    public DeleteList() {
        head = null;
        size = 0;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }
        if (head.next == null) {
            head = null;
        } else {
            ListNode current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    
        // insert some nodes at the beginning of the list
        list.insertAtBeginning(10);
        list.insertAtBeginning(7);
        list.insertAtBeginning(5);
        list.insertAtBeginning(2);
    
        // print the list
        System.out.println("List after inserting at beginning:"); // 2 -> 5 -> 7 -> 10
        list.printList();
    
        // insert some nodes at the end of the list
        list.insertAtLast(15);
        list.insertAtLast(20);
    
        // print the list
        System.out.println("List after inserting at last:"); // 2 -> 5 -> 7 -> 10 -> 15 -> 20
        list.printList();
    
        // remove a node from the beginning of the list
        list.removeFirst();
    
        // print the list
        System.out.println("List after removing from beginning:"); // 5 -> 7 -> 10 -> 15 -> 20
        list.printList();
    
        // remove a node from the end of the list
        list.removeLast();
    
        // print the list
        System.out.println("List after removing from last:"); // 5 -> 7 -> 10 -> 15
        list.printList();
    
        // insert a node at index 2
        list.insertAtIndex(2, 12);
    
        // print the list
        System.out.println("List after inserting at index 2:"); // 5 -> 7 -> 12 -> 10 -> 15
        list.printList();
    
        // remove a node from index 3
        list.removeAtIndex(3);
    
        // print the list
        System.out.println("List after removing from index 3:"); // 5 -> 7 -> 12 -> 15
        list.printList();
    }
    
}
