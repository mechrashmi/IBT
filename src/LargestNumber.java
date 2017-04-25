import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;

/**
 * Created by rashmimech on 1/26/17.
 */
public class LargestNumber {
    public static void main(String[] args) {
      LargestNumber test = new LargestNumber();
      Integer[] l = new Integer[]{3436, 346, 37, 3};
      final List<Integer> list = Arrays.asList(l);
      final ArrayList<Integer> arrayList = new ArrayList<>(list);
        System.out.println(test.largestNumber(arrayList));
    }

    public String largestNumber(final List<Integer> a) {
        String res = "";
        if(a.size() == 0) return res;
        Queue<Integer> list = new PriorityQueue<Integer>(a.size(), comparator);
        for(int i = 0; i < a.size(); i++){
            list.add(a.get(i));
        }

        while(list.size() > 0){
            Integer val = list.poll();
            res += "" + val;
        }

        return res;
    }

    public static Comparator<Integer> comparator = new Comparator<Integer>(){

        @Override
        public int compare(Integer c1, Integer c2) {
            String temp1 = c1 + "" + c2;
            String temp2 = c2 + "" + c1;
            return temp2.compareTo(temp1);

        }
    };
}
