import java.util.ArrayList;

/**
 * Created by rashmimech on 2/6/17.
 */
public class PrettyPrint {
    public static void main(String[] args) {
        PrettyPrint tester = new PrettyPrint();
        ArrayList<ArrayList<Integer>> output = tester.prettyPrint(6);

        for(int i = 0; i < output.size(); i++){
            for(int j = 0; j < output.get(i).size(); j++){
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }
        //System.out.println(tester.prettyPrint(3));
    }
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        if(a == 0) return null;

        int n = 2 * a - 1;

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n ; j++){
                temp.add(0);
            }
            res.add(temp);
        }

        Integer level = 0; Integer dir = 1; Integer col = 0; Integer row = 0;

        for(int i = 1; i <= n * n; i++){
            if(res.get(row).get(col).equals(0))
                res.get(row).set(col, a);
            switch (dir){
                case 1:
                    if(col == ((n - 1) - level)){
                        dir = 2;
                        row++;
                    } else {
                        col++;
                    }
                    break;
                case 2:
                    if(row == ((n - 1) - level)){
                        dir = 3;
                        col--;
                    }else {
                        row++;
                    }
                    break;
                case 3:
                    if(col == level){
                        dir = 4;
                        row--;
                    }else{
                        col--;
                    }
                    break;
                case 4:
                    if(row == level + 1){
                        dir = 1;
                        a--;
                        level++;
                        col = level;
                        row = level;
                    }else{
                        row--;
                    }
                    break;
            }
        }

        //res.get(row).set(col, a);
        return res;

    }
}
