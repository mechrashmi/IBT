/**
 * Created by rashmimech on 2/26/17.
 */
public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,3,4,4,5};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        ListNode res = new RemoveDuplicatesfromSortedListII().deleteDuplicates(first);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    //1,2,3,3,4,4,5
    public ListNode deleteDuplicates(ListNode a) {
        if(a == null) return null;

        if(a.next == null) return a;

        ListNode n1 = a;
        ListNode n2 = a.next;
        ListNode res = null;
        ListNode resultNode = null;
        boolean dup = false;
        while(n2 != null){
            if(n1.val == n2.val){
                dup = true;
            }
            else if(n1.val != n2.val && !dup){
                if(res == null){
                    res = new ListNode(n1.val);
                    resultNode = res;
                }else{
                    res.next = new ListNode(n1.val);
                    res = res.next;
                }
                n1 = n2;
            }else if(n1.val != n2.val && dup){
                dup = false;
                n1 = n2;
            }

            n2 = n2.next;

        }

        if(!dup){
            res.next = new ListNode(n1.val);
        }


        return resultNode;

    }
}
