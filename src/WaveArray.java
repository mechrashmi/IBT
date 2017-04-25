import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rashmimech on 1/22/17.
 */
public class WaveArray {
    public static void main(String[] args) {
        Integer a[] = new Integer[] { 5, 1, 3, 2, 4 };
        List<Integer> aT = Arrays.asList(a);
        ArrayList<Integer> aF = new ArrayList<Integer>(aT);
        WaveArray tester = new WaveArray();
        System.out.println(tester.wave(aF));

    }
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        //ArrayList<Integer> res = new ArrayList<Integer>();
        Collections.sort(a);
        boolean g = true;
        int i = 0;
        for(int j = 1; j < a.size(); j++){
            int ai = a.get(i), aj = a.get(j);
            if(g){
                if(ai < aj){
                    int temp = ai;
                    a.set(i, aj);
                    a.set(j, temp);
                }
                i++;
                g = false;
            }
            else{
                if(ai > aj){
                    int temp = ai;
                    a.set(i, aj);
                    a.set(j, temp);
                }
                i++;
                g = true;
            }

        }

        return a;
    }
}
