import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 3/29/17.


 Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: Using library sort function is not allowed.

 Example :

 Input : [0 1 2 0 1 2]
 Modify array so that it becomes : [0 0 1 1 2 2]


 Solution:



 There are multiple approaches possible here. We need to make sure we do not allocate extra memory.

 Approach 1:
 > Count the number of red, white and blue balls.
 > Then in another pass, set initial redCount number of cells as 0, next whiteCount cell as 1 and next bluecount cells as 2.
 *Requires 2 pass of the array. *

 **Approach 2: **
 > Swap the 0s to the start of the array maintaining a pointer, and 2s to the end of the array.
 > 1s will automatically be in their right position.

 */

public class SortByColor {
    public static void main(String[] args) {
       // Integer[] list = new Integer[]{0, 1, 2, 0, 1, 2, 0, 0, 0, 0};
        Integer[] list = new Integer[]{0};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(list));
        SortByColor tester = new SortByColor();
        tester.sortColors(arrayList);

        for(int i = 0; i < arrayList.size(); i++)
        {
            System.out.print(arrayList.get(i) + " ");
        }
    }

    public void sortColors(ArrayList<Integer> a) {
        int count = 0;
        int i = 0;
        while(count < 2){
            while(i < a.size() && a.get(i) == count){
                i++;
            }
            if(i == a.size()) break;

            for(int j = i + 1; j < a.size(); j++){
                if(a.get(j) == count){
                    int temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                    i++;
                }
            }
            count++;
        }
    }
}
