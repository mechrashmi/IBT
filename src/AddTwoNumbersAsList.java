/**
 * Created by rashmimech on 2/25/17.
 */
public class AddTwoNumbersAsList {
    public static void main(String[] args) {
        Integer[] int1 = new Integer[]{1};
        Integer[] int2 = new Integer[]{9, 9, 9};
        ListNode listNode1 = new ListNode(int1[0]);
        ListNode fListNode1 = listNode1;
        ListNode listNode2 = new ListNode(int2[0]);
        ListNode fListNode2 = listNode2;

        for(int i = 1; i < int1.length; i++){
            listNode1.next = new ListNode(int1[i]);
            listNode1 = listNode1.next;
        }


        for(int i = 1; i < int2.length; i++){
            listNode2.next = new ListNode(int2[i]);
            listNode2 = listNode2.next;
        }

        ListNode res = new AddTwoNumbersAsList().addTwoNumbers(fListNode1, fListNode2);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;

        int carry = 0;
        ListNode temp = null;
        ListNode res = null;
        int i = 0;
        while(a != null && b != null){
            int val = a.val + b.val + carry;
            carry = val / 10;
            val = val % 10;
            if(i == 0) {
                temp = new ListNode(val);
                res = temp;
                i++;
                a = a.next;
                b = b.next;
                continue;
            }

            temp.next = new ListNode(val);
            temp = temp.next;
            a = a.next;
            b = b.next;
        }

        while(a != null){
            int val = a.val + carry;
            carry = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            a = a.next;
        }

        while(b != null){
            int val = b.val + carry;
            carry = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            b = b.next;
        }

        while(carry > 0){
            temp.next = new ListNode(carry % 10);
            temp = temp.next;
            carry /= 10;
        }

        return res;

    }
}
