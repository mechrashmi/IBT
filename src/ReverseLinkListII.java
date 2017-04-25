/**
 * Created by rashmimech on 2/26/17.
 *
 *

 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.

 Note 2:
 Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */


public class ReverseLinkListII {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4,5};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        ListNode res = new ReverseLinkListII().reverseBetween(first, 1, 5);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(a == null || a.next == null) return a;

        int diff = n - m;
        ListNode mNode = a;
        ListNode nNode = a;
        ListNode prev = null;

        while(diff > 0){
            nNode = nNode.next;
            diff--;
        }

        while(m - 1 > 0){
            prev = mNode;
            mNode = mNode.next;
            nNode = nNode.next;
            m--;
        }

        ListNode next = nNode.next;
        ListNode t = mNode.next;
        while(!mNode.equals(nNode)){
            ListNode tNext = t.next;
            mNode.next = next;
            t.next = mNode;
            mNode = t;
            t = tNext;
            next = mNode.next;
        }

        if(prev == null){
            a = nNode;
        }
        else {
            prev.next = nNode;
        }

        return a;

    }
}
