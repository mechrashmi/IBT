import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rashmimech on 2/21/17.
 */
public class GenerateGreatestNumberByMergingTheElementsInTheArray {

    public static void main(String[] args) {
        GenerateGreatestNumberByMergingTheElementsInTheArray tester = new GenerateGreatestNumberByMergingTheElementsInTheArray();
        Integer[] intarr = new Integer[]{0, 0, 0, 0, 0};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(intarr));
        System.out.println(tester.largestNumber(arrayList));
    }

    public String largestNumber(final List<Integer> a) {
        ArrayList<NumberNode> numList = new ArrayList<>();
        StringBuilder res = new StringBuilder("");
        boolean allzeros = a.get(0).intValue() == 0? true : false;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).intValue() != 0){
                allzeros = false;
            }
            NumberNode currEle = new NumberNode(a.get(i));
            numList.add(currEle);
        }
        if(allzeros){
            res = new StringBuilder("0");
            return res.toString();
        }

        Collections.sort(numList);

        for(int i = 0; i < a.size(); i++){
            res.append(numList.get(i).num);
        }

        return res.toString();
    }

    public class NumberNode implements Comparable<NumberNode>{
        Integer num;

        NumberNode(Integer num){
            this.num = num;
        }

        @Override
        public int compareTo(NumberNode o) {
            /*Long num1 = Long.parseLong(num + "" + o.num);
            Long num2 = Long.parseLong(o.num + "" + num);
            if(num1 > num2){
                return -1;
            }

            if(num2 > num1){
                return 1;
            }

            return 0;*/

            String str1 = num + "" + o.num;
            String str2 = o.num + "" + num;

            return str1.compareTo(str2);
        }
    }
}
