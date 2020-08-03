class SolutionListNode {
    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tempHead = head;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;

            int newNum = num1 + num2 + carry;
            carry = (newNum >= 10) ? 1 : 0;
            newNum %= 10;

            tempHead.next = new ListNode(newNum);

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            tempHead = tempHead.next;
        }

        if(carry == 1){
            ListNode newNode = new ListNode(1);
            tempHead.next = newNode;
        }

        return head.next;
    }
}

public class AddTwoNumbers {
    public static void print(SolutionListNode.ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static SolutionListNode.ListNode createNodes(String num) {
        SolutionListNode.ListNode root = new SolutionListNode.ListNode(0);
        SolutionListNode.ListNode tempRoot = root;
        for(int i=0;i<num.length();i++){
            tempRoot.val = Character.getNumericValue(num.charAt(i));
            if(i+1 == num.length()){
                tempRoot.next = null;
            }
            else{
                tempRoot.next = new SolutionListNode.ListNode(0);
            }
            tempRoot = tempRoot.next;
        }

        return root;
    }

    public static void test1() {
        SolutionListNode s = new SolutionListNode();
        String num1 = "243";
        String num2 = "564";

        SolutionListNode.ListNode num1Node = createNodes(num1);
        SolutionListNode.ListNode num2Node = createNodes(num2);


        SolutionListNode.ListNode Num807 = SolutionListNode.addTwoNumbers(num1Node, num2Node);
        print(Num807);
    }

    public static void main(String[] args) {
        test1();
    }
}
