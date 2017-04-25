

/**
  Created by rashmimech on 2/25/17.
 */
public class CheckListIsPalindromeOrNot {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{8, 6, 4, 6, 8, 9, 4, 6, 8};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        System.out.println(new CheckListIsPalindromeOrNot().lPalin(first));
    }


    public int lPalin(ListNode A) {
        if(A == null)
            return 0;

        int index = 1;
        ListNode slow = A;
        ListNode fast = A.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            index++;
        }

        slow = slow.next;

        slow = reverse(slow);

        while(slow != null){
            int val1 = slow.val;
            int val2 = A.val;

            if(val1 != val2)
                return 0;

            slow = slow.next;
            A = A.next;
        }

        return 1;

    }


    public ListNode reverse(ListNode n){
        ListNode curr = n;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}



class ListNode {
     public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
