import java.util.List;

/**
 * Created by rashmimech on 2/26/17.
 *

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:

 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 */


public class RotateList {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4,5};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        ListNode res = new RotateList().rotateRight(first, 11);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode rotateRight(ListNode a, int b) {
        if(b == 0 || (b == 1 && a.next == null) || a ==null) return a;

        ListNode slow = a;
        ListNode fast = a;
        ListNode findSize = a;
        int size = 0;

        while(findSize != null){
            findSize = findSize.next;
            size++;
        }

        b = b % size;

        if(b == 0) return a;

        while(b > 0){
            fast = fast.next;
            b--;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newFirst = slow.next;

        fast.next = a;
        slow.next = null;

        return newFirst;

    }
}
