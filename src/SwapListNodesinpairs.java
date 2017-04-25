/**
 * Created by rashmimech on 2/27/17.

 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */


public class SwapListNodesinpairs {
    public static void main(String[] args) {
        //Integer[] input = new Integer[]{1,2, 3, 4, 5, 6};
        Integer[] input = new Integer[]{1,2};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        ListNode res = new SwapListNodesinpairs().swapPairs(first);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode a) {
        if(a == null || a.next == null) return a;

        ListNode i = a;
        ListNode j = a.next;
        ListNode next = j.next;
        ListNode ret = a.next;
        ListNode prev = null;

        while(next != null){
            i.next = next;
            j.next = i;

            if(prev == null){
                prev = j;
            }
            else
            {
                prev.next = j;
            }

            if(next.next == null) {
                i = next;
                j = null;
                break;
            }
            prev = i;
            i = next;
            j = next.next;
            next = j.next;
        }

        if(j != null){
            i.next = next;
            j.next = i;

            if(prev == null){
                prev = j;
            }
            else
            {
                prev.next = j;
            }
        }

        return ret;

    }
}

