import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/16/17.
 */
public class MergeTwoArrays {
    public static void main(String[] args) {
        MergeTwoArrays test = new MergeTwoArrays();
        Integer a[] = new Integer[] {-4, -3, 0 };
        List<Integer> aT = Arrays.asList(a);
        ArrayList<Integer> aF = new ArrayList<Integer>(aT);

        Integer b[] = new Integer[] {2};
        List<Integer> bT = Arrays.asList(b);
        ArrayList<Integer> bF = new ArrayList<Integer>(bT);

        test.merge(aF, bF);

        for(int i =0; i < aF.size(); i++){
            System.out.println(aF.get(i));
        }
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;
        for(; i < a.size() && j < b.size(); ){
            int valA = a.get(i);
            int valB = b.get(j);
            if(valA > valB){
                a.add(i, valB);
                i++;
                j++;
            }else if(valB > valA){
                i++;
            }
            else{
                a.add(i, valB);
                i++;
                j++;
            }
        }

        while(j < b.size()){
            a.add(b.get(j));
            j++;
        }


    }
}
