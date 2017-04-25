/**
 * Created by rashmimech on 2/25/17.
 *
 *
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 */
public class PartitionAList {
    public static void main(String[] args) {
        //Integer[] input = new Integer[]{1, 4, 3, 2, 5, 2};
        Integer[] input = new Integer[]{ 18 , 595 , 253 , 7 , 984 , 914 , 903 , 992 , 522 , 784 , 55 , 910 , 123 , 133 , 936 , 38 , 774 , 868 , 204 , 727 , 927 , 981 , 766 , 619 , 848 , 398 , 782 , 460 , 444 , 805 , 62 , 154 , 35 , 261 , 202 , 622 , 472 , 151 , 590 , 270 , 115 , 773 , 332 , 928 , 298 , 597 , 150 , 704 , 229 , 205 , 501 , 284 , 497 , 305 , 864 , 368 , 995 , 731 , 255 , 712 , 614 , 179 , 756 , 432 , 415 , 734 , 449 , 85 , 817 , 686 , 829 , 12 , 564 , 427 , 711 , 275 , 109 , 641 , 344 , 934 , 760 , 551 , 958 , 540 , 446};
        ListNode A = new ListNode(input[0]);
        ListNode first = A;
        for(int i = 1; i < input.length; i++){
            ListNode n = new ListNode(input[i]);
            A.next = n;
            A = n;
        }

        ListNode res = new PartitionAList().partition(first, 34);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode partition(ListNode a, int b) {
        ListNode pos = a;
        ListNode prev = null;
        while(pos.val < b){
            prev = pos;
            pos = pos.next;
        }

        ListNode prevcurr = prev;
        ListNode curr = pos;
        while( curr != null){
            if(curr.val < b){
                prevcurr.next = curr.next;
                ListNode temp = curr;
                temp.next = pos;
                if(prev != null){
                    prev.next = temp;
                }
                else{
                    a = temp;
                }
                prev = temp;
                curr = prevcurr.next;
                continue;
            }

            prevcurr = curr;
            curr = curr.next;
        }

        return a;

    }
}
