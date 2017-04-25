import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/17/17.
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros tester = new SetMatrixZeros();
        List<Integer> testCase ;
        //Integer a[][] = new Integer[][] {{0, 1}, {1, 1}};
        Integer a[][] = new Integer[][] {{0, 0}, {1, 1}};
       /* Integer a[][] = new Integer[][] {{1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1}};*/
        List<Integer[]> list = Arrays.asList(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        for(Integer[] array : list){
            ArrayList<Integer> arrayInside = new ArrayList<>(Arrays.asList(array));
            result.add(arrayInside);
        }

        tester.setZeroes( result);
    }
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                Integer value = a.get(i).get(j);

                if(value.equals(0)){
                    a.get(i).set(j, -1);
                    setAllRowAndCol(a, i, j);

                }
            }
        }


        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++) {
                Integer value = a.get(i).get(j);

                if(value.equals(-1)){
                    a.get(i).set(j, 0);
                }
            }
        }
    }

    private void setAllRowAndCol(ArrayList<ArrayList<Integer>> a, int row, int col) {
        for(int i = 0; i < a.get(row).size(); i++){
            int val = a.get(row).get(i);
            if(i != col &&  val == 0){
                //a.get(row).set(i, -1);
                //setAllRowAndCol(a, row, i);
                continue;
            }

            a.get(row).set(i, -1);

        }

        for(int i = 0; i < a.size(); i++){
            int val = a.get(i).get(col);
            if(i != row &&  val == 0){
                //a.get(i).set(col, -1);
                //setAllRowAndCol(a, i, col);
                continue;
            }

            a.get(i).set(col, -1);

        }
    }

    public <T> List<T> twoDArrayToList(T[][] twoDArray) {
        ArrayList<T> list = new ArrayList<T>();
        for (T[] array : twoDArray) {
            list.addAll(Arrays.asList(array));
        }
        return list;
    }
}
