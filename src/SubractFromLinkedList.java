import java.util.Queue;
import java.util.Stack;

/**
 * Created by rashmimech on 3/26/17.
 Given a singly linked list, modify the value of first half nodes such that :

 1st node’s new value = the last node’s value - first node’s current value
 2nd node’s new value = the second last node’s value - 2nd node’s current value,

 and so on …

 NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.

 Example :

 Given linked list 1 -> 2 -> 3 -> 4 -> 5,

 You should return 4 -> 2 -> 3 -> 4 -> 5
 as

 for first node, 5 - 1 = 4
 for second node, 4 - 2 = 2
 */

public class SubractFromLinkedList {
    public static void main(String[] args) {
        int size = 4;
        ListNode a = new ListNode(1);
        ListNode next = a;
        for(int i = 1; i < size; i++){
            ListNode temp = new ListNode(i + 1);
            next.next = temp;
            next = temp;
        }

        System.out.println(new SubractFromLinkedList().subtract(a));
    }

   /* public ListNode subtract(ListNode a) {
            if(a == null) return null;
            int size = 1;
            ListNode listNode = a;
            while(listNode.next != null){
                listNode = listNode.next;
                size++;
            }

            ListNode tempMid = a;
            int mid = size / 2;
            //Traverse to the mid value
            while(mid > 0){
                tempMid = tempMid.next;
                mid--;
            }

            ListNode curr = a;
            ListNode next = tempMid;
            mid = size / 2;

            //Reverting the first half of the linked list
           revertTheList(curr, next, mid);

            mid = size / 2;

            ListNode midNode = tempMid;
            ListNode firstNode = a;
            //Calculating the subract
            while(mid > 0){
                firstNode.val = midNode.val - firstNode.val;
                firstNode = firstNode.next;
                midNode = midNode.next;
                mid--;
            }

            mid = size / 2;
            //Rearranging the linked list;
            revertTheList(a, midNode, mid);

            return a;
    }


    public void revertTheList(ListNode firstNode, ListNode midNode, int midVal){
        ListNode curr = firstNode;
        ListNode next = midNode;
        while(midVal > 0){
            ListNode prev = curr.next;
            curr.next = next;
            next = curr;
            curr = prev;
            midVal--;
        }
    }

    */

    public ListNode subtract(ListNode a) {
        if(a == null || a.next == null) return a;
        Stack<ListNode> stack = new Stack<>();

        ListNode node = a;
        int size = 1;
        while(node.next != null){
            node = node.next;
            size++;
        }

        int mid = size / 2;
        node = a;
        while(mid > 0){
            stack.add(node);
            node = node.next;
            mid --;
        }
        if(size % 2 != 0) node = node.next;

        while(node != null){
            ListNode n = stack.pop();
            n.val = node.val - n.val;
            node = node.next;
        }

        return a;
    }

}
