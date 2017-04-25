import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rashmimech on 3/25/17.


 Find the kth smallest element in an unsorted array of non-negative integers.

 Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )

 NOTE
 You are not allowed to modify the array ( The array is read only ).
 Try to do it using constant extra space.

 Example:

 A : [2 1 4 3 2]
 k : 3

 answer : 2
 */
public class kThSmallestElementInAnArray {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 1, 4, 3, 2};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println(new kThSmallestElementInAnArray().kthsmallest(arrayList, 3)) ;
    }

    public int kthsmallest(final List<Integer> a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < a.size(); i++){
            minHeap.add(a.get(i));
        }

        int result = 0;
        for(int i = 0;i < k; i++){
            result = minHeap.poll();
        }

        return result;
    }
}
