import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by rashmimech on 3/26/17.
 Programming Checkpoint: Level 4 Nextgreater

 NEXTGREATER

 Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is minimum possible AND
 j > i AND
 A[j] > A[i]

 Elements for which no greater element exist, consider next greater element as -1.

 Example:

 Input : A : [4, 5, 2, 10]
 Output : [5, 10, 10, -1]

 Example 2:

 Input : A : [3, 2, 1]
 Output : [-1, -1, -1]
 Notes
 All Notes

 */
public class NextGreater {
    public static void main(String[] args) {
       // Integer[] array = new Integer[]{3, 2, 1};
        Integer[] array = new Integer[]{4, 5, 2, 10};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        ArrayList<Integer> res = new  NextGreater().nextGreater(arrayList);

        for(int i= 0; i < res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }

    public ArrayList<Integer> nextGreaterTwoLoopSolution(ArrayList<Integer> a) {

        for(int i = 0; i < a.size(); i++){
            int j = i + 1;
            for(j = i + 1; j < a.size(); j++){
                if(a.get(j) > a.get(i)){
                    a.set(i, a.get(j));
                    break;
                }
            }

            if(j == a.size()){
                a.set(i, -1);
            }
        }

        return a;
    }

    //Solution with a stack
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < a.size(); i++){
            int val = a.get(i);
            while (!stack.isEmpty()){
                int j = stack.peek();
                if(val > a.get(j)){
                    a.set(j, val);
                    stack.pop();
                }
                else
                {
                    break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            a.set(j, -1);
        }

        return  a;

    }
}
