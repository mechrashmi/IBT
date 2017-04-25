/**
 * Created by rashmimech on 2/26/17.
 *
 *

 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

 For example, given following linked lists :

 5 -> 8 -> 20
 4 -> 11 -> 15

 The merged list should be :

 4 -> 5 -> 8 -> 11 -> 15 -> 20


 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        //Integer[] input = new Integer[]{1,2,3,3,4,4,5};
        Integer[] input = new Integer[]{4, 5, };
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        //Integer[] input1 = new Integer[]{1,2,3,3,4,4,5};
        Integer[] input1 = new Integer[]{4, 5, 6};
        ListNode B = new ListNode(input1[0]);
        ListNode second = B;
        for(int i = 1; i < input1.length; i++){
            ListNode n = new ListNode(input1[i]);
            B.next = n;
            B = n;
        }

        ListNode res = new MergeTwoSortedLists().mergeTwoLists(first, second);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode nextNode = null;
        ListNode result = null;
        while(a != null && b != null){
            int val = -1;
            int val2 = -1;
            if(a.val < b.val){
                val = a.val;
                a = a.next;
            }
            else if(a.val > b.val){
                val = b.val;
                b = b.next;
            }
            else{
                val = a.val;
                val2 = b.val;
                a = a.next;
                b = b.next;
            }

            if(nextNode == null){
                nextNode = new ListNode(val);
                result = nextNode;
            }
            else{
                nextNode.next = new ListNode(val);
                nextNode = nextNode.next;
            }

            //nextNode = nextNode.next;
            if(val2 != -1){
                nextNode.next = new ListNode(val2);
                nextNode = nextNode.next;
            }
        }


        while(a != null){
            int val = a.val;
            if(nextNode == null){
                nextNode = new ListNode(val);
                result = nextNode;
            }
            else{
                nextNode.next = new ListNode(val);
                nextNode = nextNode.next;
            }

            a = a.next;
        }

        while(b != null){
            int val = b.val;
            if(nextNode == null){
                nextNode = new ListNode(val);
                result = nextNode;
            }
            else{
                nextNode.next = new ListNode(val);
                nextNode = nextNode.next;
            }

            b = b.next;
        }

        return result;

    }
}
