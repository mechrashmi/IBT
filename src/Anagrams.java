import java.util.*;

/**
 * Created by rashmimech on 3/26/17.
 Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'

 Note: All inputs will be in lower-case.

 Example :

 Input : cat dog god tca
 Output : [[1, 4], [2, 3]]

 cat and tca are anagrams which correspond to index 1 and 4.
 dog and god are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j
 */


public class Anagrams {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> stringToIndexMap = new HashMap<>();
        int i = 0;
        for(String val : a){
            char[] chars = val.toCharArray();
            Arrays.sort(chars);
            val = new String(chars);
            if(!stringToIndexMap.containsKey(val)) {
                stringToIndexMap.put(val, new ArrayList<Integer>());
            }
            stringToIndexMap.get(val).add(i);
            i++;
        }

        for(String val : stringToIndexMap.keySet()){
            res.add(stringToIndexMap.get(val));
        }

        return res;
    }
}
