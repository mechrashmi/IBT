import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 1/26/17.
 */
public class DiagonalMatrix {

    public static void main(String[] args) {
        DiagonalMatrix test = new DiagonalMatrix();
        //Integer[][] l = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] l = new Integer[][]{{1}};
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>() ;
        for(int i = 0; i < l.length; i++){
            List<Integer> tempL = Arrays.asList(l[i]);
            ArrayList<Integer> temp = new ArrayList<>(tempL);
            lists.add(temp);
        }

        System.out.println(test.diagonal(lists));
        System.out.println(test.diagonalDifferentSolution(lists));
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(a.size() == 0) return res;
        int N = a.size();
        int dir = 0;
        int mR = 0; int mC = 0;
        int cR = 0; int cC = 0;
        int addRow = 1;
        res.add(new ArrayList<>());
        res.get(mR).add(a.get(mR).get(mC));

        while(mR < N && mC < N){
            switch(dir){
                case 0:
                    if(mC == N - 1){
                        mR++;
                        dir = 1;
                    }
                    else
                    {
                        mC++;
                    }
                    break;
                case 1:
                    if(mR == N - 1){
                        dir = 2;
                    }
                    else{
                        mR++;
                    }
                    break;
            }

            if(dir == 2) break;

            res.add(new ArrayList<Integer>());
            cR = mR; cC = mC;
            while(cC >= 0 && cR < N){
                int val = a.get(cR).get(cC);
                res.get(addRow).add(val);
                cC--; cR++;
            }
            addRow++;
        }

        return res;
    }


//Adding an element in each row
    public ArrayList<ArrayList<Integer>> diagonalDifferentSolution(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < (a.size() * 2 - 1); i++){
            res.add(new ArrayList<>());
        }
        int N = a.size();
        int dir = 0;
        int cR = 0; int cC = 0; int level = 1; int addRow = 1;
        res.get(cR).add(a.get(cR).get(cC));
        for(int i = 0; i < N * N; i++){
            switch(dir){
                case 0:
                    if(cC == (N - level)){
                        dir = 1;
                        cR++;
                    }else {
                        cC++;
                    }
                    break;
                case 1:
                    if(cR == N - 1){
                        dir = 0;
                        level ++;
                        cC = 0;
                        cR = level - 1;
                        addRow = level - 1;
                    }
                    else{
                        cR++;
                    }
                    break;
            }
            if(cR >= N) break;
            int val = a.get(cR).get(cC);
            res.get(addRow).add(val);
            addRow ++;

        }
        return res;
    }
}
