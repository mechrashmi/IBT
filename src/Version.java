import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 2/1/17.
 */
public class Version {
    public static void main(String[] args) {
        Version test = new Version();
        System.out.println(test.compareVersion("00000000000000000000000000000000000000000000000000000000005", "5.0.0.0"));
    }
    public int compareVersion(String a, String b) {
        ArrayList<String> arrAList = new ArrayList<String>(Arrays.asList(a.split("\\.")));
        ArrayList<String> arrBList = new ArrayList<String>(Arrays.asList(b.split("\\.")));
        for(int i = 0; i < arrAList.size(); i++){
            String temp = arrAList.get(i);
            if(temp.charAt(0) == '0'){
                int j = 0;
                while(j < temp.length()){
                    if(temp.charAt(j) == '0'){
                        j++;
                    }
                    else{
                        break;
                    }
                }

                if(j == temp.length()){
                    arrAList.remove(temp);
                    i--;
                }else{
                    temp = temp.substring(j, temp.length());
                    arrAList.set(i, temp);
                }

            }
        }

        for(int i = 0; i < arrBList.size(); i++){
            String temp = arrBList.get(i);
            if(temp.charAt(0) == '0'){
                int j = 0;
                while(j < temp.length()){
                    if(temp.charAt(j) == '0'){
                        j++;
                    }
                    else{
                        break;
                    }
                }

                if(j == temp.length()){
                    arrBList.remove(temp);
                    i--;
                }else{
                    temp = temp.substring(j, temp.length());
                    arrBList.set(i, temp);
                }

            }
        }
        int l1 = arrAList.size();
        int l2 = arrBList.size();
        int l = Math.min(l1, l2);

        for (int i = 0; i < l; i++) {
            String aStr = arrAList.get(i);
            String bStr = arrBList.get(i);

           int k = 0; int m = 0;
           /* int aZ = 0; int bZ = 0;
            while(k < aStr.length()){
                if(aStr.charAt(k) == '0'){
                    k++;
                    aZ++;
                }
                else{
                    break;
                }
            }

            while (m < bStr.length()){
                if(bStr.charAt(m) == '0'){
                    m++;
                    bZ++;
                }
                else{
                    break;
                }
            }*/

            while(k < aStr.length() && m < bStr.length()){
                if(aStr.charAt(k) > bStr.charAt(m) && aStr.length() >= bStr.length()){
                    return 1;
                }
                else if(aStr.charAt(k) < bStr.charAt(m) && bStr.length() >= aStr.length()){
                    return -1;
                }
                else{
                    m++;
                    k++;
                }
            }

            if(aStr.length() > bStr.length()){
                return 1;
            }

            if(aStr.length() < bStr.length()){
                return -1;
            }

        }
        if (l1 > l2) {
            return 1;
        }
        if (l2 > l1) {
            return -1;
        }
        return 0;
    }
}
