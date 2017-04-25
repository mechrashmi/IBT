import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by rashmimech on 2/26/17.


 Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is maximum possible AND
 j < i AND
 A[j] < A[i]

 Elements for which no smaller element exist, consider next smaller element as -1.

 Example:

 Input : A : [4, 5, 2, 10]
 Return : [-1, 4, -1, 2]

 Example 2:

 Input : A : [3, 2, 1]
 Return : [-1, -1, -1]

 */
public class NearestSmallestElement {
    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{4, 5, 2, 10};
        Integer[] arr = new Integer[]{3, 2, 1};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(new NearestSmallestElement().prevSmaller(arrayList));
    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> stackOfElement = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer ele: arr){
            while(!stackOfElement.isEmpty()){
                Integer stackEle = stackOfElement.peek();
                if(ele > stackEle){
                    res.add(stackEle);
                    stackOfElement.push(ele);
                    break;
                }

                stackOfElement.pop();
            }

            if(stackOfElement.isEmpty()){
                res.add(-1);
                //continue;
            }

            stackOfElement.push(ele);

        }

        return res;
    }
}
