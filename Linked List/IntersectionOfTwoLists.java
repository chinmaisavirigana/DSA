class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;

        // Traverse both linked lists until they meet
        while (pA != pB) {
            // If pA reaches the end of list A, point it to the head of list B
            pA = (pA == null) ? headB : pA.next;
            // If pB reaches the end of list B, point it to the head of list A
            pB = (pB == null) ? headA : pB.next;
        }

        // Return the intersection node
        return pA;
    }

    public static void main(String[] args) {
        // Create two linked lists
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        // Find the intersection node
        IntersectionOfTwoLists solution = new IntersectionOfTwoLists();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        // Print the intersection node's value
        if (intersectionNode == null) {
            System.out.println("The two lists do not intersect.");
        } else {
            System.out.println("The intersection node's value is: " + intersectionNode.val);
        }
    }
}

/*
 * Linked List A: 4 -> 1 -> 8 -> 4 -> 5

Linked List B: 5 -> 0 -> 1

To find the intersection of these two linked lists, we can use a two-pointer approach. We can first find the lengths of both lists and then move the pointers of the longer list by the difference in length between the two lists. This will ensure that both pointers start at the same distance from the end of their respective lists. Then, we can traverse both lists together until we find a common node or reach the end of the lists.

In this test case, we can first find the lengths of both lists:

Length of List A = 5

Length of List B = 3

The difference in length between the two lists is 2. So, we can move the pointer of List A by 2 places:

Linked List A: 8 -> 4 -> 5

Linked List B: 5 -> 0 -> 1

Now, we can traverse both lists together until we find a common node or reach the end of the lists. In this case, we can see that both lists intersect at node with value 8. So, the output of our program should be 8.

 */