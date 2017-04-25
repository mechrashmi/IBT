import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 1/28/17.
 */
public class RotateMatrix {
    public static void main(String[] args) {
       // Integer[][] l = new Integer[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        //Integer[][] l = new Integer[][]{{1}};
        Integer[][] l = new Integer[][]{{1, 2}, {3, 4}};
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < l.length; i++){
            arrayLists.add(new ArrayList<>(Arrays.asList(l[i])));
        }

        RotateMatrix tester = new RotateMatrix();
        tester.rotate(arrayLists);
        System.out.println(arrayLists);
    }
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 1 || a.size() == 0 || a == null) return;

        int n = a.size() - 1;
        int ele = 0; // to remove upper and lower elements in different layers
        for(int level = 0; level < (a.size()/2); level++){
            System.out.println();

            for(int i = 0; i < (n - (level + ele)); i++){
                int r1 = (n - level) - i; int c1 = level;
                int r2 = level;           int c2 = level + i;
                int r3 = level + i;       int c3 = n - level;
                int r4 = n - level;       int c4 = (n - level) - i;

                int temp1 = a.get(r1).get(c1);
                int temp2 = a.get(r2).get(c2);
                a.get(r2).set(c2, temp1);
                int temp3 = a.get(r3).get(c3);
                a.get(r3).set(c3, temp2);
                int temp4 = a.get(r4).get(c4);
                a.get(r4).set(c4, temp3);
                a.get(r1).set(c1, temp4);
            }
            ele++;
        }
    }
}
