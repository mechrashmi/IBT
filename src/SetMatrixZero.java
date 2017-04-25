import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 2/21/17.
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        //Integer[][] list = new Integer[][]{{1, 1, 1},{1, 1, 1},{1, 1, 0}};
        Integer[][] list = new Integer[][]{{0, 1},{1, 1}};
       /* Integer[][] list = new Integer[][]{{0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}};*/
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < list.length; i++){
            ArrayList<Integer> ele = new ArrayList<>(Arrays.asList(list[i]));
            arrayLists.add(ele);
        }
        new SetMatrixZero().setZeroes(arrayLists);

        System.out.println(arrayLists);
    }
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean R = false;
        boolean C = false;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i).get(0).intValue() == 0){
                C = true;
                break;
            }
        }

        for(int j = 0; j < a.get(0).size(); j++){
            if(a.get(0).get(j).intValue() == 0){
                R = true;
                break;
            }
        }

        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                int val = a.get(i).get(j);
                if(val == 0){
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }


        for(int i = 1; i < a.size(); i++){
            int val = a.get(i).get(0);
            if(val == 0){
                for(int j = 1; j < a.get(i).size(); j++){
                    a.get(i).set(j, 0);
                }
            }
        }

        for(int j = 1; j < a.get(0).size(); j++){
            int val = a.get(0).get(j);
            if(val == 0){
                for(int i = 0; i < a.size(); i++){
                    a.get(i).set(j, 0);
                }
            }
        }

        //Setting first row
        if(C){

            for(int i = 0; i < a.size(); i++){
                a.get(i).set(0, 0);
            }

        }

        if(R){

            for(int i = 0; i < a.get(0).size(); i++){
                a.get(0).set(i, 0);

            }
        }

    }
}
