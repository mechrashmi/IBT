import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashmimech on 1/15/17.
 */
public class IntersectionOfSortedArray {

    public static void main(String[] args) {
        IntersectionOfSortedArray ia = new IntersectionOfSortedArray();
        List<Integer> a = new ArrayList<>();
        /*a.add(1);
        a.add(2);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        a.add(10);
        a.add(10);
        a.add(12);
        a.add(13);
        a.add(14);
        a.add(15);*/
        a.add(10000000);
        List<Integer> b = new ArrayList<>();
        b.add(10000000);
        /*b.add(3);
        b.add(9);
        b.add(11);
        b.add(11);
        b.add(12);
        b.add(12);
        b.add(15);*/
        System.out.println(ia.intersect(a, b));

        //System.out.println("1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101".replaceAll(",", ""));
        System.out.println("2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2".replaceAll(",", ""));
       // System.out.println("5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98".replaceAll(",", ""));

    }

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        if(a.size() == 0 || b.size() == 0) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int j = 0;
        for(int i = 0; i < a.size() && j < b.size();){
            //System.out.println("hi Out: " + a.get(i) + ":" + b.get(j));
            int aVal = a.get(i);
            int bval = b.get(j);
            if(aVal == bval){
                System.out.println("hi");
                result.add(a.get(i));
                j++;
                i++;
            }
            else if(aVal > bval){
                j++;
            }
            else if(aVal > bval){
                i++;
            }
            else{

                System.out.println("hi Else");}

        }
        return result;
    }
}
