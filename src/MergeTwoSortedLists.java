import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode headWalker = head;
        ListNode walker1 = l1;
        ListNode walker2 = l2;

        while (walker1 != null && walker2 != null) {
            if (walker1.val > walker2.val) {
                ListNode temp = new ListNode(walker2.val);
                headWalker.next = temp;
                walker2 = walker2.next;
            } else if (walker1.val < walker2.val) {
                ListNode temp = new ListNode(walker1.val);
                headWalker.next = temp;
                walker1 = walker1.next;
            } else {
                ListNode temp1 = new ListNode(walker1.val);
                ListNode temp2 = new ListNode(walker2.val);

                headWalker.next = temp1;
                headWalker = headWalker.next;
                headWalker.next = temp2;

                walker1 = walker1.next;
                walker2 = walker2.next;
            }
            headWalker = headWalker.next;
        }

        ListNode walker = (walker1 == null) ? walker2 : walker1;
        while (walker != null) {
            ListNode temp = new ListNode(walker.val);
            headWalker.next = temp;
            headWalker = headWalker.next;
            walker = walker.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list14 = new ListNode(4);

        ListNode list21 = new ListNode(1);
        ListNode list23 = new ListNode(3);
        ListNode list24 = new ListNode(4);

        list11.next = list12;
        list12.next = list14;

        list21.next = list23;
        list23.next = list24;

        ListNode temp = mergeTwoLists(list11, list21);
    }
}
