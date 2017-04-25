import java.util.ArrayList;

/**
 * Created by rashmimech on 1/26/17.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle test = new PascalTriangle();
        System.out.println(test.getRow(3));

        System.out.println(test.generate(3));
    }

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        a--;

        while(a >= 0){
            res.add(1, res.get(0));
            for(int i = 2; i < res.size(); i++){
                res.set(i - 1, res.get(i) + res.get(i -1));
            }
            a--;
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempRow = new ArrayList<Integer>();
        tempRow.add(1);
        res.add(tempRow);
        int k = 0;
        a--;
        k++;
        while(a >= 0){
            tempRow = new ArrayList<Integer>(res.get(k - 1));
            tempRow.add(1, tempRow.get(0));
            for(int i = 2; i < tempRow.size(); i++){
                tempRow.set(i - 1, tempRow.get(i) + tempRow.get(i - 1));
            }
            res.add(tempRow);
            a--;
            k++;
        }

        return res;
    }
}
